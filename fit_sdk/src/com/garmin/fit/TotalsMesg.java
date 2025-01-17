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


public class TotalsMesg extends Mesg {

   protected static final	Mesg totalsMesg;
   static {         
      // totals   
      totalsMesg = new Mesg("totals", MesgNum.TOTALS);
      totalsMesg.addField(new Field("message_index", 254, 132, 1, 0, "", false));
      
      totalsMesg.addField(new Field("timestamp", 253, 134, 1, 0, "s", false));
      
      totalsMesg.addField(new Field("timer_time", 0, 134, 1, 0, "s", false));
      
      totalsMesg.addField(new Field("distance", 1, 134, 1, 0, "m", false));
      
      totalsMesg.addField(new Field("calories", 2, 134, 1, 0, "kcal", false));
      
      totalsMesg.addField(new Field("sport", 3, 0, 1, 0, "", false));
      
      totalsMesg.addField(new Field("elapsed_time", 4, 134, 1, 0, "s", false));
      
      totalsMesg.addField(new Field("sessions", 5, 132, 1, 0, "", false));
      
      totalsMesg.addField(new Field("active_time", 6, 134, 1, 0, "s", false));
      
   }

   public TotalsMesg() {
      super(Factory.createMesg(MesgNum.TOTALS));
   }

   public TotalsMesg(final Mesg mesg) {
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
    * Get timestamp field
    * Units: s
    *
    * @return timestamp
    */
   public DateTime getTimestamp() {
      return timestampToDateTime(getFieldLongValue(253, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD));
   }

   /**
    * Set timestamp field
    * Units: s
    *
    * @param timestamp
    */
   public void setTimestamp(DateTime timestamp) {
      setFieldValue(253, 0, timestamp.getTimestamp(), Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get timer_time field
    * Units: s
    * Comment: Excludes pauses
    *
    * @return timer_time
    */
   public Long getTimerTime() {
      return getFieldLongValue(0, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set timer_time field
    * Units: s
    * Comment: Excludes pauses
    *
    * @param timerTime
    */
   public void setTimerTime(Long timerTime) {
      setFieldValue(0, 0, timerTime, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get distance field
    * Units: m
    *
    * @return distance
    */
   public Long getDistance() {
      return getFieldLongValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set distance field
    * Units: m
    *
    * @param distance
    */
   public void setDistance(Long distance) {
      setFieldValue(1, 0, distance, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get calories field
    * Units: kcal
    *
    * @return calories
    */
   public Long getCalories() {
      return getFieldLongValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set calories field
    * Units: kcal
    *
    * @param calories
    */
   public void setCalories(Long calories) {
      setFieldValue(2, 0, calories, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get sport field
    *
    * @return sport
    */
   public Sport getSport() {
      Short value = getFieldShortValue(3, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
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
      setFieldValue(3, 0, sport.value, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get elapsed_time field
    * Units: s
    * Comment: Includes pauses
    *
    * @return elapsed_time
    */
   public Long getElapsedTime() {
      return getFieldLongValue(4, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set elapsed_time field
    * Units: s
    * Comment: Includes pauses
    *
    * @param elapsedTime
    */
   public void setElapsedTime(Long elapsedTime) {
      setFieldValue(4, 0, elapsedTime, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get sessions field
    *
    * @return sessions
    */
   public Integer getSessions() {
      return getFieldIntegerValue(5, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set sessions field
    *
    * @param sessions
    */
   public void setSessions(Integer sessions) {
      setFieldValue(5, 0, sessions, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get active_time field
    * Units: s
    *
    * @return active_time
    */
   public Long getActiveTime() {
      return getFieldLongValue(6, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set active_time field
    * Units: s
    *
    * @param activeTime
    */
   public void setActiveTime(Long activeTime) {
      setFieldValue(6, 0, activeTime, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

}
