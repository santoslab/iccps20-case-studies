package isolette.Isolette.UserInterface

import java.awt._
import java.text.DecimalFormat

import javax.swing._
import isolette._
import org.sireum.{None, Option, Some}
class Gui {

  var frame: JFrame = _
  var txtCurrTemp: JTextField = _
  var txtRegulatorStatus: JTextField = _
  var txtMonitorStatus: JTextField = _
  var txtAlarm: JTextField = _

  def init(_lowerDesiredTempWstatus: Isolette_Data_Model.TempWstatus_impl,
           _upperDesiredTempWstatus: Isolette_Data_Model.TempWstatus_impl,
           _lowerAlarmTempWstatus: Isolette_Data_Model.TempWstatus_impl,
           _upperAlarmTempWstatus: Isolette_Data_Model.TempWstatus_impl): Unit = {
    val width = 500
    frame = new JFrame("Isolette")

    frame.setPreferredSize(new Dimension(width,300))

    val pane = frame.getContentPane
    val layout = new GridBagLayout()
    frame.getContentPane.setLayout(layout)
    val gbc = new GridBagConstraints()

    gbc.fill = GridBagConstraints.HORIZONTAL

    var y = 0

    def addTxtField(name: String): JTextField = {
      gbc.gridx = 0
      gbc.gridy = y
      val lbl = new JLabel(name)
      pane.add(lbl, gbc)

      gbc.gridx = 1
      val txtf = new JTextField()
      txtf.setPreferredSize(new Dimension(70, 24))
      txtf.setEditable(false)
      pane.add(txtf, gbc)

      y = y + 1

      txtf
    }

    txtCurrTemp = addTxtField("Current Temperature")
    txtRegulatorStatus = addTxtField("Regulator Status")
    txtMonitorStatus = addTxtField("Monitor Status")
    txtAlarm = addTxtField("Alarm")


    def addSpinner(name: String, initValue: Float, low: Float, high: Float, callback: (JSpinner) => Unit): Unit = {
      gbc.gridx = 0
      gbc.gridy = y
      pane.add(new JLabel(name), gbc)
      gbc.gridx = 1

      var spinner: JSpinner = new JSpinner(new SpinnerNumberModel(initValue, low, high, 0.1))
      spinner.setEditor(new JSpinner.NumberEditor(spinner, "0.0"))
      spinner.getEditor.asInstanceOf[JSpinner.NumberEditor].getTextField.setHorizontalAlignment(SwingConstants.LEFT)
      spinner.addChangeListener(e => callback(spinner))
      pane.add(spinner, gbc)

      y = y + 1
    }

    addSpinner("Lower Desired Temperature", _lowerDesiredTempWstatus.value.native,
      InitialValues.LOWER_DESIRED_TEMPERATURE_LOWER_RANGE.native, InitialValues.LOWER_DESIRED_TEMPERATURE_UPPER_RANGE.native,
      (s: JSpinner) => Interface_Ext.lowerDesiredTempWstatus =
                         Isolette_Data_Model.TempWstatus_impl(s.getValue.toString.toFloat,
                                                         Isolette_Data_Model.ValueStatus.Valid))

    addSpinner("Upper Desired Temperature", _upperDesiredTempWstatus.value.native,
      InitialValues.UPPER_DESIRED_TEMPERATURE_LOWER_RANGE.native, InitialValues.UPPER_DESIRED_TEMPERATURE_UPPER_RANGE.native,
      (s: JSpinner) => Interface_Ext.upperDesiredTempWstatus =
                         Isolette_Data_Model.TempWstatus_impl(s.getValue.toString.toFloat,
                                                         Isolette_Data_Model.ValueStatus.Valid))

    addSpinner("Lower Alarm Temperature", _lowerAlarmTempWstatus.value.native,
      InitialValues.LOWER_ALARM_TEMPERATURE_LOWER_RANGE.native, InitialValues.LOWER_ALARM_TEMPERATURE_UPPER_RANGE.native,
      (s: JSpinner) => Interface_Ext.lowerAlarmTempWstatus =
                         Isolette_Data_Model.TempWstatus_impl(s.getValue.toString.toFloat,
                                                         Isolette_Data_Model.ValueStatus.Valid))

    addSpinner("Upper Alarm Temperature", _upperAlarmTempWstatus.value.native,
      InitialValues.UPPER_ALARM_TEMPERATURE_LOWER_RANGE.native, InitialValues.UPPER_ALARM_TEMPERATURE_UPPER_RANGE.native,
      (s: JSpinner) => Interface_Ext.upperAlarmTempWstatus =
                         Isolette_Data_Model.TempWstatus_impl(s.getValue.toString.toFloat,
                                                         Isolette_Data_Model.ValueStatus.Valid))

    frame.pack()
    frame.setResizable(false)
    frame.setLocationRelativeTo(null)
    frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE)
    frame.setVisible(true)
  }

  def setRegulatorStatus(v: Option[Isolette_Data_Model.Status.Type]): Unit = {
    v match {
      case Some(s) => txtRegulatorStatus.setText(s.toString)
      case _ =>
    }
  }

  def setMonitorStatus(v: Option[Isolette_Data_Model.Status.Type]): Unit = {
    v match {
      case Some(s) => txtMonitorStatus.setText(s.toString)
      case _ =>
    }
  }

  def setDisplayTemperature(v: Option[Isolette_Data_Model.Temp_impl]): Unit = {
    v match {
      case Some(t) => txtCurrTemp.setText(t.value.toString())
      case _ =>
    }
  }

  def setAlarmControl(v: Option[Isolette_Data_Model.On_Off.Type]): Unit = {
    v match {
      case Some(a) => txtAlarm.setText(a.toString)
      case _ =>
    }
  }
}
