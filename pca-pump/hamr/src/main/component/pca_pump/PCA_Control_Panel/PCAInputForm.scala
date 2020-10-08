package pca_pump.PCA_Control_Panel

import java.awt._
import java.awt.event._

import art.Art.{PortId, Time}
import art._
import javax.imageio.ImageIO
import javax.sound.sampled.{AudioInputStream, AudioSystem, Clip}
import javax.swing._
import org.sireum._
import pca_pump._
import pca_pump.util.AuxLibrary

import scala.collection.mutable.{Map, Set}

class PCAInputForm() {

  val SHOW_MOUSE_COORDS = false

  type eventFunc = () => Unit

  var frame: JFrame = _

  var alarmArea: JTextArea = _
  var drugNameDisplay: JTextArea = _
  var concentrationDisplay: JTextArea = _
  var messageArea: JTextArea = _
  var infusedAmountArea: JTextArea = _
  var systemStatusArea: JTextArea = _
  var flowRateArea: JTextArea = _

  val eventMap: Map[PCA_Types.Button_Id.Type, Set[eventFunc]] = Map.empty[PCA_Types.Button_Id.Type, Set[eventFunc]]

  def registerListener(e: PCA_Types.Button_Id.Type, f: eventFunc): Unit = {
    if (!eventMap.contains(e)) {
      eventMap(e) = Set.empty[eventFunc]
    }
    eventMap(e) = eventMap(e) ++ Set(f)
  }

  def processEvent(e: PCA_Types.Button_Id.Type): Unit = {
    if (eventMap.contains(e))
      eventMap(e).foreach(f => f())
  }


  val emptyPayload = art.Empty()

  def getBridge(name: String): art.Bridge =
    art.Art.bridges.elements.filter(_.nonEmpty).map(_.get).filter(_.name == name).head

  def getUPort(name: String): art.UPort =
    art.Art.ports.elements.filter(_.nonEmpty).map(_.get).filter(_.name == name).head

  val reservoirState: Option[PCA_Mechanical.Wrapper] =
    art.ArtDebug.getDebugObject(PCA_Mechanical.drug_reservoir_imp_pump_fluid_reservoir.debugKey)

  def init(): Unit = {
    val width = 1000

    frame = new JFrame("PCA Controller")

    frame.setPreferredSize(new Dimension(width, 800))
    var img = ImageIO.read(getClass.getResourceAsStream("background.png"))
    frame.setContentPane(new JLabel(new ImageIcon(img.getScaledInstance(1400, 1000, java.awt.Image.SCALE_SMOOTH))))

    val pane = frame.getContentPane
    frame.getContentPane.setLayout(null)

    pane.addMouseMotionListener(new MouseMotionListener {
      override def mouseDragged(e: MouseEvent): Unit = {}

      override def mouseMoved(e: MouseEvent): Unit = {
        if(SHOW_MOUSE_COORDS)
          println(s"${e.getX}, ${e.getY}")
      }
    })

    def makeComboBox(items: Array[Predef.String], prompt: Predef.String): JComboBox[Predef.String] = {
      val cb = new JComboBox[Predef.String](items)
      //cb.setBounds(65, 380, size.width, size.height)
      cb.setSelectedIndex(-1)
      cb.setRenderer(new JLabel with ListCellRenderer[Predef.String] {
        override def getListCellRendererComponent(l: JList[_ <: Predef.String], v: Predef.String, i: Int, s: Boolean, f: Boolean): Component = {
          if(i == -1 && v == null) setText(prompt)
          else setText(v)
          return this
        }
      })
      cb
    }

    def injectScannerPayload(payload: PCA_Types.Scan_Data_Type_Payload) : Unit = {

      val scannerBridge: art.Bridge = getBridge("wrap_pca_imp_Instance_pump_operation_scanner")
      val scannerBridge_Scan_Data: art.UPort = getUPort("wrap_pca_imp_Instance_pump_operation_scanner_Scan_Data")
      val scannerBridge_Scan_Done: art.UPort = getUPort("wrap_pca_imp_Instance_pump_operation_scanner_Scan_Done")

      // send scanned data from scanner to security thread
      art.ArtDebug.injectPort(scannerBridge.id, scannerBridge_Scan_Data.id, payload)

      // send Scan_Done from scanner to boss thread
      art.ArtDebug.injectPort(scannerBridge.id, scannerBridge_Scan_Done.id, emptyPayload)
    }

    val left = 63
    val clinicians: Array[Predef.String] = AuxLibrary.getClinicians().elements.map(_.toString).toArray
    val cbClinicians = makeComboBox(clinicians, "Scan Clinician Badge")
    val size = cbClinicians.getPreferredSize
    size.setSize(size.getWidth, size.getHeight - 6)
    cbClinicians.setBounds(left, 344, size.width, size.height)
    cbClinicians.addActionListener(_ => {
      var item = cbClinicians.getSelectedItem.asInstanceOf[Predef.String]
      var scannerPayload = PCA_Types.Scan_Data_Type_Payload(PCA_Types.Scan_Clinican_Badge(item))
      injectScannerPayload(scannerPayload)
    })
    pane.add(cbClinicians)

    val patients: Array[Predef.String] = AuxLibrary.getPatients().elements.map(_.toString).toArray
    val cbPatients = makeComboBox(patients, "Scan Patient Wristband")
    cbPatients.setBounds(left, cbClinicians.getY + cbClinicians.getHeight, size.width, size.height)
    cbPatients.addActionListener(_ => {
      var item = cbPatients.getSelectedItem.asInstanceOf[Predef.String]
      var scannerPayload = PCA_Types.Scan_Data_Type_Payload(PCA_Types.Scan_Patient_Wristband(item))
      injectScannerPayload(scannerPayload)
      cbPatients.setEnabled(false)
    })
    pane.add(cbPatients)

    val prescriptions: Array[Predef.String] = AuxLibrary.getPrescriptions().elements.map(p => s"${p.patient}:${p.drugName}").toArray
    val cbPrescriptions = makeComboBox(prescriptions, "Scan Prescription")
    cbPrescriptions.setBounds(left, cbPatients.getY + cbPatients.getHeight, size.width, size.height)
    cbPrescriptions.addActionListener(_ => {
      val item = cbPrescriptions.getSelectedItem.asInstanceOf[Predef.String]
      val arr = item.split(":")
      val scannerPayload = PCA_Types.Scan_Data_Type_Payload(PCA_Types.Scan_Prescription_Vial(arr(0), arr(1)))
      injectScannerPayload(scannerPayload)
      cbPrescriptions.setEnabled(false)
    })
    pane.add(cbPrescriptions)


    def newHiddenButton(tooltip: String, x: Int, y: Int, width: Int, height: Int,
                        optOpacity: Option[Float] = None[Float]()): JButton = {
      val defaultOpacity = if(optOpacity.nonEmpty) optOpacity.get else 0.0f
      val pressedOpacity = 0.5f
      var opacity = defaultOpacity
      val b = new JButton() {
        override def paint(g: Graphics): Unit = {
          val g2 = g.create().asInstanceOf[Graphics2D]
          g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity))
          super.paint(g2)
          g2.dispose()
        }
      }

