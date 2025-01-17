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


public class DeviceSettingsMesg extends Mesg {

   protected static final	Mesg deviceSettingsMesg;
   static {         
      // device_settings   
      deviceSettingsMesg = new Mesg("device_settings", MesgNum.DEVICE_SETTINGS);
      deviceSettingsMesg.addField(new Field("utc_offset", 1, 134, 1, 0, "", false));
      
   }

   public DeviceSettingsMesg() {
      super(Factory.createMesg(MesgNum.DEVICE_SETTINGS));
   }

   public DeviceSettingsMesg(final Mesg mesg) {
      super(mesg);
   }


   /**
    * Get utc_offset field
    * Comment: Offset from system time. Required to convert timestamp from system time to UTC.
    *
    * @return utc_offset
    */
   public Long getUtcOffset() {
      return getFieldLongValue(1, 0, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

   /**
    * Set utc_offset field
    * Comment: Offset from system time. Required to convert timestamp from system time to UTC.
    *
    * @param utcOffset
    */
   public void setUtcOffset(Long utcOffset) {
      setFieldValue(1, 0, utcOffset, Fit.SUBFIELD_INDEX_MAIN_FIELD);
   }

}
