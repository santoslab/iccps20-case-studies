#!/usr/bin/env bash

$SIREUM_HOME/bin/sireum tools sergen -p pca_pump -m "json" \
Base_Types.scala \
HelperTypes.scala \
ICE_Types/Minute_imp.scala \
PCA_Types/Dose_Rate_Unit_imp.scala \
PCA_Types/Drug_Code_imp.scala \
PCA_Types/Drug_Concentration_imp.scala \
PCA_Types/Drug_Library.scala \
PCA_Types/Drug_Record_imp.scala \
PCA_Types/Drug_Volume_imp.scala \
PCA_Types/Drug_Weight_imp.scala \
PCA_Types/Flow_Rate_imp.scala \
PCA_Types/Infusion_Unit_imp.scala \
PCA_Types/Prescription_imp.scala \
../../art/DataContent.scala

FILE=JSON.scala

sed -i 's/printBase_TypesBoolean/printB/g' $FILE

sed -i 's/printBase_TypesInteger_8/printS8/g' $FILE
sed -i 's/printBase_TypesInteger_16/printS16/g' $FILE
sed -i 's/printBase_TypesInteger_32/printS32/g' $FILE
sed -i 's/printBase_TypesInteger_64/printS64/g' $FILE
sed -i 's/printBase_TypesInteger/printZ/g' $FILE

sed -i 's/printBase_TypesUnsigned_8/printU8/g' $FILE
sed -i 's/printBase_TypesUnsigned_16/printU16/g' $FILE
sed -i 's/printBase_TypesUnsigned_32/printU32/g' $FILE
sed -i 's/printBase_TypesUnsigned_64/printU64/g' $FILE

sed -i 's/printBase_TypesFloat_32/printF32/g' $FILE
sed -i 's/printBase_TypesFloat_64/printF64/g' $FILE
sed -i 's/printBase_TypesFloat/printR/g' $FILE

sed -i 's/printBase_TypesCharacter/printC/g' $FILE
sed -i 's/printBase_TypesBits(o.value)/printISZ(T, o.value, printB _))/g' $FILE


sed -i 's/parseBase_TypesInteger_16()/parser.parseS16()/g' $FILE
sed -i 's/parseBase_TypesInteger_32()/parser.parseS32()/g' $FILE
sed -i 's/parseBase_TypesInteger_64()/parser.parseS64()/g' $FILE

sed -i 's/parseBase_TypesUnsigned_16()/parser.parseU16()/g' $FILE
sed -i 's/parseBase_TypesUnsigned_32()/parser.parseU32()/g' $FILE
sed -i 's/parseBase_TypesUnsigned_64()/parser.parseU64()/g' $FILE

sed -i 's/parseBase_TypesFloat_32()/parser.parseF32()/g' $FILE
sed -i 's/parseBase_TypesFloat_64()/parser.parseF64()/g' $FILE
