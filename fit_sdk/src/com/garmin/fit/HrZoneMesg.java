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


public class HrZoneMesg extends Mesg {

   protected static final	Mesg hrZoneMesg;
   static {         
      // hr_zone   
      hrZoneMesg = new Mesg("hr_zone", MesgNum.HR_ZONE);
      hrZoneMesg.addField(new Field("message_index", 254, 132, 1, 0, "", false));
      
      hrZoneMesg.addField(new Field("high_bpm", 1, 2, 1, 0, "bpm", false));
      
      hrZoneMesg.addField(new Field("name", 2, 7, 1, 0, "", false));
      
   }

   public HrZoneMesg() {
      super(Factory.createMesg(MesgNum.HR_ZONE));
   }

   public HrZoneMesg(final Mesg mesg) {
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
    * Get high_bpm field
    * Units: bpm
    *
    * @return high_bpm
    */
   public Short getHighBpm() {
      return getFieldShortValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set high_bpm field
    * Units: bpm
    *
    * @param highBpm
    */
   public void setHighBpm(Short highBpm) {
      setFieldValue(1, 0, highBpm, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Get name field
    *
    * @return name
    */
   public String getName() {
      return getFieldStringValue(2, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set name field
    *
    * @param name
    */
   public void setName(String name) {
      setFieldValue(2, 0, name, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

}
