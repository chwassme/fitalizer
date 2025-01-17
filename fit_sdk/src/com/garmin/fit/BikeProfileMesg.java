////////////////////////////////////////////////////////////////////////////////
// The following FIT Protocol software provided may be used with FIT protocol
// devices only and remains the copyrighted property of Dynastream Innovations Inc.
// The software is being provided on an "as-is" basis and as an accommodation,
// and therefore all warranties, representations, or guarantees of any kind
// (whether express, implied or statutory) including, without limitation,
// warranties of merchantability, non-infringement, or fitness for a particular
// purpose, are specifically disclaimed.
//
// Copyright 2014 Dynastream Innovations Inc.
////////////////////////////////////////////////////////////////////////////////
// ****WARNING****  This file is auto-generated!  Do NOT edit this file.
// Profile Version = 11.0Release
// Tag = $Name: AKW11_000 $
////////////////////////////////////////////////////////////////////////////////


package com.garmin.fit;


public class BikeProfileMesg extends Mesg {

   protected static final	Mesg bikeProfileMesg;
   static {         
      // bike_profile   
      bikeProfileMesg = new Mesg("bike_profile", MesgNum.BIKE_PROFILE);
      bikeProfileMesg.addField(new Field("message_index", 254, 132, 1, 0, "", false));
      
      bikeProfileMesg.addField(new Field("name", 0, 7, 1, 0, "", false));
      
      bikeProfileMesg.addField(new Field("sport", 1, 0, 1, 0, "", false));
      
      bikeProfileMesg.addField(new Field("sub_sport", 2, 0, 1, 0, "", false));
      
      bikeProfileMesg.addField(new Field("odometer", 3, 134, 100, 0, "m", false));
      
      bikeProfileMesg.addField(new Field("bike_spd_ant_id", 4, 139, 1, 0, "", false));
      
      bikeProfileMesg.addField(new Field("bike_cad_ant_id", 5, 139, 1, 0, "", false));
      
      bikeProfileMesg.addField(new Field("bike_spdcad_ant_id", 6, 139, 1, 0, "", false));
      
      bikeProfileMesg.addField(new Field("bike_power_ant_id", 7, 139, 1, 0, "", false));
      
      bikeProfileMesg.addField(new Field("custom_wheelsize", 8, 132, 1000, 0, "m", false));
      
      bikeProfileMesg.addField(new Field("auto_wheelsize", 9, 132, 1000, 0, "m", false));
      
      bikeProfileMesg.addField(new Field("bike_weight", 10, 132, 10, 0, "kg", false));
      
      bikeProfileMesg.addField(new Field("power_cal_factor", 11, 132, 10, 0, "%", false));
      
      bikeProfileMesg.addField(new Field("auto_wheel_cal", 12, 0, 1, 0, "", false));
      
      bikeProfileMesg.addField(new Field("auto_power_zero", 13, 0, 1, 0, "", false));
      
      bikeProfileMesg.addField(new Field("id", 14, 2, 1, 0, "", false));
      
      bikeProfileMesg.addField(new Field("spd_enabled", 15, 0, 1, 0, "", false));
      
      bikeProfileMesg.addField(new Field("cad_enabled", 16, 0, 1, 0, "", false));
      
      bikeProfileMesg.addField(new Field("spdcad_enabled", 17, 0, 1, 0, "", false));
      
      bikeProfileMesg.addField(new Field("power_enabled", 18, 0, 1, 0, "", false));
      
      bikeProfileMesg.addField(new Field("crank_length", 19, 2, 2, -110, "mm", false));
      
      bikeProfileMesg.addField(new Field("enabled", 20, 0, 1, 0, "", false));
      
      bikeProfileMesg.addField(new Field("bike_spd_ant_id_trans_type", 21, 10, 1, 0, "", false));
      
      bikeProfileMesg.addField(new Field("bike_cad_ant_id_trans_type", 22, 10, 1, 0, "", false));
      
      bikeProfileMesg.addField(new Field("bike_spdcad_ant_id_trans_type", 23, 10, 1, 0, "", false));
      
      bikeProfileMesg.addField(new Field("bike_power_ant_id_trans_type", 24, 10, 1, 0, "", false));
      
      bikeProfileMesg.addField(new Field("odometer_rollover", 37, 2, 1, 0, "", false));
      
      bikeProfileMesg.addField(new Field("front_gear_num", 38, 10, 1, 0, "", false));
      
      bikeProfileMesg.addField(new Field("front_gear", 39, 10, 1, 0, "", false));
      
      bikeProfileMesg.addField(new Field("rear_gear_num", 40, 10, 1, 0, "", false));
      
      bikeProfileMesg.addField(new Field("rear_gear", 41, 10, 1, 0, "", false));
      
   }