      b.addMouseListener(new MouseAdapter {
        override def mousePressed(e: MouseEvent): Unit = {
          opacity = pressedOpacity
          b.repaint()
        }

        override def mouseReleased(e: MouseEvent): Unit = {
          opacity = defaultOpacity
          b.repaint()
        }
      })
      b.setToolTipText(tooltip.toString)
      b.setBounds(x, y, width, height)
      //b.setOpaque(false)
      //b.setContentAreaFilled(false)
      //b.setBorderPainted(false)
      b
    }

    val btnDoor = newHiddenButton("", 634, 403, 71, 72)
    btnDoor.addActionListener(_ => {
      reservoirState.get.doorOpen = !reservoirState.get.doorOpen
    })
    pane.add(btnDoor)

    val btnStart = newHiddenButton("Start", 517, 650, 72, 33)
    btnStart.addActionListener(_ => processEvent(PCA_Types.Button_Id.Start_Button_Pressed))
    pane.add(btnStart)

    val btnStop = newHiddenButton("Stop", 516, 690, 72, 33)
    btnStop.addActionListener(_ => processEvent(PCA_Types.Button_Id.Stop_Button_Pressed))
    pane.add(btnStop)

    val btnPatientButton = newHiddenButton("Patient Bolus", 320, 462, 15, 18)
    btnPatientButton.addActionListener(_ => {
      // send Button_Press event to patient_button.  This is an external phenomenon
      val patient_buttonBridge: art.Bridge = getBridge("wrap_pca_imp_Instance_pump_operation_patient_button")
      val patient_button_Button_Press: art.UPort = getUPort("wrap_pca_imp_Instance_pump_operation_patient_button_Button_Press")

      art.ArtDebug.injectPort(patient_buttonBridge.id, patient_button_Button_Press.id, emptyPayload)
    })
    pane.add(btnPatientButton)

    val btnUpButton = newHiddenButton("Up", 519, 416, 20, 16)
    btnUpButton.addActionListener(_ => processEvent(PCA_Types.Button_Id.Up))
    pane.add(btnUpButton)

    val btnDownButton = newHiddenButton("Down", 519, 446, 20, 16)
    btnDownButton.addActionListener(_ => processEvent(PCA_Types.Button_Id.Down))
    pane.add(btnDownButton)

    val btnCpResetAlarm = newHiddenButton("Clear", 517, 567, 59, 61)
    btnCpResetAlarm.addActionListener(_ => processEvent(PCA_Types.Button_Id.CP_Reset_Alarm))
    pane.add(btnCpResetAlarm)


    val clinicianBolusButton = newHiddenButton("Clinician Bolus", 634, 648, 72, 73)
    clinicianBolusButton.addActionListener(_ => processEvent(PCA_Types.Button_Id.Clinician_Request_Bolus))
    pane.add(clinicianBolusButton)


    val font = new Font("Verdana", Font.BOLD, 12)

    def newTextArea(x: Int, y: Int, width: Int, height: Int, color: Option[Color] = None[Color]()) : JTextArea = {
      val j = new JTextArea
      j.setLayout(new GridLayout(0, 1))
      j.setWrapStyleWord(true)
      j.setLineWrap(true)
      j.setBounds(x, y, width, height)
      j.setVisible(true)
      j.setFont(font)
      j.setMargin(new Insets(5,5,5,5))
      j.setEditable(false)
      if(color.nonEmpty)
        j.setBackground(color.get)
      j
    }

    alarmArea = newTextArea(553, 65, 150, 43)
    pane.add(alarmArea)

    drugNameDisplay = newTextArea(519, 124, 185, 45)
    concentrationDisplay = newTextArea(519, drugNameDisplay.getY + drugNameDisplay.getHeight, 185, 45)
    messageArea = newTextArea(519, concentrationDisplay.getY + concentrationDisplay.getHeight, 185, 45)
    infusedAmountArea = newTextArea(519, messageArea.getY + messageArea.getHeight, 185, 45)
    systemStatusArea =  newTextArea(519, infusedAmountArea.getY + infusedAmountArea.getHeight, 185, 45)
    flowRateArea = newTextArea(519, systemStatusArea.getY + systemStatusArea.getHeight, 185, 45)

    pane.add(drugNameDisplay)
    pane.add(concentrationDisplay)
    pane.add(messageArea)
    pane.add(infusedAmountArea)
    pane.add(systemStatusArea)
    pane.add(flowRateArea)

    for(i <- 0 to 11) {
      val (x, y) = (i % 3, i / 3)
      val text: String = (x, y) match {
        case (1, 3) => "0"
        case (2, 3) => "."
        case _ => (i + 1).toString
      }

      if (!(x == 0 && y == 3)) {
        val b = newHiddenButton(text, 588 + (43 * x), 498 + (34 * y), 29, 25)//, Some(0.7f))
        b.addActionListener(s => {
          val t = s.getSource.asInstanceOf[JButton].getToolTipText
          flowRateArea.setText(flowRateArea.getText + t)
        })
        pane.add(b)
      }
    }

    val messagePanel = new JPanel()
    messagePanel.setPreferredSize(new Dimension(300, 600))
    messagePanel.setLayout(new GridLayout(0, 1))

    {
      messagePanel.add(new JLabel("Flow_Rate_Checker.Infusion_Flow_Rate"))
      val txtFlowRateInfusion = new JTextField
      txtFlowRateInfusion.setEnabled(false)
      messagePanel.add(txtFlowRateInfusion)

      messagePanel.add(new JLabel("Flow_Rate_Checker.Downstream_Flow_Rate"))
      val txtFlowRateDownstream = new JTextField
      messagePanel.add(txtFlowRateDownstream)


      val flow_rateBridge: art.Bridge = getBridge("wrap_pca_imp_Instance_pump_safety_alarm_process_flow_rate")
      val flow_rateBridge_Infusion_Flow_Rate: art.UPort = getUPort("wrap_pca_imp_Instance_pump_safety_alarm_process_flow_rate_Infusion_Flow_Rate")
      val flow_rateBridge_Downstream_Flow_Rate: art.UPort = getUPort("wrap_pca_imp_Instance_pump_safety_alarm_process_flow_rate_Downstream_Flow_Rate")


      // simulate measured downstream flow rate exactly matching the prescribed
      // infusion flow rate whenever the infusion flow rate changes
      var lastInfusionFlowRate: Option[DataContent] = None[DataContent]()
      ArtDebug.registerListener(
        new ArtListener() with BaseMutable {
          override def start(time: Time): Unit = { }
          override def stop(time: Time): Unit = { }

          override def output(src: PortId, dst: PortId, data: DataContent, time: Time): Unit = {
            if(dst == flow_rateBridge_Infusion_Flow_Rate.id) {
              if (lastInfusionFlowRate != Some(data)) {
                lastInfusionFlowRate = Some(data)

                val PCA_Types.Flow_Rate_imp_Payload(PCA_Types.Flow_Rate_imp(v)) = data
                txtFlowRateInfusion.setText(s"$v")

                art.ArtDebug.injectPort(flow_rateBridge.id, flow_rateBridge_Downstream_Flow_Rate.id, data)
              }
            }
          }
        }
      )

      // update flowRateDown text whenever the flow_rate device updates the downstream flow rate
      var lastDownstreamFlowRate: Option[DataContent] = None[DataContent]()
      ArtDebug.registerListener(
        new ArtListener() with BaseMutable {

          override def start(time: Time): Unit = { }
          override def stop(time: Time): Unit = { }

          override def output(src: PortId, dst: PortId, data: DataContent, time: Time): Unit = {
            if(dst == flow_rateBridge_Downstream_Flow_Rate.id) {
              if (lastDownstreamFlowRate != Some(data)) {
                lastDownstreamFlowRate = Some(data)

                val PCA_Types.Flow_Rate_imp_Payload(PCA_Types.Flow_Rate_imp(v)) = data
                txtFlowRateDownstream.setText(s"$v")
              }

            }
          }
        }
      )


      // allow user to modify the downstream flow rate
      txtFlowRateDownstream.addActionListener(_ => {
        S16(txtFlowRateDownstream.getText()) match {
          case Some(v) =>
            // modify downstream flow rate
            val payload = PCA_Types.Flow_Rate_imp_Payload(PCA_Types.Flow_Rate_imp(v))
            art.ArtDebug.injectPort(flow_rateBridge.id, flow_rateBridge_Downstream_Flow_Rate.id, payload)
          case _ =>
            println("Delta is not a valid Z16")
        }
      })

      messagePanel.add(new JLabel("Drug_Reservoir: reservoirState.volume"))
      val txtVolume = new JTextField(4)
      messagePanel.add(txtVolume)

      txtVolume.addActionListener(_ =>
        reservoirState match {
          case Some(s) =>
            val v: F32 = txtVolume.getText().toFloat
            println(s"Volume was ${s.volume} - changing to $v")
            s.volume = Physical_Types.Fluid_Volume_imp(v)
          case _ =>
        }
      )

    }

    messagePanel.setBorder(BorderFactory.createTitledBorder("Debug Panel"))
    messagePanel.setBounds(10, 80, size.width + 200, size.height + 100)

    messagePanel.setVisible(false)
    pane.add(messagePanel)

    pane.addMouseListener(new MouseAdapter {
      override def mouseReleased(e: MouseEvent): Unit = {
        if(e.getButton == MouseEvent.BUTTON3) {
          messagePanel.setVisible(!messagePanel.isVisible)
        }
      }
    })

    frame.pack()
    frame.setVisible(true)
    frame.setLocationRelativeTo(null)
    frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE)
    frame.setResizable(false)



    // inject POST_Done from error detector to Boss
    val b = getBridge("wrap_pca_imp_Instance_pump_safety_error_detect")
    val p = getUPort("wrap_pca_imp_Instance_pump_safety_error_detect_POST_Done")
    art.ArtDebug.injectPort(b.id, p.id, emptyPayload)
  }

  def dispose(): Unit = {
    frame.dispose()
  }

  def setAlarm(s: String): Unit = {
    alarmArea.setText(s.toString)
  }

  def setMessage(s: String): Unit = {
    messageArea.setText(s.toString)
  }

  def setSystemStatus(s: String): Unit = {
    systemStatusArea.setText(s.toString)
  }

  def setDrugName(s: String): Unit = {
    drugNameDisplay.setText(s.toString)
  }

  def setConcentration(s: String) : Unit = {
    concentrationDisplay.setText(s.toString)
  }

  def setInfusedAmount(s: String) : Unit = {
    infusedAmountArea.setText(s.toString)
  }

  def setFlowRate(s: String): Unit = {
    flowRateArea.setText(s.toString)
  }

  var currentSound : Option [Clip] = None[Clip]()
  def setSound(s: PCA_Types.Sound.Type) : Unit = {
    if(currentSound.nonEmpty) {
      currentSound.get.stop()
      currentSound.get.close()
      currentSound = None[Clip]()
    }

    s match {
      case PCA_Types.Sound.Beep =>
        val audioIn = AudioSystem.getAudioInputStream (getClass.getResource ("beep.wav") )
        val clip : Clip = AudioSystem.getClip
        clip.open (audioIn)
        clip.start ()
        clip.loop(Clip.LOOP_CONTINUOUSLY)
        currentSound = Some(clip)
      case PCA_Types.Sound.Silence =>
    }
  }
}

trait BaseMutable extends org.sireum.Mutable {
  private var $isOwned: Boolean = false

  override def $owned: Boolean = $isOwned

  override def $owned_=(b: Boolean): this.type = {
    this.$isOwned = b
    this
  }

  override def $clone: this.type = this

  override def string: String = toString()
}