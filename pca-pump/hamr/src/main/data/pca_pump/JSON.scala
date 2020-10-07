// #Sireum
// @formatter:off

// This file is auto-generated from Base_Types.scala, HelperTypes.scala, Minute_imp.scala, Dose_Rate_Unit_imp.scala, Drug_Code_imp.scala, Drug_Concentration_imp.scala, Drug_Library.scala, Drug_Record_imp.scala, Drug_Volume_imp.scala, Drug_Weight_imp.scala, Flow_Rate_imp.scala, Infusion_Unit_imp.scala, Prescription_imp.scala, DataContent.scala

package pca_pump

import org.sireum._
import org.sireum.Json.Printer._

object JSON {

  object Printer {

    @pure def printB_Payload(o: Base_Types.Boolean_Payload): ST = {
      return printObject(ISZ(
        ("type", st""""Base_Types.Boolean_Payload""""),
        ("value", printB(o.value))
      ))
    }

    @pure def printZ_Payload(o: Base_Types.Integer_Payload): ST = {
      return printObject(ISZ(
        ("type", st""""Base_Types.Integer_Payload""""),
        ("value", printZ(o.value))
      ))
    }

    @pure def printS8_Payload(o: Base_Types.Integer_8_Payload): ST = {
      return printObject(ISZ(
        ("type", st""""Base_Types.Integer_8_Payload""""),
        ("value", printS8(o.value))
      ))
    }

    @pure def printS16_Payload(o: Base_Types.Integer_16_Payload): ST = {
      return printObject(ISZ(
        ("type", st""""Base_Types.Integer_16_Payload""""),
        ("value", printS16(o.value))
      ))
    }

    @pure def printS32_Payload(o: Base_Types.Integer_32_Payload): ST = {
      return printObject(ISZ(
        ("type", st""""Base_Types.Integer_32_Payload""""),
        ("value", printS32(o.value))
      ))
    }

    @pure def printS64_Payload(o: Base_Types.Integer_64_Payload): ST = {
      return printObject(ISZ(
        ("type", st""""Base_Types.Integer_64_Payload""""),
        ("value", printS64(o.value))
      ))
    }

    @pure def printU8_Payload(o: Base_Types.Unsigned_8_Payload): ST = {
      return printObject(ISZ(
        ("type", st""""Base_Types.Unsigned_8_Payload""""),
        ("value", printU8(o.value))
      ))
    }

    @pure def printU16_Payload(o: Base_Types.Unsigned_16_Payload): ST = {
      return printObject(ISZ(
        ("type", st""""Base_Types.Unsigned_16_Payload""""),
        ("value", printU16(o.value))
      ))
    }

    @pure def printU32_Payload(o: Base_Types.Unsigned_32_Payload): ST = {
      return printObject(ISZ(
        ("type", st""""Base_Types.Unsigned_32_Payload""""),
        ("value", printU32(o.value))
      ))
    }

    @pure def printU64_Payload(o: Base_Types.Unsigned_64_Payload): ST = {
      return printObject(ISZ(
        ("type", st""""Base_Types.Unsigned_64_Payload""""),
        ("value", printU64(o.value))
      ))
    }

    @pure def printR_Payload(o: Base_Types.Float_Payload): ST = {
      return printObject(ISZ(
        ("type", st""""Base_Types.Float_Payload""""),
        ("value", printR(o.value))
      ))
    }

    @pure def printF32_Payload(o: Base_Types.Float_32_Payload): ST = {
      return printObject(ISZ(
        ("type", st""""Base_Types.Float_32_Payload""""),
        ("value", printF32(o.value))
      ))
    }

    @pure def printF64_Payload(o: Base_Types.Float_64_Payload): ST = {
      return printObject(ISZ(
        ("type", st""""Base_Types.Float_64_Payload""""),
        ("value", printF64(o.value))
      ))
    }

    @pure def printC_Payload(o: Base_Types.Character_Payload): ST = {
      return printObject(ISZ(
        ("type", st""""Base_Types.Character_Payload""""),
        ("value", printC(o.value))
      ))
    }

    @pure def printBase_TypesString_Payload(o: Base_Types.String_Payload): ST = {
      return printObject(ISZ(
        ("type", st""""Base_Types.String_Payload""""),
        ("value", printString(o.value))
      ))
    }

    @pure def printBase_TypesBits_Payload(o: Base_Types.Bits_Payload): ST = {
      return printObject(ISZ(
        ("type", st""""Base_Types.Bits_Payload""""),
        ("value", printISZ(T, o.value, printB _))
      ))
    }

    @pure def printPrescriptionList(o: PrescriptionList): ST = {
      return printObject(ISZ(
        ("type", st""""PrescriptionList""""),
        ("list", printISZ(F, o.list, printPCA_TypesPrescription_imp _))
      ))
    }

    @pure def printStringList(o: StringList): ST = {
      return printObject(ISZ(
        ("type", st""""StringList""""),
        ("list", printISZ(T, o.list, printString _))
      ))
    }

    @pure def printICE_TypesMinute_imp(o: ICE_Types.Minute_imp): ST = {
      return printObject(ISZ(
        ("type", st""""ICE_Types.Minute_imp""""),
        ("value", printU16(o.value))
      ))
    }

    @pure def printICE_TypesMinute_imp_Payload(o: ICE_Types.Minute_imp_Payload): ST = {
      return printObject(ISZ(
        ("type", st""""ICE_Types.Minute_imp_Payload""""),
        ("value", printICE_TypesMinute_imp(o.value))
      ))
    }

    @pure def printPCA_TypesDose_Rate_Unit_imp(o: PCA_Types.Dose_Rate_Unit_imp): ST = {
      return printObject(ISZ(
        ("type", st""""PCA_Types.Dose_Rate_Unit_imp""""),
        ("value", printString(o.value))
      ))
    }

    @pure def printPCA_TypesDose_Rate_Unit_imp_Payload(o: PCA_Types.Dose_Rate_Unit_imp_Payload): ST = {
      return printObject(ISZ(
        ("type", st""""PCA_Types.Dose_Rate_Unit_imp_Payload""""),
        ("value", printPCA_TypesDose_Rate_Unit_imp(o.value))
      ))
    }

    @pure def printPCA_TypesDrug_Code_imp(o: PCA_Types.Drug_Code_imp): ST = {
      return printObject(ISZ(
        ("type", st""""PCA_Types.Drug_Code_imp""""),
        ("code", printString(o.code))
      ))
    }

    @pure def printPCA_TypesDrug_Code_imp_Payload(o: PCA_Types.Drug_Code_imp_Payload): ST = {
      return printObject(ISZ(
        ("type", st""""PCA_Types.Drug_Code_imp_Payload""""),
        ("value", printPCA_TypesDrug_Code_imp(o.value))
      ))
    }

    @pure def printPCA_TypesDrug_Concentration_imp(o: PCA_Types.Drug_Concentration_imp): ST = {
      return printObject(ISZ(
        ("type", st""""PCA_Types.Drug_Concentration_imp""""),
        ("value", printF32(o.value))
      ))
    }

    @pure def printPCA_TypesDrug_Concentration_imp_Payload(o: PCA_Types.Drug_Concentration_imp_Payload): ST = {
      return printObject(ISZ(
        ("type", st""""PCA_Types.Drug_Concentration_imp_Payload""""),
        ("value", printPCA_TypesDrug_Concentration_imp(o.value))
      ))
    }

    @pure def printPCA_TypesDrug_Library(o: PCA_Types.Drug_Library): ST = {
      return printObject(ISZ(
        ("type", st""""PCA_Types.Drug_Library""""),
        ("value", printISZ(F, o.value, printPCA_TypesDrug_Record_imp _))
      ))
    }

    @pure def printPCA_TypesDrug_Library_Payload(o: PCA_Types.Drug_Library_Payload): ST = {
      return printObject(ISZ(
        ("type", st""""PCA_Types.Drug_Library_Payload""""),
        ("value", printPCA_TypesDrug_Library(o.value))
      ))
    }

    @pure def printPCA_TypesDrug_Record_imp(o: PCA_Types.Drug_Record_imp): ST = {
      return printObject(ISZ(
        ("type", st""""PCA_Types.Drug_Record_imp""""),
        ("code", printPCA_TypesDrug_Code_imp(o.code)),
        ("name", printString(o.name)),
        ("location", printString(o.location)),
        ("dose_rate_unit", printPCA_TypesDose_Rate_Unit_imp(o.dose_rate_unit)),
        ("vtbi_unit", printPCA_TypesInfusion_Unit_imp(o.vtbi_unit)),
        ("amount", printPCA_TypesDrug_Weight_imp(o.amount)),
        ("concentration", printPCA_TypesDrug_Concentration_imp(o.concentration)),
        ("vtbiLowerSoft", printPCA_TypesDrug_Volume_imp(o.vtbiLowerSoft)),
        ("vtbiLowerHard", printPCA_TypesDrug_Volume_imp(o.vtbiLowerHard)),
        ("vtbiTypical", printPCA_TypesDrug_Volume_imp(o.vtbiTypical)),
        ("vtbiUpperSoft", printPCA_TypesDrug_Volume_imp(o.vtbiUpperSoft)),
        ("vtbiUpperHard", printPCA_TypesDrug_Volume_imp(o.vtbiUpperHard)),
        ("basalRateLowerSoft", printPCA_TypesFlow_Rate_imp(o.basalRateLowerSoft)),
        ("basalRateLowerHard", printPCA_TypesFlow_Rate_imp(o.basalRateLowerHard)),
        ("basalRateTypical", printPCA_TypesFlow_Rate_imp(o.basalRateTypical)),
        ("basalRateUpperSoft", printPCA_TypesFlow_Rate_imp(o.basalRateUpperSoft)),
        ("basalRateUpperHard", printPCA_TypesFlow_Rate_imp(o.basalRateUpperHard)),
        ("bolusTypical", printPCA_TypesDrug_Volume_imp(o.bolusTypical)),
        ("squareBolusRateTypical", printPCA_TypesFlow_Rate_imp(o.squareBolusRateTypical))
      ))
    }

    @pure def printPCA_TypesDrug_Record_imp_Payload(o: PCA_Types.Drug_Record_imp_Payload): ST = {
      return printObject(ISZ(
        ("type", st""""PCA_Types.Drug_Record_imp_Payload""""),
        ("value", printPCA_TypesDrug_Record_imp(o.value))
      ))
    }

    @pure def printPCA_TypesDrug_Volume_imp(o: PCA_Types.Drug_Volume_imp): ST = {
      return printObject(ISZ(
        ("type", st""""PCA_Types.Drug_Volume_imp""""),
        ("value", printS16(o.value))
      ))
    }

    @pure def printPCA_TypesDrug_Volume_imp_Payload(o: PCA_Types.Drug_Volume_imp_Payload): ST = {
      return printObject(ISZ(
        ("type", st""""PCA_Types.Drug_Volume_imp_Payload""""),
        ("value", printPCA_TypesDrug_Volume_imp(o.value))
      ))
    }

    @pure def printPCA_TypesDrug_Weight_imp(o: PCA_Types.Drug_Weight_imp): ST = {
      return printObject(ISZ(
        ("type", st""""PCA_Types.Drug_Weight_imp""""),
        ("value", printS16(o.value))
      ))
    }

    @pure def printPCA_TypesDrug_Weight_imp_Payload(o: PCA_Types.Drug_Weight_imp_Payload): ST = {
      return printObject(ISZ(
        ("type", st""""PCA_Types.Drug_Weight_imp_Payload""""),
        ("value", printPCA_TypesDrug_Weight_imp(o.value))
      ))
    }

    @pure def printPCA_TypesFlow_Rate_imp(o: PCA_Types.Flow_Rate_imp): ST = {
      return printObject(ISZ(
        ("type", st""""PCA_Types.Flow_Rate_imp""""),
        ("value", printS16(o.value))
      ))
    }

    @pure def printPCA_TypesFlow_Rate_imp_Payload(o: PCA_Types.Flow_Rate_imp_Payload): ST = {
      return printObject(ISZ(
        ("type", st""""PCA_Types.Flow_Rate_imp_Payload""""),
        ("value", printPCA_TypesFlow_Rate_imp(o.value))
      ))
    }

    @pure def printPCA_TypesInfusion_Unit_imp(o: PCA_Types.Infusion_Unit_imp): ST = {
      return printObject(ISZ(
        ("type", st""""PCA_Types.Infusion_Unit_imp""""),
        ("value", printString(o.value))
      ))
    }

    @pure def printPCA_TypesInfusion_Unit_imp_Payload(o: PCA_Types.Infusion_Unit_imp_Payload): ST = {
      return printObject(ISZ(
        ("type", st""""PCA_Types.Infusion_Unit_imp_Payload""""),
        ("value", printPCA_TypesInfusion_Unit_imp(o.value))
      ))
    }

    @pure def printPCA_TypesPrescription_imp(o: PCA_Types.Prescription_imp): ST = {
      return printObject(ISZ(
        ("type", st""""PCA_Types.Prescription_imp""""),
        ("patient", printString(o.patient)),
        ("drugName", printString(o.drugName)),
        ("code", printPCA_TypesDrug_Code_imp(o.code)),
        ("concentration", printPCA_TypesDrug_Concentration_imp(o.concentration)),
        ("initialVolume", printPCA_TypesDrug_Volume_imp(o.initialVolume)),
        ("basalFlowRate", printPCA_TypesFlow_Rate_imp(o.basalFlowRate)),
        ("patientBolusRate", printPCA_TypesFlow_Rate_imp(o.patientBolusRate)),
        ("vtbi", printPCA_TypesDrug_Volume_imp(o.vtbi)),
        ("maxDrugPerHour", printPCA_TypesDrug_Volume_imp(o.maxDrugPerHour)),
        ("minimumTimeBetweenBolus", printICE_TypesMinute_imp(o.minimumTimeBetweenBolus)),
        ("dateRxFilled", printString(o.dateRxFilled)),
        ("prescriber", printString(o.prescriber)),
        ("pharmacist", printString(o.pharmacist))
      ))
    }

    @pure def printPCA_TypesPrescription_imp_Payload(o: PCA_Types.Prescription_imp_Payload): ST = {
      return printObject(ISZ(
        ("type", st""""PCA_Types.Prescription_imp_Payload""""),
        ("value", printPCA_TypesPrescription_imp(o.value))
      ))
    }

    @pure def print_artDataContent(o: art.DataContent): ST = {
      o match {
        case o: art.Empty => return print_artEmpty(o)
        case o: Base_Types.Boolean_Payload => return printB_Payload(o)
        case o: Base_Types.Integer_Payload => return printZ_Payload(o)
        case o: Base_Types.Integer_8_Payload => return printS8_Payload(o)
        case o: Base_Types.Integer_16_Payload => return printS16_Payload(o)
        case o: Base_Types.Integer_32_Payload => return printS32_Payload(o)
        case o: Base_Types.Integer_64_Payload => return printS64_Payload(o)
        case o: Base_Types.Unsigned_8_Payload => return printU8_Payload(o)
        case o: Base_Types.Unsigned_16_Payload => return printU16_Payload(o)
        case o: Base_Types.Unsigned_32_Payload => return printU32_Payload(o)
        case o: Base_Types.Unsigned_64_Payload => return printU64_Payload(o)
        case o: Base_Types.Float_Payload => return printR_Payload(o)
        case o: Base_Types.Float_32_Payload => return printF32_Payload(o)
        case o: Base_Types.Float_64_Payload => return printF64_Payload(o)
        case o: Base_Types.Character_Payload => return printC_Payload(o)
        case o: Base_Types.String_Payload => return printBase_TypesString_Payload(o)
        case o: Base_Types.Bits_Payload => return printBase_TypesBits_Payload(o)
        case o: ICE_Types.Minute_imp_Payload => return printICE_TypesMinute_imp_Payload(o)
        case o: PCA_Types.Drug_Library_Payload => return printPCA_TypesDrug_Library_Payload(o)
        case o: PCA_Types.Drug_Code_imp_Payload => return printPCA_TypesDrug_Code_imp_Payload(o)
        case o: PCA_Types.Flow_Rate_imp_Payload => return printPCA_TypesFlow_Rate_imp_Payload(o)
        case o: PCA_Types.Drug_Volume_imp_Payload => return printPCA_TypesDrug_Volume_imp_Payload(o)
        case o: PCA_Types.Drug_Weight_imp_Payload => return printPCA_TypesDrug_Weight_imp_Payload(o)
        case o: PCA_Types.Drug_Record_imp_Payload => return printPCA_TypesDrug_Record_imp_Payload(o)
        case o: PCA_Types.Prescription_imp_Payload => return printPCA_TypesPrescription_imp_Payload(o)
        case o: PCA_Types.Infusion_Unit_imp_Payload => return printPCA_TypesInfusion_Unit_imp_Payload(o)
        case o: PCA_Types.Dose_Rate_Unit_imp_Payload => return printPCA_TypesDose_Rate_Unit_imp_Payload(o)
        case o: PCA_Types.Drug_Concentration_imp_Payload => return printPCA_TypesDrug_Concentration_imp_Payload(o)
      }
    }

    @pure def print_artEmpty(o: art.Empty): ST = {
      return printObject(ISZ(
        ("type", st""""art.Empty"""")
      ))
    }

  }

  @record class Parser(input: String) {
    val parser: Json.Parser = Json.Parser.create(input)

    def errorOpt: Option[Json.ErrorMsg] = {
      return parser.errorOpt
    }

    def parseBase_TypesBoolean_Payload(): Base_Types.Boolean_Payload = {
      val r = parseBase_TypesBoolean_PayloadT(F)
      return r
    }

    def parseBase_TypesBoolean_PayloadT(typeParsed: B): Base_Types.Boolean_Payload = {
      if (!typeParsed) {
        parser.parseObjectType("Base_Types.Boolean_Payload")
      }
      parser.parseObjectKey("value")
      val value = parser.parseB()
      parser.parseObjectNext()
      return Base_Types.Boolean_Payload(value)
    }

    def parseBase_TypesInteger_Payload(): Base_Types.Integer_Payload = {
      val r = parseBase_TypesInteger_PayloadT(F)
      return r
    }

    def parseBase_TypesInteger_PayloadT(typeParsed: B): Base_Types.Integer_Payload = {
      if (!typeParsed) {
        parser.parseObjectType("Base_Types.Integer_Payload")
      }
      parser.parseObjectKey("value")
      val value = parser.parseZ()
      parser.parseObjectNext()
      return Base_Types.Integer_Payload(value)
    }

    def parseBase_TypesInteger_8_Payload(): Base_Types.Integer_8_Payload = {
      val r = parseBase_TypesInteger_8_PayloadT(F)
      return r
    }

    def parseBase_TypesInteger_8_PayloadT(typeParsed: B): Base_Types.Integer_8_Payload = {
      if (!typeParsed) {
        parser.parseObjectType("Base_Types.Integer_8_Payload")
      }
      parser.parseObjectKey("value")
      val value = parser.parseS8()
      parser.parseObjectNext()
      return Base_Types.Integer_8_Payload(value)
    }

    def parseBase_TypesInteger_16_Payload(): Base_Types.Integer_16_Payload = {
      val r = parseBase_TypesInteger_16_PayloadT(F)
      return r
    }

    def parseBase_TypesInteger_16_PayloadT(typeParsed: B): Base_Types.Integer_16_Payload = {
      if (!typeParsed) {
        parser.parseObjectType("Base_Types.Integer_16_Payload")
      }
      parser.parseObjectKey("value")
      val value = parser.parseS16()
      parser.parseObjectNext()
      return Base_Types.Integer_16_Payload(value)
    }

    def parseBase_TypesInteger_32_Payload(): Base_Types.Integer_32_Payload = {
      val r = parseBase_TypesInteger_32_PayloadT(F)
      return r
    }

    def parseBase_TypesInteger_32_PayloadT(typeParsed: B): Base_Types.Integer_32_Payload = {
      if (!typeParsed) {
        parser.parseObjectType("Base_Types.Integer_32_Payload")
      }
      parser.parseObjectKey("value")
      val value = parser.parseS32()
      parser.parseObjectNext()
      return Base_Types.Integer_32_Payload(value)
    }

    def parseBase_TypesInteger_64_Payload(): Base_Types.Integer_64_Payload = {
      val r = parseBase_TypesInteger_64_PayloadT(F)
      return r
    }

    def parseBase_TypesInteger_64_PayloadT(typeParsed: B): Base_Types.Integer_64_Payload = {
      if (!typeParsed) {
        parser.parseObjectType("Base_Types.Integer_64_Payload")
      }
      parser.parseObjectKey("value")
      val value = parser.parseS64()
      parser.parseObjectNext()
      return Base_Types.Integer_64_Payload(value)
    }

    def parseBase_TypesUnsigned_8_Payload(): Base_Types.Unsigned_8_Payload = {
      val r = parseBase_TypesUnsigned_8_PayloadT(F)
      return r
    }

    def parseBase_TypesUnsigned_8_PayloadT(typeParsed: B): Base_Types.Unsigned_8_Payload = {
      if (!typeParsed) {
        parser.parseObjectType("Base_Types.Unsigned_8_Payload")
      }
      parser.parseObjectKey("value")
      val value = parser.parseU8()
      parser.parseObjectNext()
      return Base_Types.Unsigned_8_Payload(value)
    }

    def parseBase_TypesUnsigned_16_Payload(): Base_Types.Unsigned_16_Payload = {
      val r = parseBase_TypesUnsigned_16_PayloadT(F)
      return r
    }

    def parseBase_TypesUnsigned_16_PayloadT(typeParsed: B): Base_Types.Unsigned_16_Payload = {
      if (!typeParsed) {
        parser.parseObjectType("Base_Types.Unsigned_16_Payload")
      }
      parser.parseObjectKey("value")
      val value = parser.parseU16()
      parser.parseObjectNext()
      return Base_Types.Unsigned_16_Payload(value)
    }

    def parseBase_TypesUnsigned_32_Payload(): Base_Types.Unsigned_32_Payload = {
      val r = parseBase_TypesUnsigned_32_PayloadT(F)
      return r
    }

    def parseBase_TypesUnsigned_32_PayloadT(typeParsed: B): Base_Types.Unsigned_32_Payload = {
      if (!typeParsed) {
        parser.parseObjectType("Base_Types.Unsigned_32_Payload")
      }
      parser.parseObjectKey("value")
      val value = parser.parseU32()
      parser.parseObjectNext()
      return Base_Types.Unsigned_32_Payload(value)
    }

    def parseBase_TypesUnsigned_64_Payload(): Base_Types.Unsigned_64_Payload = {
      val r = parseBase_TypesUnsigned_64_PayloadT(F)
      return r
    }

    def parseBase_TypesUnsigned_64_PayloadT(typeParsed: B): Base_Types.Unsigned_64_Payload = {
      if (!typeParsed) {
        parser.parseObjectType("Base_Types.Unsigned_64_Payload")
      }
      parser.parseObjectKey("value")
      val value = parser.parseU64()
      parser.parseObjectNext()
      return Base_Types.Unsigned_64_Payload(value)
    }

    def parseBase_TypesFloat_Payload(): Base_Types.Float_Payload = {
      val r = parseBase_TypesFloat_PayloadT(F)
      return r
    }

    def parseBase_TypesFloat_PayloadT(typeParsed: B): Base_Types.Float_Payload = {
      if (!typeParsed) {
        parser.parseObjectType("Base_Types.Float_Payload")
      }
      parser.parseObjectKey("value")
      val value = parser.parseR()
      parser.parseObjectNext()
      return Base_Types.Float_Payload(value)
    }

    def parseBase_TypesFloat_32_Payload(): Base_Types.Float_32_Payload = {
      val r = parseBase_TypesFloat_32_PayloadT(F)
      return r
    }

    def parseBase_TypesFloat_32_PayloadT(typeParsed: B): Base_Types.Float_32_Payload = {
      if (!typeParsed) {
        parser.parseObjectType("Base_Types.Float_32_Payload")
      }
      parser.parseObjectKey("value")
      val value = parser.parseF32()
      parser.parseObjectNext()
      return Base_Types.Float_32_Payload(value)
    }

    def parseBase_TypesFloat_64_Payload(): Base_Types.Float_64_Payload = {
      val r = parseBase_TypesFloat_64_PayloadT(F)
      return r
    }

    def parseBase_TypesFloat_64_PayloadT(typeParsed: B): Base_Types.Float_64_Payload = {
      if (!typeParsed) {
        parser.parseObjectType("Base_Types.Float_64_Payload")
      }
      parser.parseObjectKey("value")
      val value = parser.parseF64()
      parser.parseObjectNext()
      return Base_Types.Float_64_Payload(value)
    }

    def parseBase_TypesCharacter_Payload(): Base_Types.Character_Payload = {
      val r = parseBase_TypesCharacter_PayloadT(F)
      return r
    }

    def parseBase_TypesCharacter_PayloadT(typeParsed: B): Base_Types.Character_Payload = {
      if (!typeParsed) {
        parser.parseObjectType("Base_Types.Character_Payload")
      }
      parser.parseObjectKey("value")
      val value = parser.parseC()
      parser.parseObjectNext()
      return Base_Types.Character_Payload(value)
    }

    def parseBase_TypesString_Payload(): Base_Types.String_Payload = {
      val r = parseBase_TypesString_PayloadT(F)
      return r
    }

    def parseBase_TypesString_PayloadT(typeParsed: B): Base_Types.String_Payload = {
      if (!typeParsed) {
        parser.parseObjectType("Base_Types.String_Payload")
      }
      parser.parseObjectKey("value")
      val value = parser.parseString()
      parser.parseObjectNext()
      return Base_Types.String_Payload(value)
    }

    def parseBase_TypesBits_Payload(): Base_Types.Bits_Payload = {
      val r = parseBase_TypesBits_PayloadT(F)
      return r
    }

    def parseBase_TypesBits_PayloadT(typeParsed: B): Base_Types.Bits_Payload = {
      if (!typeParsed) {
        parser.parseObjectType("Base_Types.Bits_Payload")
      }
      parser.parseObjectKey("value")
      val value = parser.parseISZ(parser.parseB _)
      parser.parseObjectNext()
      return Base_Types.Bits_Payload(value)
    }

    def parsePrescriptionList(): PrescriptionList = {
      val r = parsePrescriptionListT(F)
      return r
    }

    def parsePrescriptionListT(typeParsed: B): PrescriptionList = {
      if (!typeParsed) {
        parser.parseObjectType("PrescriptionList")
      }
      parser.parseObjectKey("list")
      val list = parser.parseISZ(parsePCA_TypesPrescription_imp _)
      parser.parseObjectNext()
      return PrescriptionList(list)
    }

    def parseStringList(): StringList = {
      val r = parseStringListT(F)
      return r
    }

    def parseStringListT(typeParsed: B): StringList = {
      if (!typeParsed) {
        parser.parseObjectType("StringList")
      }
      parser.parseObjectKey("list")
      val list = parser.parseISZ(parser.parseString _)
      parser.parseObjectNext()
      return StringList(list)
    }

    def parseICE_TypesMinute_imp(): ICE_Types.Minute_imp = {
      val r = parseICE_TypesMinute_impT(F)
      return r
    }

    def parseICE_TypesMinute_impT(typeParsed: B): ICE_Types.Minute_imp = {
      if (!typeParsed) {
        parser.parseObjectType("ICE_Types.Minute_imp")
      }
      parser.parseObjectKey("value")
      val value = parser.parseU16()
      parser.parseObjectNext()
      return ICE_Types.Minute_imp(value)
    }

    def parseICE_TypesMinute_imp_Payload(): ICE_Types.Minute_imp_Payload = {
      val r = parseICE_TypesMinute_imp_PayloadT(F)
      return r
    }

    def parseICE_TypesMinute_imp_PayloadT(typeParsed: B): ICE_Types.Minute_imp_Payload = {
      if (!typeParsed) {
        parser.parseObjectType("ICE_Types.Minute_imp_Payload")
      }
      parser.parseObjectKey("value")
      val value = parseICE_TypesMinute_imp()
      parser.parseObjectNext()
      return ICE_Types.Minute_imp_Payload(value)
    }

    def parsePCA_TypesDose_Rate_Unit_imp(): PCA_Types.Dose_Rate_Unit_imp = {
      val r = parsePCA_TypesDose_Rate_Unit_impT(F)
      return r
    }

    def parsePCA_TypesDose_Rate_Unit_impT(typeParsed: B): PCA_Types.Dose_Rate_Unit_imp = {
      if (!typeParsed) {
        parser.parseObjectType("PCA_Types.Dose_Rate_Unit_imp")
      }
      parser.parseObjectKey("value")
      val value = parser.parseString()
      parser.parseObjectNext()
      return PCA_Types.Dose_Rate_Unit_imp(value)
    }

    def parsePCA_TypesDose_Rate_Unit_imp_Payload(): PCA_Types.Dose_Rate_Unit_imp_Payload = {
      val r = parsePCA_TypesDose_Rate_Unit_imp_PayloadT(F)
      return r
    }

    def parsePCA_TypesDose_Rate_Unit_imp_PayloadT(typeParsed: B): PCA_Types.Dose_Rate_Unit_imp_Payload = {
      if (!typeParsed) {
        parser.parseObjectType("PCA_Types.Dose_Rate_Unit_imp_Payload")
      }
      parser.parseObjectKey("value")
      val value = parsePCA_TypesDose_Rate_Unit_imp()
      parser.parseObjectNext()
      return PCA_Types.Dose_Rate_Unit_imp_Payload(value)
    }

    def parsePCA_TypesDrug_Code_imp(): PCA_Types.Drug_Code_imp = {
      val r = parsePCA_TypesDrug_Code_impT(F)
      return r
    }

    def parsePCA_TypesDrug_Code_impT(typeParsed: B): PCA_Types.Drug_Code_imp = {
      if (!typeParsed) {
        parser.parseObjectType("PCA_Types.Drug_Code_imp")
      }
      parser.parseObjectKey("code")
      val code = parser.parseString()
      parser.parseObjectNext()
      return PCA_Types.Drug_Code_imp(code)
    }

    def parsePCA_TypesDrug_Code_imp_Payload(): PCA_Types.Drug_Code_imp_Payload = {
      val r = parsePCA_TypesDrug_Code_imp_PayloadT(F)
      return r
    }

    def parsePCA_TypesDrug_Code_imp_PayloadT(typeParsed: B): PCA_Types.Drug_Code_imp_Payload = {
      if (!typeParsed) {
        parser.parseObjectType("PCA_Types.Drug_Code_imp_Payload")
      }
      parser.parseObjectKey("value")
      val value = parsePCA_TypesDrug_Code_imp()
      parser.parseObjectNext()
      return PCA_Types.Drug_Code_imp_Payload(value)
    }

    def parsePCA_TypesDrug_Concentration_imp(): PCA_Types.Drug_Concentration_imp = {
      val r = parsePCA_TypesDrug_Concentration_impT(F)
      return r
    }

    def parsePCA_TypesDrug_Concentration_impT(typeParsed: B): PCA_Types.Drug_Concentration_imp = {
      if (!typeParsed) {
        parser.parseObjectType("PCA_Types.Drug_Concentration_imp")
      }
      parser.parseObjectKey("value")
      val value = parser.parseF32()
      parser.parseObjectNext()
      return PCA_Types.Drug_Concentration_imp(value)
    }

    def parsePCA_TypesDrug_Concentration_imp_Payload(): PCA_Types.Drug_Concentration_imp_Payload = {
      val r = parsePCA_TypesDrug_Concentration_imp_PayloadT(F)
      return r
    }

    def parsePCA_TypesDrug_Concentration_imp_PayloadT(typeParsed: B): PCA_Types.Drug_Concentration_imp_Payload = {
      if (!typeParsed) {
        parser.parseObjectType("PCA_Types.Drug_Concentration_imp_Payload")
      }
      parser.parseObjectKey("value")
      val value = parsePCA_TypesDrug_Concentration_imp()
      parser.parseObjectNext()
      return PCA_Types.Drug_Concentration_imp_Payload(value)
    }

    def parsePCA_TypesDrug_Library(): PCA_Types.Drug_Library = {
      val r = parsePCA_TypesDrug_LibraryT(F)
      return r
    }

    def parsePCA_TypesDrug_LibraryT(typeParsed: B): PCA_Types.Drug_Library = {
      if (!typeParsed) {
        parser.parseObjectType("PCA_Types.Drug_Library")
      }
      parser.parseObjectKey("value")
      val value = parser.parseISZ(parsePCA_TypesDrug_Record_imp _)
      parser.parseObjectNext()
      return PCA_Types.Drug_Library(value)
    }

    def parsePCA_TypesDrug_Library_Payload(): PCA_Types.Drug_Library_Payload = {
      val r = parsePCA_TypesDrug_Library_PayloadT(F)
      return r
    }

    def parsePCA_TypesDrug_Library_PayloadT(typeParsed: B): PCA_Types.Drug_Library_Payload = {
      if (!typeParsed) {
        parser.parseObjectType("PCA_Types.Drug_Library_Payload")
      }
      parser.parseObjectKey("value")
      val value = parsePCA_TypesDrug_Library()
      parser.parseObjectNext()
      return PCA_Types.Drug_Library_Payload(value)
    }

    def parsePCA_TypesDrug_Record_imp(): PCA_Types.Drug_Record_imp = {
      val r = parsePCA_TypesDrug_Record_impT(F)
      return r
    }

    def parsePCA_TypesDrug_Record_impT(typeParsed: B): PCA_Types.Drug_Record_imp = {
      if (!typeParsed) {
        parser.parseObjectType("PCA_Types.Drug_Record_imp")
      }
      parser.parseObjectKey("code")
      val code = parsePCA_TypesDrug_Code_imp()
      parser.parseObjectNext()
      parser.parseObjectKey("name")
      val name = parser.parseString()
      parser.parseObjectNext()
      parser.parseObjectKey("location")
      val location = parser.parseString()
      parser.parseObjectNext()
      parser.parseObjectKey("dose_rate_unit")
      val dose_rate_unit = parsePCA_TypesDose_Rate_Unit_imp()
      parser.parseObjectNext()
      parser.parseObjectKey("vtbi_unit")
      val vtbi_unit = parsePCA_TypesInfusion_Unit_imp()
      parser.parseObjectNext()
      parser.parseObjectKey("amount")
      val amount = parsePCA_TypesDrug_Weight_imp()
      parser.parseObjectNext()
      parser.parseObjectKey("concentration")
      val concentration = parsePCA_TypesDrug_Concentration_imp()
      parser.parseObjectNext()
      parser.parseObjectKey("vtbiLowerSoft")
      val vtbiLowerSoft = parsePCA_TypesDrug_Volume_imp()
      parser.parseObjectNext()
      parser.parseObjectKey("vtbiLowerHard")
      val vtbiLowerHard = parsePCA_TypesDrug_Volume_imp()
      parser.parseObjectNext()
      parser.parseObjectKey("vtbiTypical")
      val vtbiTypical = parsePCA_TypesDrug_Volume_imp()
      parser.parseObjectNext()
      parser.parseObjectKey("vtbiUpperSoft")
      val vtbiUpperSoft = parsePCA_TypesDrug_Volume_imp()
      parser.parseObjectNext()
      parser.parseObjectKey("vtbiUpperHard")
      val vtbiUpperHard = parsePCA_TypesDrug_Volume_imp()
      parser.parseObjectNext()
      parser.parseObjectKey("basalRateLowerSoft")
      val basalRateLowerSoft = parsePCA_TypesFlow_Rate_imp()
      parser.parseObjectNext()
      parser.parseObjectKey("basalRateLowerHard")
      val basalRateLowerHard = parsePCA_TypesFlow_Rate_imp()
      parser.parseObjectNext()
      parser.parseObjectKey("basalRateTypical")
      val basalRateTypical = parsePCA_TypesFlow_Rate_imp()
      parser.parseObjectNext()
      parser.parseObjectKey("basalRateUpperSoft")
      val basalRateUpperSoft = parsePCA_TypesFlow_Rate_imp()
      parser.parseObjectNext()
      parser.parseObjectKey("basalRateUpperHard")
      val basalRateUpperHard = parsePCA_TypesFlow_Rate_imp()
      parser.parseObjectNext()
      parser.parseObjectKey("bolusTypical")
      val bolusTypical = parsePCA_TypesDrug_Volume_imp()
      parser.parseObjectNext()
      parser.parseObjectKey("squareBolusRateTypical")
      val squareBolusRateTypical = parsePCA_TypesFlow_Rate_imp()
      parser.parseObjectNext()
      return PCA_Types.Drug_Record_imp(code, name, location, dose_rate_unit, vtbi_unit, amount, concentration, vtbiLowerSoft, vtbiLowerHard, vtbiTypical, vtbiUpperSoft, vtbiUpperHard, basalRateLowerSoft, basalRateLowerHard, basalRateTypical, basalRateUpperSoft, basalRateUpperHard, bolusTypical, squareBolusRateTypical)
    }

    def parsePCA_TypesDrug_Record_imp_Payload(): PCA_Types.Drug_Record_imp_Payload = {
      val r = parsePCA_TypesDrug_Record_imp_PayloadT(F)
      return r
    }

    def parsePCA_TypesDrug_Record_imp_PayloadT(typeParsed: B): PCA_Types.Drug_Record_imp_Payload = {
      if (!typeParsed) {
        parser.parseObjectType("PCA_Types.Drug_Record_imp_Payload")
      }
      parser.parseObjectKey("value")
      val value = parsePCA_TypesDrug_Record_imp()
      parser.parseObjectNext()
      return PCA_Types.Drug_Record_imp_Payload(value)
    }

    def parsePCA_TypesDrug_Volume_imp(): PCA_Types.Drug_Volume_imp = {
      val r = parsePCA_TypesDrug_Volume_impT(F)
      return r
    }

    def parsePCA_TypesDrug_Volume_impT(typeParsed: B): PCA_Types.Drug_Volume_imp = {
      if (!typeParsed) {
        parser.parseObjectType("PCA_Types.Drug_Volume_imp")
      }
      parser.parseObjectKey("value")
      val value = parser.parseS16()
      parser.parseObjectNext()
      return PCA_Types.Drug_Volume_imp(value)
    }

    def parsePCA_TypesDrug_Volume_imp_Payload(): PCA_Types.Drug_Volume_imp_Payload = {
      val r = parsePCA_TypesDrug_Volume_imp_PayloadT(F)
      return r
    }

    def parsePCA_TypesDrug_Volume_imp_PayloadT(typeParsed: B): PCA_Types.Drug_Volume_imp_Payload = {
      if (!typeParsed) {
        parser.parseObjectType("PCA_Types.Drug_Volume_imp_Payload")
      }
      parser.parseObjectKey("value")
      val value = parsePCA_TypesDrug_Volume_imp()
      parser.parseObjectNext()
      return PCA_Types.Drug_Volume_imp_Payload(value)
    }

    def parsePCA_TypesDrug_Weight_imp(): PCA_Types.Drug_Weight_imp = {
      val r = parsePCA_TypesDrug_Weight_impT(F)
      return r
    }

    def parsePCA_TypesDrug_Weight_impT(typeParsed: B): PCA_Types.Drug_Weight_imp = {
      if (!typeParsed) {
        parser.parseObjectType("PCA_Types.Drug_Weight_imp")
      }
      parser.parseObjectKey("value")
      val value = parser.parseS16()
      parser.parseObjectNext()
      return PCA_Types.Drug_Weight_imp(value)
    }

    def parsePCA_TypesDrug_Weight_imp_Payload(): PCA_Types.Drug_Weight_imp_Payload = {
      val r = parsePCA_TypesDrug_Weight_imp_PayloadT(F)
      return r
    }

    def parsePCA_TypesDrug_Weight_imp_PayloadT(typeParsed: B): PCA_Types.Drug_Weight_imp_Payload = {
      if (!typeParsed) {
        parser.parseObjectType("PCA_Types.Drug_Weight_imp_Payload")
      }
      parser.parseObjectKey("value")
      val value = parsePCA_TypesDrug_Weight_imp()
      parser.parseObjectNext()
      return PCA_Types.Drug_Weight_imp_Payload(value)
    }

    def parsePCA_TypesFlow_Rate_imp(): PCA_Types.Flow_Rate_imp = {
      val r = parsePCA_TypesFlow_Rate_impT(F)
      return r
    }

    def parsePCA_TypesFlow_Rate_impT(typeParsed: B): PCA_Types.Flow_Rate_imp = {
      if (!typeParsed) {
        parser.parseObjectType("PCA_Types.Flow_Rate_imp")
      }
      parser.parseObjectKey("value")
      val value = parser.parseS16()
      parser.parseObjectNext()
      return PCA_Types.Flow_Rate_imp(value)
    }

    def parsePCA_TypesFlow_Rate_imp_Payload(): PCA_Types.Flow_Rate_imp_Payload = {
      val r = parsePCA_TypesFlow_Rate_imp_PayloadT(F)
      return r
    }

    def parsePCA_TypesFlow_Rate_imp_PayloadT(typeParsed: B): PCA_Types.Flow_Rate_imp_Payload = {
      if (!typeParsed) {
        parser.parseObjectType("PCA_Types.Flow_Rate_imp_Payload")
      }
      parser.parseObjectKey("value")
      val value = parsePCA_TypesFlow_Rate_imp()
      parser.parseObjectNext()
      return PCA_Types.Flow_Rate_imp_Payload(value)
    }

    def parsePCA_TypesInfusion_Unit_imp(): PCA_Types.Infusion_Unit_imp = {
      val r = parsePCA_TypesInfusion_Unit_impT(F)
      return r
    }

    def parsePCA_TypesInfusion_Unit_impT(typeParsed: B): PCA_Types.Infusion_Unit_imp = {
      if (!typeParsed) {
        parser.parseObjectType("PCA_Types.Infusion_Unit_imp")
      }
      parser.parseObjectKey("value")
      val value = parser.parseString()
      parser.parseObjectNext()
      return PCA_Types.Infusion_Unit_imp(value)
    }

    def parsePCA_TypesInfusion_Unit_imp_Payload(): PCA_Types.Infusion_Unit_imp_Payload = {
      val r = parsePCA_TypesInfusion_Unit_imp_PayloadT(F)
      return r
    }

    def parsePCA_TypesInfusion_Unit_imp_PayloadT(typeParsed: B): PCA_Types.Infusion_Unit_imp_Payload = {
      if (!typeParsed) {
        parser.parseObjectType("PCA_Types.Infusion_Unit_imp_Payload")
      }
      parser.parseObjectKey("value")
      val value = parsePCA_TypesInfusion_Unit_imp()
      parser.parseObjectNext()
      return PCA_Types.Infusion_Unit_imp_Payload(value)
    }

    def parsePCA_TypesPrescription_imp(): PCA_Types.Prescription_imp = {
      val r = parsePCA_TypesPrescription_impT(F)
      return r
    }

    def parsePCA_TypesPrescription_impT(typeParsed: B): PCA_Types.Prescription_imp = {
      if (!typeParsed) {
        parser.parseObjectType("PCA_Types.Prescription_imp")
      }
      parser.parseObjectKey("patient")
      val patient = parser.parseString()
      parser.parseObjectNext()
      parser.parseObjectKey("drugName")
      val drugName = parser.parseString()
      parser.parseObjectNext()
      parser.parseObjectKey("code")
      val code = parsePCA_TypesDrug_Code_imp()
      parser.parseObjectNext()
      parser.parseObjectKey("concentration")
      val concentration = parsePCA_TypesDrug_Concentration_imp()
      parser.parseObjectNext()
      parser.parseObjectKey("initialVolume")
      val initialVolume = parsePCA_TypesDrug_Volume_imp()
      parser.parseObjectNext()
      parser.parseObjectKey("basalFlowRate")
      val basalFlowRate = parsePCA_TypesFlow_Rate_imp()
      parser.parseObjectNext()
      parser.parseObjectKey("patientBolusRate")
      val patientBolusRate = parsePCA_TypesFlow_Rate_imp()
      parser.parseObjectNext()
      parser.parseObjectKey("vtbi")
      val vtbi = parsePCA_TypesDrug_Volume_imp()
      parser.parseObjectNext()
      parser.parseObjectKey("maxDrugPerHour")
      val maxDrugPerHour = parsePCA_TypesDrug_Volume_imp()
      parser.parseObjectNext()
      parser.parseObjectKey("minimumTimeBetweenBolus")
      val minimumTimeBetweenBolus = parseICE_TypesMinute_imp()
      parser.parseObjectNext()
      parser.parseObjectKey("dateRxFilled")
      val dateRxFilled = parser.parseString()
      parser.parseObjectNext()
      parser.parseObjectKey("prescriber")
      val prescriber = parser.parseString()
      parser.parseObjectNext()
      parser.parseObjectKey("pharmacist")
      val pharmacist = parser.parseString()
      parser.parseObjectNext()
      return PCA_Types.Prescription_imp(patient, drugName, code, concentration, initialVolume, basalFlowRate, patientBolusRate, vtbi, maxDrugPerHour, minimumTimeBetweenBolus, dateRxFilled, prescriber, pharmacist)
    }

    def parsePCA_TypesPrescription_imp_Payload(): PCA_Types.Prescription_imp_Payload = {
      val r = parsePCA_TypesPrescription_imp_PayloadT(F)
      return r
    }

    def parsePCA_TypesPrescription_imp_PayloadT(typeParsed: B): PCA_Types.Prescription_imp_Payload = {
      if (!typeParsed) {
        parser.parseObjectType("PCA_Types.Prescription_imp_Payload")
      }
      parser.parseObjectKey("value")
      val value = parsePCA_TypesPrescription_imp()
      parser.parseObjectNext()
      return PCA_Types.Prescription_imp_Payload(value)
    }

    def parse_artDataContent(): art.DataContent = {
      val t = parser.parseObjectTypes(ISZ("art.Empty", "Base_Types.Boolean_Payload", "Base_Types.Integer_Payload", "Base_Types.Integer_8_Payload", "Base_Types.Integer_16_Payload", "Base_Types.Integer_32_Payload", "Base_Types.Integer_64_Payload", "Base_Types.Unsigned_8_Payload", "Base_Types.Unsigned_16_Payload", "Base_Types.Unsigned_32_Payload", "Base_Types.Unsigned_64_Payload", "Base_Types.Float_Payload", "Base_Types.Float_32_Payload", "Base_Types.Float_64_Payload", "Base_Types.Character_Payload", "Base_Types.String_Payload", "Base_Types.Bits_Payload", "ICE_Types.Minute_imp_Payload", "PCA_Types.Drug_Library_Payload", "PCA_Types.Drug_Code_imp_Payload", "PCA_Types.Flow_Rate_imp_Payload", "PCA_Types.Drug_Volume_imp_Payload", "PCA_Types.Drug_Weight_imp_Payload", "PCA_Types.Drug_Record_imp_Payload", "PCA_Types.Prescription_imp_Payload", "PCA_Types.Infusion_Unit_imp_Payload", "PCA_Types.Dose_Rate_Unit_imp_Payload", "PCA_Types.Drug_Concentration_imp_Payload"))
      t.native match {
        case "art.Empty" => val r = parse_artEmptyT(T); return r
        case "Base_Types.Boolean_Payload" => val r = parseBase_TypesBoolean_PayloadT(T); return r
        case "Base_Types.Integer_Payload" => val r = parseBase_TypesInteger_PayloadT(T); return r
        case "Base_Types.Integer_8_Payload" => val r = parseBase_TypesInteger_8_PayloadT(T); return r
        case "Base_Types.Integer_16_Payload" => val r = parseBase_TypesInteger_16_PayloadT(T); return r
        case "Base_Types.Integer_32_Payload" => val r = parseBase_TypesInteger_32_PayloadT(T); return r
        case "Base_Types.Integer_64_Payload" => val r = parseBase_TypesInteger_64_PayloadT(T); return r
        case "Base_Types.Unsigned_8_Payload" => val r = parseBase_TypesUnsigned_8_PayloadT(T); return r
        case "Base_Types.Unsigned_16_Payload" => val r = parseBase_TypesUnsigned_16_PayloadT(T); return r
        case "Base_Types.Unsigned_32_Payload" => val r = parseBase_TypesUnsigned_32_PayloadT(T); return r
        case "Base_Types.Unsigned_64_Payload" => val r = parseBase_TypesUnsigned_64_PayloadT(T); return r
        case "Base_Types.Float_Payload" => val r = parseBase_TypesFloat_PayloadT(T); return r
        case "Base_Types.Float_32_Payload" => val r = parseBase_TypesFloat_32_PayloadT(T); return r
        case "Base_Types.Float_64_Payload" => val r = parseBase_TypesFloat_64_PayloadT(T); return r
        case "Base_Types.Character_Payload" => val r = parseBase_TypesCharacter_PayloadT(T); return r
        case "Base_Types.String_Payload" => val r = parseBase_TypesString_PayloadT(T); return r
        case "Base_Types.Bits_Payload" => val r = parseBase_TypesBits_PayloadT(T); return r
        case "ICE_Types.Minute_imp_Payload" => val r = parseICE_TypesMinute_imp_PayloadT(T); return r
        case "PCA_Types.Drug_Library_Payload" => val r = parsePCA_TypesDrug_Library_PayloadT(T); return r
        case "PCA_Types.Drug_Code_imp_Payload" => val r = parsePCA_TypesDrug_Code_imp_PayloadT(T); return r
        case "PCA_Types.Flow_Rate_imp_Payload" => val r = parsePCA_TypesFlow_Rate_imp_PayloadT(T); return r
        case "PCA_Types.Drug_Volume_imp_Payload" => val r = parsePCA_TypesDrug_Volume_imp_PayloadT(T); return r
        case "PCA_Types.Drug_Weight_imp_Payload" => val r = parsePCA_TypesDrug_Weight_imp_PayloadT(T); return r
        case "PCA_Types.Drug_Record_imp_Payload" => val r = parsePCA_TypesDrug_Record_imp_PayloadT(T); return r
        case "PCA_Types.Prescription_imp_Payload" => val r = parsePCA_TypesPrescription_imp_PayloadT(T); return r
        case "PCA_Types.Infusion_Unit_imp_Payload" => val r = parsePCA_TypesInfusion_Unit_imp_PayloadT(T); return r
        case "PCA_Types.Dose_Rate_Unit_imp_Payload" => val r = parsePCA_TypesDose_Rate_Unit_imp_PayloadT(T); return r
        case "PCA_Types.Drug_Concentration_imp_Payload" => val r = parsePCA_TypesDrug_Concentration_imp_PayloadT(T); return r
        case _ => val r = parsePCA_TypesDrug_Concentration_imp_PayloadT(T); return r
      }
    }

    def parse_artEmpty(): art.Empty = {
      val r = parse_artEmptyT(F)
      return r
    }

    def parse_artEmptyT(typeParsed: B): art.Empty = {
      if (!typeParsed) {
        parser.parseObjectType("art.Empty")
      }
      return art.Empty()
    }

    def eof(): B = {
      val r = parser.eof()
      return r
    }

  }

  def to[T](s: String, f: Parser => T): Either[T, Json.ErrorMsg] = {
    val parser = Parser(s)
    val r = f(parser)
    parser.eof()
    parser.errorOpt match {
      case Some(e) => return Either.Right(e)
      case _ => return Either.Left(r)
    }
  }

  def fromBase_TypesBoolean_Payload(o: Base_Types.Boolean_Payload, isCompact: B): String = {
    val st = Printer.printB_Payload(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toBase_TypesBoolean_Payload(s: String): Either[Base_Types.Boolean_Payload, Json.ErrorMsg] = {
    def fBase_TypesBoolean_Payload(parser: Parser): Base_Types.Boolean_Payload = {
      val r = parser.parseBase_TypesBoolean_Payload()
      return r
    }
    val r = to(s, fBase_TypesBoolean_Payload _)
    return r
  }

  def fromBase_TypesInteger_Payload(o: Base_Types.Integer_Payload, isCompact: B): String = {
    val st = Printer.printZ_Payload(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toBase_TypesInteger_Payload(s: String): Either[Base_Types.Integer_Payload, Json.ErrorMsg] = {
    def fBase_TypesInteger_Payload(parser: Parser): Base_Types.Integer_Payload = {
      val r = parser.parseBase_TypesInteger_Payload()
      return r
    }
    val r = to(s, fBase_TypesInteger_Payload _)
    return r
  }

  def fromBase_TypesInteger_8_Payload(o: Base_Types.Integer_8_Payload, isCompact: B): String = {
    val st = Printer.printS8_Payload(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toBase_TypesInteger_8_Payload(s: String): Either[Base_Types.Integer_8_Payload, Json.ErrorMsg] = {
    def fBase_TypesInteger_8_Payload(parser: Parser): Base_Types.Integer_8_Payload = {
      val r = parser.parseBase_TypesInteger_8_Payload()
      return r
    }
    val r = to(s, fBase_TypesInteger_8_Payload _)
    return r
  }

  def fromBase_TypesInteger_16_Payload(o: Base_Types.Integer_16_Payload, isCompact: B): String = {
    val st = Printer.printS16_Payload(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toBase_TypesInteger_16_Payload(s: String): Either[Base_Types.Integer_16_Payload, Json.ErrorMsg] = {
    def fBase_TypesInteger_16_Payload(parser: Parser): Base_Types.Integer_16_Payload = {
      val r = parser.parseBase_TypesInteger_16_Payload()
      return r
    }
    val r = to(s, fBase_TypesInteger_16_Payload _)
    return r
  }

  def fromBase_TypesInteger_32_Payload(o: Base_Types.Integer_32_Payload, isCompact: B): String = {
    val st = Printer.printS32_Payload(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toBase_TypesInteger_32_Payload(s: String): Either[Base_Types.Integer_32_Payload, Json.ErrorMsg] = {
    def fBase_TypesInteger_32_Payload(parser: Parser): Base_Types.Integer_32_Payload = {
      val r = parser.parseBase_TypesInteger_32_Payload()
      return r
    }
    val r = to(s, fBase_TypesInteger_32_Payload _)
    return r
  }

  def fromBase_TypesInteger_64_Payload(o: Base_Types.Integer_64_Payload, isCompact: B): String = {
    val st = Printer.printS64_Payload(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toBase_TypesInteger_64_Payload(s: String): Either[Base_Types.Integer_64_Payload, Json.ErrorMsg] = {
    def fBase_TypesInteger_64_Payload(parser: Parser): Base_Types.Integer_64_Payload = {
      val r = parser.parseBase_TypesInteger_64_Payload()
      return r
    }
    val r = to(s, fBase_TypesInteger_64_Payload _)
    return r
  }

  def fromBase_TypesUnsigned_8_Payload(o: Base_Types.Unsigned_8_Payload, isCompact: B): String = {
    val st = Printer.printU8_Payload(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toBase_TypesUnsigned_8_Payload(s: String): Either[Base_Types.Unsigned_8_Payload, Json.ErrorMsg] = {
    def fBase_TypesUnsigned_8_Payload(parser: Parser): Base_Types.Unsigned_8_Payload = {
      val r = parser.parseBase_TypesUnsigned_8_Payload()
      return r
    }
    val r = to(s, fBase_TypesUnsigned_8_Payload _)
    return r
  }

  def fromBase_TypesUnsigned_16_Payload(o: Base_Types.Unsigned_16_Payload, isCompact: B): String = {
    val st = Printer.printU16_Payload(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toBase_TypesUnsigned_16_Payload(s: String): Either[Base_Types.Unsigned_16_Payload, Json.ErrorMsg] = {
    def fBase_TypesUnsigned_16_Payload(parser: Parser): Base_Types.Unsigned_16_Payload = {
      val r = parser.parseBase_TypesUnsigned_16_Payload()
      return r
    }
    val r = to(s, fBase_TypesUnsigned_16_Payload _)
    return r
  }

  def fromBase_TypesUnsigned_32_Payload(o: Base_Types.Unsigned_32_Payload, isCompact: B): String = {
    val st = Printer.printU32_Payload(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toBase_TypesUnsigned_32_Payload(s: String): Either[Base_Types.Unsigned_32_Payload, Json.ErrorMsg] = {
    def fBase_TypesUnsigned_32_Payload(parser: Parser): Base_Types.Unsigned_32_Payload = {
      val r = parser.parseBase_TypesUnsigned_32_Payload()
      return r
    }
    val r = to(s, fBase_TypesUnsigned_32_Payload _)
    return r
  }

  def fromBase_TypesUnsigned_64_Payload(o: Base_Types.Unsigned_64_Payload, isCompact: B): String = {
    val st = Printer.printU64_Payload(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toBase_TypesUnsigned_64_Payload(s: String): Either[Base_Types.Unsigned_64_Payload, Json.ErrorMsg] = {
    def fBase_TypesUnsigned_64_Payload(parser: Parser): Base_Types.Unsigned_64_Payload = {
      val r = parser.parseBase_TypesUnsigned_64_Payload()
      return r
    }
    val r = to(s, fBase_TypesUnsigned_64_Payload _)
    return r
  }

  def fromBase_TypesFloat_Payload(o: Base_Types.Float_Payload, isCompact: B): String = {
    val st = Printer.printR_Payload(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toBase_TypesFloat_Payload(s: String): Either[Base_Types.Float_Payload, Json.ErrorMsg] = {
    def fBase_TypesFloat_Payload(parser: Parser): Base_Types.Float_Payload = {
      val r = parser.parseBase_TypesFloat_Payload()
      return r
    }
    val r = to(s, fBase_TypesFloat_Payload _)
    return r
  }

  def fromBase_TypesFloat_32_Payload(o: Base_Types.Float_32_Payload, isCompact: B): String = {
    val st = Printer.printF32_Payload(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toBase_TypesFloat_32_Payload(s: String): Either[Base_Types.Float_32_Payload, Json.ErrorMsg] = {
    def fBase_TypesFloat_32_Payload(parser: Parser): Base_Types.Float_32_Payload = {
      val r = parser.parseBase_TypesFloat_32_Payload()
      return r
    }
    val r = to(s, fBase_TypesFloat_32_Payload _)
    return r
  }

  def fromBase_TypesFloat_64_Payload(o: Base_Types.Float_64_Payload, isCompact: B): String = {
    val st = Printer.printF64_Payload(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toBase_TypesFloat_64_Payload(s: String): Either[Base_Types.Float_64_Payload, Json.ErrorMsg] = {
    def fBase_TypesFloat_64_Payload(parser: Parser): Base_Types.Float_64_Payload = {
      val r = parser.parseBase_TypesFloat_64_Payload()
      return r
    }
    val r = to(s, fBase_TypesFloat_64_Payload _)
    return r
  }

  def fromBase_TypesCharacter_Payload(o: Base_Types.Character_Payload, isCompact: B): String = {
    val st = Printer.printC_Payload(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toBase_TypesCharacter_Payload(s: String): Either[Base_Types.Character_Payload, Json.ErrorMsg] = {
    def fBase_TypesCharacter_Payload(parser: Parser): Base_Types.Character_Payload = {
      val r = parser.parseBase_TypesCharacter_Payload()
      return r
    }
    val r = to(s, fBase_TypesCharacter_Payload _)
    return r
  }

  def fromBase_TypesString_Payload(o: Base_Types.String_Payload, isCompact: B): String = {
    val st = Printer.printBase_TypesString_Payload(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toBase_TypesString_Payload(s: String): Either[Base_Types.String_Payload, Json.ErrorMsg] = {
    def fBase_TypesString_Payload(parser: Parser): Base_Types.String_Payload = {
      val r = parser.parseBase_TypesString_Payload()
      return r
    }
    val r = to(s, fBase_TypesString_Payload _)
    return r
  }

  def fromBase_TypesBits_Payload(o: Base_Types.Bits_Payload, isCompact: B): String = {
    val st = Printer.printBase_TypesBits_Payload(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toBase_TypesBits_Payload(s: String): Either[Base_Types.Bits_Payload, Json.ErrorMsg] = {
    def fBase_TypesBits_Payload(parser: Parser): Base_Types.Bits_Payload = {
      val r = parser.parseBase_TypesBits_Payload()
      return r
    }
    val r = to(s, fBase_TypesBits_Payload _)
    return r
  }

  def fromPrescriptionList(o: PrescriptionList, isCompact: B): String = {
    val st = Printer.printPrescriptionList(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toPrescriptionList(s: String): Either[PrescriptionList, Json.ErrorMsg] = {
    def fPrescriptionList(parser: Parser): PrescriptionList = {
      val r = parser.parsePrescriptionList()
      return r
    }
    val r = to(s, fPrescriptionList _)
    return r
  }

  def fromStringList(o: StringList, isCompact: B): String = {
    val st = Printer.printStringList(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toStringList(s: String): Either[StringList, Json.ErrorMsg] = {
    def fStringList(parser: Parser): StringList = {
      val r = parser.parseStringList()
      return r
    }
    val r = to(s, fStringList _)
    return r
  }

  def fromICE_TypesMinute_imp(o: ICE_Types.Minute_imp, isCompact: B): String = {
    val st = Printer.printICE_TypesMinute_imp(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toICE_TypesMinute_imp(s: String): Either[ICE_Types.Minute_imp, Json.ErrorMsg] = {
    def fICE_TypesMinute_imp(parser: Parser): ICE_Types.Minute_imp = {
      val r = parser.parseICE_TypesMinute_imp()
      return r
    }
    val r = to(s, fICE_TypesMinute_imp _)
    return r
  }

  def fromICE_TypesMinute_imp_Payload(o: ICE_Types.Minute_imp_Payload, isCompact: B): String = {
    val st = Printer.printICE_TypesMinute_imp_Payload(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toICE_TypesMinute_imp_Payload(s: String): Either[ICE_Types.Minute_imp_Payload, Json.ErrorMsg] = {
    def fICE_TypesMinute_imp_Payload(parser: Parser): ICE_Types.Minute_imp_Payload = {
      val r = parser.parseICE_TypesMinute_imp_Payload()
      return r
    }
    val r = to(s, fICE_TypesMinute_imp_Payload _)
    return r
  }

  def fromPCA_TypesDose_Rate_Unit_imp(o: PCA_Types.Dose_Rate_Unit_imp, isCompact: B): String = {
    val st = Printer.printPCA_TypesDose_Rate_Unit_imp(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toPCA_TypesDose_Rate_Unit_imp(s: String): Either[PCA_Types.Dose_Rate_Unit_imp, Json.ErrorMsg] = {
    def fPCA_TypesDose_Rate_Unit_imp(parser: Parser): PCA_Types.Dose_Rate_Unit_imp = {
      val r = parser.parsePCA_TypesDose_Rate_Unit_imp()
      return r
    }
    val r = to(s, fPCA_TypesDose_Rate_Unit_imp _)
    return r
  }

  def fromPCA_TypesDose_Rate_Unit_imp_Payload(o: PCA_Types.Dose_Rate_Unit_imp_Payload, isCompact: B): String = {
    val st = Printer.printPCA_TypesDose_Rate_Unit_imp_Payload(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toPCA_TypesDose_Rate_Unit_imp_Payload(s: String): Either[PCA_Types.Dose_Rate_Unit_imp_Payload, Json.ErrorMsg] = {
    def fPCA_TypesDose_Rate_Unit_imp_Payload(parser: Parser): PCA_Types.Dose_Rate_Unit_imp_Payload = {
      val r = parser.parsePCA_TypesDose_Rate_Unit_imp_Payload()
      return r
    }
    val r = to(s, fPCA_TypesDose_Rate_Unit_imp_Payload _)
    return r
  }

  def fromPCA_TypesDrug_Code_imp(o: PCA_Types.Drug_Code_imp, isCompact: B): String = {
    val st = Printer.printPCA_TypesDrug_Code_imp(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toPCA_TypesDrug_Code_imp(s: String): Either[PCA_Types.Drug_Code_imp, Json.ErrorMsg] = {
    def fPCA_TypesDrug_Code_imp(parser: Parser): PCA_Types.Drug_Code_imp = {
      val r = parser.parsePCA_TypesDrug_Code_imp()
      return r
    }
    val r = to(s, fPCA_TypesDrug_Code_imp _)
    return r
  }

  def fromPCA_TypesDrug_Code_imp_Payload(o: PCA_Types.Drug_Code_imp_Payload, isCompact: B): String = {
    val st = Printer.printPCA_TypesDrug_Code_imp_Payload(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toPCA_TypesDrug_Code_imp_Payload(s: String): Either[PCA_Types.Drug_Code_imp_Payload, Json.ErrorMsg] = {
    def fPCA_TypesDrug_Code_imp_Payload(parser: Parser): PCA_Types.Drug_Code_imp_Payload = {
      val r = parser.parsePCA_TypesDrug_Code_imp_Payload()
      return r
    }
    val r = to(s, fPCA_TypesDrug_Code_imp_Payload _)
    return r
  }

  def fromPCA_TypesDrug_Concentration_imp(o: PCA_Types.Drug_Concentration_imp, isCompact: B): String = {
    val st = Printer.printPCA_TypesDrug_Concentration_imp(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toPCA_TypesDrug_Concentration_imp(s: String): Either[PCA_Types.Drug_Concentration_imp, Json.ErrorMsg] = {
    def fPCA_TypesDrug_Concentration_imp(parser: Parser): PCA_Types.Drug_Concentration_imp = {
      val r = parser.parsePCA_TypesDrug_Concentration_imp()
      return r
    }
    val r = to(s, fPCA_TypesDrug_Concentration_imp _)
    return r
  }

  def fromPCA_TypesDrug_Concentration_imp_Payload(o: PCA_Types.Drug_Concentration_imp_Payload, isCompact: B): String = {
    val st = Printer.printPCA_TypesDrug_Concentration_imp_Payload(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toPCA_TypesDrug_Concentration_imp_Payload(s: String): Either[PCA_Types.Drug_Concentration_imp_Payload, Json.ErrorMsg] = {
    def fPCA_TypesDrug_Concentration_imp_Payload(parser: Parser): PCA_Types.Drug_Concentration_imp_Payload = {
      val r = parser.parsePCA_TypesDrug_Concentration_imp_Payload()
      return r
    }
    val r = to(s, fPCA_TypesDrug_Concentration_imp_Payload _)
    return r
  }

  def fromPCA_TypesDrug_Library(o: PCA_Types.Drug_Library, isCompact: B): String = {
    val st = Printer.printPCA_TypesDrug_Library(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toPCA_TypesDrug_Library(s: String): Either[PCA_Types.Drug_Library, Json.ErrorMsg] = {
    def fPCA_TypesDrug_Library(parser: Parser): PCA_Types.Drug_Library = {
      val r = parser.parsePCA_TypesDrug_Library()
      return r
    }
    val r = to(s, fPCA_TypesDrug_Library _)
    return r
  }

  def fromPCA_TypesDrug_Library_Payload(o: PCA_Types.Drug_Library_Payload, isCompact: B): String = {
    val st = Printer.printPCA_TypesDrug_Library_Payload(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toPCA_TypesDrug_Library_Payload(s: String): Either[PCA_Types.Drug_Library_Payload, Json.ErrorMsg] = {
    def fPCA_TypesDrug_Library_Payload(parser: Parser): PCA_Types.Drug_Library_Payload = {
      val r = parser.parsePCA_TypesDrug_Library_Payload()
      return r
    }
    val r = to(s, fPCA_TypesDrug_Library_Payload _)
    return r
  }

  def fromPCA_TypesDrug_Record_imp(o: PCA_Types.Drug_Record_imp, isCompact: B): String = {
    val st = Printer.printPCA_TypesDrug_Record_imp(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toPCA_TypesDrug_Record_imp(s: String): Either[PCA_Types.Drug_Record_imp, Json.ErrorMsg] = {
    def fPCA_TypesDrug_Record_imp(parser: Parser): PCA_Types.Drug_Record_imp = {
      val r = parser.parsePCA_TypesDrug_Record_imp()
      return r
    }
    val r = to(s, fPCA_TypesDrug_Record_imp _)
    return r
  }

  def fromPCA_TypesDrug_Record_imp_Payload(o: PCA_Types.Drug_Record_imp_Payload, isCompact: B): String = {
    val st = Printer.printPCA_TypesDrug_Record_imp_Payload(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toPCA_TypesDrug_Record_imp_Payload(s: String): Either[PCA_Types.Drug_Record_imp_Payload, Json.ErrorMsg] = {
    def fPCA_TypesDrug_Record_imp_Payload(parser: Parser): PCA_Types.Drug_Record_imp_Payload = {
      val r = parser.parsePCA_TypesDrug_Record_imp_Payload()
      return r
    }
    val r = to(s, fPCA_TypesDrug_Record_imp_Payload _)
    return r
  }

  def fromPCA_TypesDrug_Volume_imp(o: PCA_Types.Drug_Volume_imp, isCompact: B): String = {
    val st = Printer.printPCA_TypesDrug_Volume_imp(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toPCA_TypesDrug_Volume_imp(s: String): Either[PCA_Types.Drug_Volume_imp, Json.ErrorMsg] = {
    def fPCA_TypesDrug_Volume_imp(parser: Parser): PCA_Types.Drug_Volume_imp = {
      val r = parser.parsePCA_TypesDrug_Volume_imp()
      return r
    }
    val r = to(s, fPCA_TypesDrug_Volume_imp _)
    return r
  }

  def fromPCA_TypesDrug_Volume_imp_Payload(o: PCA_Types.Drug_Volume_imp_Payload, isCompact: B): String = {
    val st = Printer.printPCA_TypesDrug_Volume_imp_Payload(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toPCA_TypesDrug_Volume_imp_Payload(s: String): Either[PCA_Types.Drug_Volume_imp_Payload, Json.ErrorMsg] = {
    def fPCA_TypesDrug_Volume_imp_Payload(parser: Parser): PCA_Types.Drug_Volume_imp_Payload = {
      val r = parser.parsePCA_TypesDrug_Volume_imp_Payload()
      return r
    }
    val r = to(s, fPCA_TypesDrug_Volume_imp_Payload _)
    return r
  }

  def fromPCA_TypesDrug_Weight_imp(o: PCA_Types.Drug_Weight_imp, isCompact: B): String = {
    val st = Printer.printPCA_TypesDrug_Weight_imp(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toPCA_TypesDrug_Weight_imp(s: String): Either[PCA_Types.Drug_Weight_imp, Json.ErrorMsg] = {
    def fPCA_TypesDrug_Weight_imp(parser: Parser): PCA_Types.Drug_Weight_imp = {
      val r = parser.parsePCA_TypesDrug_Weight_imp()
      return r
    }
    val r = to(s, fPCA_TypesDrug_Weight_imp _)
    return r
  }

  def fromPCA_TypesDrug_Weight_imp_Payload(o: PCA_Types.Drug_Weight_imp_Payload, isCompact: B): String = {
    val st = Printer.printPCA_TypesDrug_Weight_imp_Payload(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toPCA_TypesDrug_Weight_imp_Payload(s: String): Either[PCA_Types.Drug_Weight_imp_Payload, Json.ErrorMsg] = {
    def fPCA_TypesDrug_Weight_imp_Payload(parser: Parser): PCA_Types.Drug_Weight_imp_Payload = {
      val r = parser.parsePCA_TypesDrug_Weight_imp_Payload()
      return r
    }
    val r = to(s, fPCA_TypesDrug_Weight_imp_Payload _)
    return r
  }

  def fromPCA_TypesFlow_Rate_imp(o: PCA_Types.Flow_Rate_imp, isCompact: B): String = {
    val st = Printer.printPCA_TypesFlow_Rate_imp(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toPCA_TypesFlow_Rate_imp(s: String): Either[PCA_Types.Flow_Rate_imp, Json.ErrorMsg] = {
    def fPCA_TypesFlow_Rate_imp(parser: Parser): PCA_Types.Flow_Rate_imp = {
      val r = parser.parsePCA_TypesFlow_Rate_imp()
      return r
    }
    val r = to(s, fPCA_TypesFlow_Rate_imp _)
    return r
  }

  def fromPCA_TypesFlow_Rate_imp_Payload(o: PCA_Types.Flow_Rate_imp_Payload, isCompact: B): String = {
    val st = Printer.printPCA_TypesFlow_Rate_imp_Payload(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toPCA_TypesFlow_Rate_imp_Payload(s: String): Either[PCA_Types.Flow_Rate_imp_Payload, Json.ErrorMsg] = {
    def fPCA_TypesFlow_Rate_imp_Payload(parser: Parser): PCA_Types.Flow_Rate_imp_Payload = {
      val r = parser.parsePCA_TypesFlow_Rate_imp_Payload()
      return r
    }
    val r = to(s, fPCA_TypesFlow_Rate_imp_Payload _)
    return r
  }

  def fromPCA_TypesInfusion_Unit_imp(o: PCA_Types.Infusion_Unit_imp, isCompact: B): String = {
    val st = Printer.printPCA_TypesInfusion_Unit_imp(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toPCA_TypesInfusion_Unit_imp(s: String): Either[PCA_Types.Infusion_Unit_imp, Json.ErrorMsg] = {
    def fPCA_TypesInfusion_Unit_imp(parser: Parser): PCA_Types.Infusion_Unit_imp = {
      val r = parser.parsePCA_TypesInfusion_Unit_imp()
      return r
    }
    val r = to(s, fPCA_TypesInfusion_Unit_imp _)
    return r
  }

  def fromPCA_TypesInfusion_Unit_imp_Payload(o: PCA_Types.Infusion_Unit_imp_Payload, isCompact: B): String = {
    val st = Printer.printPCA_TypesInfusion_Unit_imp_Payload(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toPCA_TypesInfusion_Unit_imp_Payload(s: String): Either[PCA_Types.Infusion_Unit_imp_Payload, Json.ErrorMsg] = {
    def fPCA_TypesInfusion_Unit_imp_Payload(parser: Parser): PCA_Types.Infusion_Unit_imp_Payload = {
      val r = parser.parsePCA_TypesInfusion_Unit_imp_Payload()
      return r
    }
    val r = to(s, fPCA_TypesInfusion_Unit_imp_Payload _)
    return r
  }

  def fromPCA_TypesPrescription_imp(o: PCA_Types.Prescription_imp, isCompact: B): String = {
    val st = Printer.printPCA_TypesPrescription_imp(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toPCA_TypesPrescription_imp(s: String): Either[PCA_Types.Prescription_imp, Json.ErrorMsg] = {
    def fPCA_TypesPrescription_imp(parser: Parser): PCA_Types.Prescription_imp = {
      val r = parser.parsePCA_TypesPrescription_imp()
      return r
    }
    val r = to(s, fPCA_TypesPrescription_imp _)
    return r
  }

  def fromPCA_TypesPrescription_imp_Payload(o: PCA_Types.Prescription_imp_Payload, isCompact: B): String = {
    val st = Printer.printPCA_TypesPrescription_imp_Payload(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def toPCA_TypesPrescription_imp_Payload(s: String): Either[PCA_Types.Prescription_imp_Payload, Json.ErrorMsg] = {
    def fPCA_TypesPrescription_imp_Payload(parser: Parser): PCA_Types.Prescription_imp_Payload = {
      val r = parser.parsePCA_TypesPrescription_imp_Payload()
      return r
    }
    val r = to(s, fPCA_TypesPrescription_imp_Payload _)
    return r
  }

  def from_artDataContent(o: art.DataContent, isCompact: B): String = {
    val st = Printer.print_artDataContent(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def to_artDataContent(s: String): Either[art.DataContent, Json.ErrorMsg] = {
    def f_artDataContent(parser: Parser): art.DataContent = {
      val r = parser.parse_artDataContent()
      return r
    }
    val r = to(s, f_artDataContent _)
    return r
  }

  def from_artEmpty(o: art.Empty, isCompact: B): String = {
    val st = Printer.print_artEmpty(o)
    if (isCompact) {
      return st.renderCompact
    } else {
      return st.render
    }
  }

  def to_artEmpty(s: String): Either[art.Empty, Json.ErrorMsg] = {
    def f_artEmpty(parser: Parser): art.Empty = {
      val r = parser.parse_artEmpty()
      return r
    }
    val r = to(s, f_artEmpty _)
    return r
  }

}