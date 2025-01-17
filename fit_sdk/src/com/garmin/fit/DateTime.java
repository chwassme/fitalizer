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

public class DateTime {
   public static final long MIN = 0x10000000; // if date_time is < 0x10000000 then it is system time (seconds from device power on)
   public static final long INVALID = Fit.UINT32_INVALID;
   public static final long OFFSET = 631065600000l; // Offset between Garmin (FIT) time and Unix time in ms (Dec 31, 1989 - 00:00:00 January 1, 1970).



   private long timestamp;


   public DateTime(long timestamp) {
      this.timestamp = timestamp;
   }

   public DateTime(java.util.Date date) {
      this.timestamp = (date.getTime() - OFFSET) / 1000;
   }

   public boolean equals(DateTime dateTime) {
      return (this.getTimestamp().equals(dateTime.getTimestamp()));
   }

   public void convertSystemTimeToUTC(long offset) {
      if (timestamp < MIN) {
         timestamp += offset;
      }
   }

   public Long getTimestamp() {
      return new Long(timestamp);
   }

   public java.util.Date getDate() {
      return new java.util.Date(timestamp * 1000 + OFFSET);
   }

   public String toString() {
      return getDate().toString();
   }

}
