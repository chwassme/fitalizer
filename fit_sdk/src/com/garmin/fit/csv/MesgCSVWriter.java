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


package com.garmin.fit.csv;

import com.garmin.fit.*;

import java.util.Collection;
import java.util.Iterator;

public class MesgCSVWriter implements MesgListener, MesgDefinitionListener {
   private CSVWriter csv;

   public MesgCSVWriter(String fileName) {
      this.csv = new CSVWriter(fileName);
   }

   public void close() {
      csv.close();
   }

   public void onMesgDefinition(MesgDefinition mesgDef) {
      Collection<FieldDefinition> fields = mesgDef.getFields();
      Iterator<FieldDefinition> fieldsIterator;
      int headerNum;
      Mesg mesg = Factory.createMesg(mesgDef.getNum());

      csv.clear();
      csv.set("Type", "Definition");
      csv.set("Local Number", mesgDef.getLocalNum());

      if (mesg == null)
         csv.set("Message", "unknown");
      else
         csv.set("Message", mesg.getName());

      headerNum = 0;
      fieldsIterator = fields.iterator();

      while (fieldsIterator.hasNext()) {
         FieldDefinition fieldDef = fieldsIterator.next();
         Field field = Factory.createField(mesgDef.getNum(), fieldDef.getNum());
         headerNum++;

         if (field == null)
            csv.set("Field " + headerNum, "unknown");
         else
            csv.set("Field " + headerNum, field.getName());

         csv.set("Value " + headerNum, fieldDef.getSize() / Fit.baseTypeSizes[fieldDef.getType() & Fit.BASE_TYPE_NUM_MASK]);
         csv.set("Units " + headerNum, "");
      }

      csv.writeln();
   }
   
   public void onMesg(Mesg mesg) {
      Collection<Field> fields = mesg.getFields();
      Iterator<Field> fieldsIterator;
      int headerNum;

      csv.clear();
      csv.set("Type", "Data");
      csv.set("Local Number", mesg.getLocalNum());
      csv.set("Message", mesg.getName());

      headerNum = 0;
      fieldsIterator = fields.iterator();

      while (fieldsIterator.hasNext()) {
         Field field = fieldsIterator.next();
         int subFieldIndex = mesg.GetActiveSubFieldIndex(field.getNum());

         headerNum++;

         csv.set("Field " + headerNum, field.getName(subFieldIndex));

         String value = field.getStringValue(0, subFieldIndex);

         if (value == null)
            value = "";

         for (int fieldElement = 1; fieldElement < field.getNumValues(); fieldElement++) {
            value += "|";

            String nextValue = field.getStringValue(fieldElement, subFieldIndex);

            if (nextValue != null)
               value += nextValue;
         }

         csv.set("Value " + headerNum, value);
         csv.set("Units " + headerNum, field.getUnits(subFieldIndex));
      }

      csv.writeln();
   }
}