   public BikeProfileMesg() {
      super(Factory.createMesg(MesgNum.BIKE_PROFILE));
   }

   public BikeProfileMesg(final Mesg mesg) {
      super(mesg);
   }


   /**
    * Get message_index field
    *
    * @return message_index
    */
   public Integer getMessageIndex() {
      return getFieldIntegerValue(254, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set message_index field
    *
    * @param messageIndex
    */
   public void setMessageIndex(Integer messageIndex) {
      setFieldValue(254, 0, messageIndex, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get name field
    *
    * @return name
    */
   public String getName() {
      return getFieldStringValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set name field
    *
    * @param name
    */
   public void setName(String name) {
      setFieldValue(0, 0, name, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get sport field
    *
    * @return sport
    */
   public Sport getSport() {
      Short value = getFieldShortValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
      if (value == null)
         return null;
      return Sport.getByValue(value);
   }

   /**
    * Set sport field
    *
    * @param sport
    */
   public void setSport(Sport sport) {
      setFieldValue(1, 0, sport.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get sub_sport field
    *
    * @return sub_sport
    */
   public SubSport getSubSport() {
      Short value = getFieldShortValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
      if (value == null)
         return null;
      return SubSport.getByValue(value);
   }

   /**
    * Set sub_sport field
    *
    * @param subSport
    */
   public void setSubSport(SubSport subSport) {
      setFieldValue(2, 0, subSport.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get odometer field
    * Units: m
    *
    * @return odometer
    */
   public Float getOdometer() {
      return getFieldFloatValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set odometer field
    * Units: m
    *
    * @param odometer
    */
   public void setOdometer(Float odometer) {
      setFieldValue(3, 0, odometer, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get bike_spd_ant_id field
    *
    * @return bike_spd_ant_id
    */
   public Integer getBikeSpdAntId() {
      return getFieldIntegerValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set bike_spd_ant_id field
    *
    * @param bikeSpdAntId
    */
   public void setBikeSpdAntId(Integer bikeSpdAntId) {
      setFieldValue(4, 0, bikeSpdAntId, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get bike_cad_ant_id field
    *
    * @return bike_cad_ant_id
    */
   public Integer getBikeCadAntId() {
      return getFieldIntegerValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set bike_cad_ant_id field
    *
    * @param bikeCadAntId
    */
   public void setBikeCadAntId(Integer bikeCadAntId) {
      setFieldValue(5, 0, bikeCadAntId, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get bike_spdcad_ant_id field
    *
    * @return bike_spdcad_ant_id
    */
   public Integer getBikeSpdcadAntId() {
      return getFieldIntegerValue(6, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set bike_spdcad_ant_id field
    *
    * @param bikeSpdcadAntId
    */
   public void setBikeSpdcadAntId(Integer bikeSpdcadAntId) {
      setFieldValue(6, 0, bikeSpdcadAntId, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get bike_power_ant_id field
    *
    * @return bike_power_ant_id
    */
   public Integer getBikePowerAntId() {
      return getFieldIntegerValue(7, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set bike_power_ant_id field
    *
    * @param bikePowerAntId
    */
   public void setBikePowerAntId(Integer bikePowerAntId) {
      setFieldValue(7, 0, bikePowerAntId, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get custom_wheelsize field
    * Units: m
    *
    * @return custom_wheelsize
    */
   public Float getCustomWheelsize() {
      return getFieldFloatValue(8, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set custom_wheelsize field
    * Units: m
    *
    * @param customWheelsize
    */
   public void setCustomWheelsize(Float customWheelsize) {
      setFieldValue(8, 0, customWheelsize, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get auto_wheelsize field
    * Units: m
    *
    * @return auto_wheelsize
    */
   public Float getAutoWheelsize() {
      return getFieldFloatValue(9, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set auto_wheelsize field
    * Units: m
    *
    * @param autoWheelsize
    */
   public void setAutoWheelsize(Float autoWheelsize) {
      setFieldValue(9, 0, autoWheelsize, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get bike_weight field
    * Units: kg
    *
    * @return bike_weight
    */
   public Float getBikeWeight() {
      return getFieldFloatValue(10, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set bike_weight field
    * Units: kg
    *
    * @param bikeWeight
    */
   public void setBikeWeight(Float bikeWeight) {
      setFieldValue(10, 0, bikeWeight, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get power_cal_factor field
    * Units: %
    *
    * @return power_cal_factor
    */
   public Float getPowerCalFactor() {
      return getFieldFloatValue(11, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set power_cal_factor field
    * Units: %
    *
    * @param powerCalFactor
    */
   public void setPowerCalFactor(Float powerCalFactor) {
      setFieldValue(11, 0, powerCalFactor, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get auto_wheel_cal field
    *
    * @return auto_wheel_cal
    */
   public Bool getAutoWheelCal() {
      Short value = getFieldShortValue(12, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
      if (value == null)
         return null;
      return Bool.getByValue(value);
   }

   /**
    * Set auto_wheel_cal field
    *
    * @param autoWheelCal
    */
   public void setAutoWheelCal(Bool autoWheelCal) {
      setFieldValue(12, 0, autoWheelCal.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get auto_power_zero field
    *
    * @return auto_power_zero
    */
   public Bool getAutoPowerZero() {
      Short value = getFieldShortValue(13, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
      if (value == null)
         return null;
      return Bool.getByValue(value);
   }

   /**
    * Set auto_power_zero field
    *
    * @param autoPowerZero
    */
   public void setAutoPowerZero(Bool autoPowerZero) {
      setFieldValue(13, 0, autoPowerZero.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get id field
    *
    * @return id
    */
   public Short getId() {
      return getFieldShortValue(14, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set id field
    *
    * @param id
    */
   public void setId(Short id) {
      setFieldValue(14, 0, id, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get spd_enabled field
    *
    * @return spd_enabled
    */
   public Bool getSpdEnabled() {
      Short value = getFieldShortValue(15, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
      if (value == null)
         return null;
      return Bool.getByValue(value);
   }

   /**
    * Set spd_enabled field
    *
    * @param spdEnabled
    */
   public void setSpdEnabled(Bool spdEnabled) {
      setFieldValue(15, 0, spdEnabled.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get cad_enabled field
    *
    * @return cad_enabled
    */
   public Bool getCadEnabled() {
      Short value = getFieldShortValue(16, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
      if (value == null)
         return null;
      return Bool.getByValue(value);
   }

   /**
    * Set cad_enabled field
    *
    * @param cadEnabled
    */
   public void setCadEnabled(Bool cadEnabled) {
      setFieldValue(16, 0, cadEnabled.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get spdcad_enabled field
    *
    * @return spdcad_enabled
    */
   public Bool getSpdcadEnabled() {
      Short value = getFieldShortValue(17, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
      if (value == null)
         return null;
      return Bool.getByValue(value);
   }

   /**
    * Set spdcad_enabled field
    *
    * @param spdcadEnabled
    */
   public void setSpdcadEnabled(Bool spdcadEnabled) {
      setFieldValue(17, 0, spdcadEnabled.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get power_enabled field
    *
    * @return power_enabled
    */
   public Bool getPowerEnabled() {
      Short value = getFieldShortValue(18, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
      if (value == null)
         return null;
      return Bool.getByValue(value);
   }

   /**
    * Set power_enabled field
    *
    * @param powerEnabled
    */
   public void setPowerEnabled(Bool powerEnabled) {
      setFieldValue(18, 0, powerEnabled.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get crank_length field
    * Units: mm
    *
    * @return crank_length
    */
   public Float getCrankLength() {
      return getFieldFloatValue(19, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set crank_length field
    * Units: mm
    *
    * @param crankLength
    */
   public void setCrankLength(Float crankLength) {
      setFieldValue(19, 0, crankLength, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get enabled field
    *
    * @return enabled
    */
   public Bool getEnabled() {
      Short value = getFieldShortValue(20, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
      if (value == null)
         return null;
      return Bool.getByValue(value);
   }

   /**
    * Set enabled field
    *
    * @param enabled
    */
   public void setEnabled(Bool enabled) {
      setFieldValue(20, 0, enabled.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get bike_spd_ant_id_trans_type field
    *
    * @return bike_spd_ant_id_trans_type
    */
   public Short getBikeSpdAntIdTransType() {
      return getFieldShortValue(21, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set bike_spd_ant_id_trans_type field
    *
    * @param bikeSpdAntIdTransType
    */
   public void setBikeSpdAntIdTransType(Short bikeSpdAntIdTransType) {
      setFieldValue(21, 0, bikeSpdAntIdTransType, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get bike_cad_ant_id_trans_type field
    *
    * @return bike_cad_ant_id_trans_type
    */
   public Short getBikeCadAntIdTransType() {
      return getFieldShortValue(22, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set bike_cad_ant_id_trans_type field
    *
    * @param bikeCadAntIdTransType
    */
   public void setBikeCadAntIdTransType(Short bikeCadAntIdTransType) {
      setFieldValue(22, 0, bikeCadAntIdTransType, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get bike_spdcad_ant_id_trans_type field
    *
    * @return bike_spdcad_ant_id_trans_type
    */
   public Short getBikeSpdcadAntIdTransType() {
      return getFieldShortValue(23, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set bike_spdcad_ant_id_trans_type field
    *
    * @param bikeSpdcadAntIdTransType
    */
   public void setBikeSpdcadAntIdTransType(Short bikeSpdcadAntIdTransType) {
      setFieldValue(23, 0, bikeSpdcadAntIdTransType, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get bike_power_ant_id_trans_type field
    *
    * @return bike_power_ant_id_trans_type
    */
   public Short getBikePowerAntIdTransType() {
      return getFieldShortValue(24, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set bike_power_ant_id_trans_type field
    *
    * @param bikePowerAntIdTransType
    */
   public void setBikePowerAntIdTransType(Short bikePowerAntIdTransType) {
      setFieldValue(24, 0, bikePowerAntIdTransType, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get odometer_rollover field
    * Comment: Rollover counter that can be used to extend the odometer
    *
    * @return odometer_rollover
    */
   public Short getOdometerRollover() {
      return getFieldShortValue(37, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set odometer_rollover field
    * Comment: Rollover counter that can be used to extend the odometer
    *
    * @param odometerRollover
    */
   public void setOdometerRollover(Short odometerRollover) {
      setFieldValue(37, 0, odometerRollover, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get front_gear_num field
    * Comment: Number of front gears
    *
    * @return front_gear_num
    */
   public Short getFrontGearNum() {
      return getFieldShortValue(38, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set front_gear_num field
    * Comment: Number of front gears
    *
    * @param frontGearNum
    */
   public void setFrontGearNum(Short frontGearNum) {
      setFieldValue(38, 0, frontGearNum, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * @return number of front_gear
    */
   public int getNumFrontGear() {
      return getNumFieldValues(39, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get front_gear field
    * Comment: Number of teeth on each gear 0 is innermost
    *
    * @param index of front_gear
    * @return front_gear
    */
   public Short getFrontGear(int index) {
      return getFieldShortValue(39, index, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set front_gear field
    * Comment: Number of teeth on each gear 0 is innermost
    *
    * @param index of front_gear
    * @param frontGear
    */
   public void setFrontGear(int index, Short frontGear) {
      setFieldValue(39, index, frontGear, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get rear_gear_num field
    * Comment: Number of rear gears
    *
    * @return rear_gear_num
    */
   public Short getRearGearNum() {
      return getFieldShortValue(40, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set rear_gear_num field
    * Comment: Number of rear gears
    *
    * @param rearGearNum
    */
   public void setRearGearNum(Short rearGearNum) {
      setFieldValue(40, 0, rearGearNum, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * @return number of rear_gear
    */
   public int getNumRearGear() {
      return getNumFieldValues(41, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get rear_gear field
    * Comment: Number of teeth on each gear 0 is innermost
    *
    * @param index of rear_gear
    * @return rear_gear
    */
   public Short getRearGear(int index) {
      return getFieldShortValue(41, index, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set rear_gear field
    * Comment: Number of teeth on each gear 0 is innermost
    *
    * @param index of rear_gear
    * @param rearGear
    */
   public void setRearGear(int index, Short rearGear) {
      setFieldValue(41, index, rearGear, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

}
