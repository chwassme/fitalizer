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

public enum ActivitySubtype {
   GENERIC((short)0),
   TREADMILL((short)1),
   STREET((short)2),
   TRAIL((short)3),
   TRACK((short)4),
   SPIN((short)5),
   INDOOR_CYCLING((short)6),
   ROAD((short)7),
   MOUNTAIN((short)8),
   DOWNHILL((short)9),
   RECUMBENT((short)10),
   CYCLOCROSS((short)11),
   HAND_CYCLING((short)12),
   TRACK_CYCLING((short)13),
   INDOOR_ROWING((short)14),
   ELLIPTICAL((short)15),
   STAIR_CLIMBING((short)16),
   LAP_SWIMMING((short)17),
   OPEN_WATER((short)18),
   ALL((short)254),
   INVALID((short)255);


   protected short value;




   private ActivitySubtype(short value) {
     this.value = value;
   }

   public static ActivitySubtype getByValue(final Short value) {
      for (final ActivitySubtype type : ActivitySubtype.values()) {
         if (value == type.value)
            return type;
      }

      return ActivitySubtype.INVALID;
   }

   public short getValue() {
      return value;
   }


}
