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

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.DataInputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.io.OutputStreamWriter;

public class Field {
   protected String name;
   protected int num;
   protected int type;
   protected double scale;
   protected double offset;
   protected String units;
   protected boolean isAccumulated;
   protected ArrayList<Object> values;
   protected ArrayList<FieldComponent> components;
   protected ArrayList<SubField> subFields;

   public Field(final Field field) {
      if (field == null) {
         this.name = "unknown";
         this.num = Fit.FIELD_NUM_INVALID;
         this.type = 0;
         this.scale = 1;
         this.offset = 0;
         this.units = "";
         this.isAccumulated = false;
         this.values = new ArrayList<Object>();
         this.components = new ArrayList<FieldComponent>();
         this.subFields = new ArrayList<SubField>();
         return;
      }

      this.name = new String(field.name);
      this.num = field.num;
      this.type = field.type;
      this.scale = field.scale;
      this.offset = field.offset;
      this.units = new String(field.units);
      this.isAccumulated = field.isAccumulated;
      this.values = new ArrayList<Object>();
      for (Object value : field.values) {
         if (value instanceof Byte) {
            this.values.add(new Byte((Byte) value));
         } else if (value instanceof Short) {
            this.values.add(new Short((Short) value));
         } else if (value instanceof Integer) {
            this.values.add(new Integer((Integer) value));
         } else if (value instanceof Long) {
            this.values.add(new Long((Long) value));
         } else if (value instanceof Float) {
            this.values.add(new Float((Float) value));
         } else if (value instanceof Double) {
            this.values.add(new Double((Double) value));
         } else if (value instanceof String) {
            this.values.add(new String((String) value));
         }
      }
      this.components = field.components;
      this.subFields = field.subFields;
   }

   protected Field(String name, int num, int type, double scale, double offset, String units, boolean accumulated) {
      this.name = new String(name);
      this.num = num;
      this.type = type;
      this.scale = scale;
      this.offset = offset;
      this.units = new String(units);
      this.isAccumulated = accumulated;
      this.values = new ArrayList<Object>();
      this.components = new ArrayList<FieldComponent>();
      this.subFields = new ArrayList<SubField>();
   }

   public String getName() {
      return getNameInternal(null);
   }

   public String getName(int subFieldIndex) {
      return getNameInternal(getSubField(subFieldIndex));
   }

   public String getName(String subFieldName) {
      return getNameInternal(getSubField(subFieldName));
   }

   private String getNameInternal(SubField subField) {
      if (subField == null)
         return name;
      else
         return subField.name;
   }

   public int getNum() {
      return num;
   }

   public int getType() {
      return getTypeInternal(null);
   }

   public int getType(int subFieldIndex) {
      return getTypeInternal(getSubField(subFieldIndex));
   }

   public int getType(String subFieldName) {
      return getTypeInternal(getSubField(subFieldName));
   }

   private int getTypeInternal(SubField subField) {
      if (subField == null)
         return type;
      else
         return subField.type;
   }

   public String getUnits() {
      return getUnitsInternal(null);
   }

   public String getUnits(int subFieldIndex) {
      return getUnitsInternal(getSubField(subFieldIndex));
   }

   public String getUnits(String subFieldName) {
      return getUnitsInternal(getSubField(subFieldName));
   }

   private String getUnitsInternal(SubField subField) {
      if (subField == null)
         return units;
      else
         return subField.units;
   }

   public boolean getIsAccumulated() {
      return this.isAccumulated;
   }

   protected int getSize() {
      int size = 0;

      switch (type) {
         case Fit.BASE_TYPE_ENUM:
         case Fit.BASE_TYPE_UINT8:
         case Fit.BASE_TYPE_UINT8Z:
         case Fit.BASE_TYPE_SINT8:
         case Fit.BASE_TYPE_BYTE:
         case Fit.BASE_TYPE_SINT16:
         case Fit.BASE_TYPE_UINT16:
         case Fit.BASE_TYPE_UINT16Z:
         case Fit.BASE_TYPE_SINT32:
         case Fit.BASE_TYPE_UINT32:
         case Fit.BASE_TYPE_UINT32Z:
         case Fit.BASE_TYPE_FLOAT32:
         case Fit.BASE_TYPE_FLOAT64:
            size = getNumValues() * Fit.baseTypeSizes[type & Fit.BASE_TYPE_NUM_MASK];
            break;

         case Fit.BASE_TYPE_STRING:
            for (Object value : values) {
               try {
                  size += value.toString().getBytes("UTF-8").length + 1;
               } catch (UnsupportedEncodingException e) {
               }
            }
            break;

         default:
            break;
      }

      return size;
   }

   protected SubField getSubField(String subFieldName) {
      for (int i = 0; i < subFields.size(); i++) {
         if (subFields.get(i).name.equals(subFieldName))
            return subFields.get(i);
      }

      return null;
   }

   protected SubField getSubField(int subFieldIndex) {
      if ((subFieldIndex >= 0) && (subFieldIndex < subFields.size()))
         return subFields.get(subFieldIndex);
      else
         return null;
   }

   protected boolean isSignedInteger() {
      return isSignedIntegerInternal(null);
   }

   protected boolean isSignedInteger(int subFieldIndex) {
      return isSignedIntegerInternal(getSubField(subFieldIndex));
   }

   protected boolean isSignedInteger(String subFieldName) {
      return isSignedIntegerInternal(getSubField(subFieldName));
   }

   private boolean isSignedIntegerInternal(SubField subField) {
      switch (getTypeInternal(subField)) {
         case Fit.BASE_TYPE_SINT8:
         case Fit.BASE_TYPE_SINT16:
         case Fit.BASE_TYPE_SINT32:
            return true;

         default:
            break;
      }

      return false;
   }

   public void addValue(Object value) {
      if ((value instanceof Number) && (type == Fit.BASE_TYPE_STRING)) {
         String string = getStringValueInternal(0, null);
         Number number = (Number) value;

         if (string == null)
            string = "";

         string += String.valueOf((char) (number.intValue()));
         setValueInternal(0, string, null);
         return;
      }

      values.add(value);
   }

   public int getNumValues() {
      return values.size();
   }

   public Object getRawValue() {
      return getRawValueInternal(0, null);
   }

   public Object getRawValue(int fieldArrayIndex) {
      return getRawValueInternal(fieldArrayIndex, null);
   }

   public Object getRawValue(int fieldArrayIndex, int subFieldIndex) {
      return getRawValueInternal(fieldArrayIndex, getSubField(subFieldIndex));
   }

   public Object getRawValue(int fieldArrayIndex, String subFieldName) {
      return getRawValueInternal(fieldArrayIndex, getSubField(subFieldName));
   }

   private Object getRawValueInternal(int fieldArrayIndex, SubField subField) {
      Object value;

      if (fieldArrayIndex >= values.size())
         return null;

      value = values.get(fieldArrayIndex);
      return value;
   }

   public Object getValue() {
      return getValueInternal(0, null);
   }

   public Object getValue(int fieldArrayIndex) {
      return getValueInternal(fieldArrayIndex, null);
   }

   public Object getValue(int fieldArrayIndex, int subFieldIndex) {
      return getValueInternal(fieldArrayIndex, getSubField(subFieldIndex));
   }

   public Object getValue(int fieldArrayIndex, String subFieldName) {
      return getValueInternal(fieldArrayIndex, getSubField(subFieldName));
   }

   private Object getValueInternal(int fieldArrayIndex, SubField subField) {
      Object value;
      double scale;
      double offset;

      if (fieldArrayIndex >= values.size())
         return null;

      if (subField == null) {
         scale = this.scale;
         offset = this.offset;
      }
      else {
         scale = subField.scale;
         offset = subField.offset;
      }

      value = values.get(fieldArrayIndex);

      if (value instanceof Number) {
         switch (type) {
            case Fit.BASE_TYPE_ENUM:
               if (((Short) ((Number) value).shortValue()).equals(Fit.ENUM_INVALID))
                  return Fit.ENUM_INVALID;
               break;
            case Fit.BASE_TYPE_SINT8:
               if (((Byte) ((Number) value).byteValue()).equals(Fit.SINT8_INVALID))
                  return Fit.SINT8_INVALID;
               break;
            case Fit.BASE_TYPE_UINT8:
               if (((Short) ((Number) value).shortValue()).equals(Fit.UINT8_INVALID))
                  return Fit.UINT8_INVALID;
               break;
            case Fit.BASE_TYPE_UINT8Z:
               if (((Short) ((Number) value).shortValue()).equals(Fit.UINT8Z_INVALID))
                  return Fit.UINT8Z_INVALID;
               break;
            case Fit.BASE_TYPE_SINT16:
               if (((Short) ((Number) value).shortValue()).equals(Fit.SINT16_INVALID))
                  return Fit.SINT16_INVALID;
               break;
            case Fit.BASE_TYPE_UINT16:
               if (((Integer) ((Number) value).intValue()).equals(Fit.UINT16_INVALID))
                  return Fit.UINT16_INVALID;
               break;
            case Fit.BASE_TYPE_UINT16Z:
               if (((Integer) ((Number) value).intValue()).equals(Fit.UINT16Z_INVALID))
                  return Fit.UINT16Z_INVALID;
               break;
            case Fit.BASE_TYPE_SINT32:
               if (((Integer) ((Number) value).intValue()).equals(Fit.SINT32_INVALID))
                  return Fit.SINT32_INVALID;
               break;
            case Fit.BASE_TYPE_UINT32:
               if (((Long) ((Number) value).longValue()).equals(Fit.UINT32_INVALID))
                  return Fit.UINT32_INVALID;
               break;
            case Fit.BASE_TYPE_UINT32Z:
               if (((Long) ((Number) value).longValue()).equals(Fit.UINT32Z_INVALID))
                  return Fit.UINT32Z_INVALID;
               break;
            case Fit.BASE_TYPE_FLOAT32:
               if (((Float) ((Number) value).floatValue()).equals(Fit.FLOAT32_INVALID))
                  return Fit.FLOAT32_INVALID;
               break;
            case Fit.BASE_TYPE_FLOAT64:
               if (((Double) ((Number) value).doubleValue()).equals(Fit.FLOAT64_INVALID))
                  return Fit.FLOAT64_INVALID;
               break;
            case Fit.BASE_TYPE_BYTE:
               if (((Short) ((Number) value).shortValue()).equals(Fit.BYTE_INVALID))
                  return Fit.BYTE_INVALID;
               break;
            default:
               break;
         }

         if ((scale != 1) || (offset != 0)) {
            return new Double(((Number) value).doubleValue() / scale - offset);
         }
      }

      return value;
   }

   public void setValue(Object value) {
      setValueInternal(0, value, null);
   }

   public void setValue(Object value, int subFieldIndex) {
      setValueInternal(0, value, getSubField(subFieldIndex));
   }

   public void setValue(Object value, String subFieldName) {
      setValueInternal(0, value, getSubField(subFieldName));
   }

   public void setValue(int fieldArrayIndex, Object value) {
      setValueInternal(fieldArrayIndex, value, null);
   }

   public void setValue(int fieldArrayIndex, Object value, int subFieldIndex) {
      SubField subField = null;

      if (subFieldIndex != Fit.SUBFIELD_INDEX_MAIN_FIELD) {
         subField = getSubField(subFieldIndex);

         if (subField == null)
            throw new FitRuntimeException("com.garmin.fit.Field.setValue(): " + subFieldIndex + " is not a valid subfield index of " + this.name + ".");
      }

      setValueInternal(fieldArrayIndex, value, subField);
   }

   public void setValue(int fieldArrayIndex, Object value, String subFieldName) {
      setValueInternal(fieldArrayIndex, value, getSubField(subFieldName));
   }

   private void setValueInternal(int fieldArrayIndex, Object value, SubField subField) {
      while (fieldArrayIndex >= getNumValues())
         addValue(new Object());

      double scale;
      double offset;

      if (subField == null) {
         scale = this.scale;
         offset = this.offset;
      }
      else {
         scale = subField.scale;
         offset = subField.offset;
      }

      if (value == null) {
         values.set(fieldArrayIndex, null);
      }
      else if ((value instanceof Number) && ((scale != 1) || (offset != 0))) {
         double rawValue = (((Number) value).doubleValue() + offset) * scale;
         switch (type) {
            case Fit.BASE_TYPE_ENUM:
            case Fit.BASE_TYPE_UINT8:
            case Fit.BASE_TYPE_UINT8Z:
            case Fit.BASE_TYPE_SINT16:
            case Fit.BASE_TYPE_BYTE:
               values.set(fieldArrayIndex, (Short) ((short) Math.round(rawValue)));
               break;
            case Fit.BASE_TYPE_SINT8:
               values.set(fieldArrayIndex, (Byte) ((byte) Math.round(rawValue)));
               break;
            case Fit.BASE_TYPE_UINT16:
            case Fit.BASE_TYPE_UINT16Z:
            case Fit.BASE_TYPE_SINT32:
               values.set(fieldArrayIndex, (Integer) ((int) Math.round(rawValue)));
               break;
            case Fit.BASE_TYPE_UINT32:
            case Fit.BASE_TYPE_UINT32Z:
               values.set(fieldArrayIndex, (Long) (Math.round(rawValue)));
               break;
            case Fit.BASE_TYPE_FLOAT32:
               values.set(fieldArrayIndex, (Float) ((float) rawValue));
               break;
            case Fit.BASE_TYPE_FLOAT64:
               values.set(fieldArrayIndex, (Double) rawValue);
               break;
            case Fit.BASE_TYPE_STRING:
               values.set(fieldArrayIndex, ((Double) rawValue).toString());
               break;
            default:
               break;
         }
      }
      else if ((value instanceof String) && (((String) value).equals(""))) {
         switch (type) {
            case Fit.BASE_TYPE_ENUM:
               values.set(fieldArrayIndex, Fit.ENUM_INVALID);
               break;
            case Fit.BASE_TYPE_SINT8:
               values.set(fieldArrayIndex, Fit.SINT8_INVALID);
               break;
            case Fit.BASE_TYPE_UINT8:
               values.set(fieldArrayIndex, Fit.UINT8_INVALID);
               break;
            case Fit.BASE_TYPE_UINT8Z:
               values.set(fieldArrayIndex, Fit.UINT8Z_INVALID);
               break;
            case Fit.BASE_TYPE_SINT16:
               values.set(fieldArrayIndex, Fit.SINT16_INVALID);
               break;
            case Fit.BASE_TYPE_UINT16:
               values.set(fieldArrayIndex, Fit.UINT16_INVALID);
               break;
            case Fit.BASE_TYPE_UINT16Z:
               values.set(fieldArrayIndex, Fit.UINT16Z_INVALID);
               break;
            case Fit.BASE_TYPE_SINT32:
               values.set(fieldArrayIndex, Fit.SINT32_INVALID);
               break;
            case Fit.BASE_TYPE_UINT32:
               values.set(fieldArrayIndex, Fit.UINT32_INVALID);
               break;
            case Fit.BASE_TYPE_UINT32Z:
               values.set(fieldArrayIndex, Fit.UINT32Z_INVALID);
               break;
            case Fit.BASE_TYPE_STRING:
               values.set(fieldArrayIndex, value);
               break;
            case Fit.BASE_TYPE_FLOAT32:
               values.set(fieldArrayIndex, Fit.FLOAT32_INVALID);
               break;
            case Fit.BASE_TYPE_FLOAT64:
               values.set(fieldArrayIndex, Fit.FLOAT64_INVALID);
               break;
            case Fit.BASE_TYPE_BYTE:
               values.set(fieldArrayIndex, Fit.BYTE_INVALID);
               break;
            default:
               break;
         }
      }
      else {
         values.set(fieldArrayIndex, value);
      }
   }

   public Long getBitsValue(int offset, int bits, boolean signed) {
      long value = 0;
      int bitsInValue = 0;
      int bitsInData;
      int index = 0;
      Long data;
      long mask;

      while (bitsInValue < bits) {
         data = getLongValueInternal(index++, null);

         if (data == null)
            return null;

         data >>= offset;
         bitsInData = Fit.baseTypeSizes[type & Fit.BASE_TYPE_NUM_MASK] * 8 - offset;
         offset -= Fit.baseTypeSizes[type & Fit.BASE_TYPE_NUM_MASK] * 8;

         if (bitsInData > 0) {
            offset = 0;

            if (bitsInData > (bits - bitsInValue))
               bitsInData = bits - bitsInValue;

            mask = ((long) 1 << bitsInData) - 1;
            value |= ((long) data.longValue() & mask) << bitsInValue;
            bitsInValue += bitsInData;
         }
      }

      if (signed) {
         long signBit = (1L << (bits - 1));

         if ((value & signBit) != 0)
            value = -signBit + (value & (signBit - 1));
      }

      return value;
   }

   public Byte getByteValue() {
      return getByteValueInternal(0, null);
   }

   public Byte getByteValue(int fieldArrayIndex) {
      return getByteValueInternal(fieldArrayIndex, null);
   }

   public Byte getByteValue(int fieldArrayIndex, int subFieldIndex) {
      return getByteValueInternal(fieldArrayIndex, getSubField(subFieldIndex));
   }

   public Byte getByteValue(int fieldArrayIndex, String subFieldName) {
      return getByteValueInternal(fieldArrayIndex, getSubField(subFieldName));
   }

   private Byte getByteValueInternal(int fieldArrayIndex, SubField subField) {
      Object value = getValueInternal(fieldArrayIndex, subField);

      if (value == null)
         return null;

      return ((Number) value).byteValue();
   }

   public Short getShortValue() {
      return getShortValueInternal(0, null);
   }

   public Short getShortValue(int fieldArrayIndex) {
      return getShortValueInternal(fieldArrayIndex, null);
   }

   public Short getShortValue(int fieldArrayIndex, int subFieldIndex) {
      return getShortValueInternal(fieldArrayIndex, getSubField(subFieldIndex));
   }

   public Short getShortValue(int fieldArrayIndex, String subFieldName) {
      return getShortValueInternal(fieldArrayIndex, getSubField(subFieldName));
   }

   private Short getShortValueInternal(int fieldArrayIndex, SubField subField) {
      Object value = getValueInternal(fieldArrayIndex, subField);

      if (value == null)
         return null;

      return ((Number) value).shortValue();
   }

   public Integer getIntegerValue() {
      return getIntegerValueInternal(0, null);
   }

   public Integer getIntegerValue(int fieldArrayIndex) {
      return getIntegerValueInternal(fieldArrayIndex, null);
   }

   public Integer getIntegerValue(int fieldArrayIndex, int subFieldIndex) {
      return getIntegerValueInternal(fieldArrayIndex, getSubField(subFieldIndex));
   }

   public Integer getIntegerValue(int fieldArrayIndex, String subFieldName) {
      return getIntegerValueInternal(fieldArrayIndex, getSubField(subFieldName));
   }

   private Integer getIntegerValueInternal(int fieldArrayIndex, SubField subField) {
      Object value = getValueInternal(fieldArrayIndex, subField);

      if (value == null)
         return null;

      return ((Number) value).intValue();
   }

   public Long getLongValue() {
      return getLongValueInternal(0, null);
   }

   public Long getLongValue(int fieldArrayIndex) {
      return getLongValueInternal(fieldArrayIndex, null);
   }

   public Long getLongValue(int fieldArrayIndex, int subFieldIndex) {
      return getLongValueInternal(fieldArrayIndex, getSubField(subFieldIndex));
   }

   public Long getLongValue(int fieldArrayIndex, String subFieldName) {
      return getLongValueInternal(fieldArrayIndex, getSubField(subFieldName));
   }

   private Long getLongValueInternal(int fieldArrayIndex, SubField subField) {
      Object value = getValueInternal(fieldArrayIndex, subField);

      if (value == null)
         return null;

      return ((Number) value).longValue();
   }

   public Float getFloatValue() {
      return getFloatValueInternal(0, null);
   }

   public Float getFloatValue(int fieldArrayIndex) {
      return getFloatValueInternal(fieldArrayIndex, null);
   }

   public Float getFloatValue(int fieldArrayIndex, int subFieldIndex) {
      return getFloatValueInternal(fieldArrayIndex, getSubField(subFieldIndex));
   }

   public Float getFloatValue(int fieldArrayIndex, String subFieldName) {
      return getFloatValueInternal(fieldArrayIndex, getSubField(subFieldName));
   }

   private Float getFloatValueInternal(int fieldArrayIndex, SubField subField) {
      Object value = getValueInternal(fieldArrayIndex, subField);

      if (value == null)
         return null;

      return new Float(((Number) value).doubleValue());
   }

   public Double getDoubleValue() {
      return getDoubleValueInternal(0, null);
   }

   public Double getDoubleValue(int fieldArrayIndex) {
      return getDoubleValueInternal(fieldArrayIndex, null);
   }

   public Double getDoubleValue(int fieldArrayIndex, int subFieldIndex) {
      return getDoubleValueInternal(fieldArrayIndex, getSubField(subFieldIndex));
   }

   public Double getDoubleValue(int fieldArrayIndex, String subFieldName) {
      return getDoubleValueInternal(fieldArrayIndex, getSubField(subFieldName));
   }

   private Double getDoubleValueInternal(int fieldArrayIndex, SubField subField) {
      Object value = getValueInternal(fieldArrayIndex, subField);

      if (value == null)
         return null;

      return new Double(((Number) value).doubleValue());
   }

   public String getStringValue() {
      return getStringValueInternal(0, null);
   }

   public String getStringValue(int fieldArrayIndex) {
      return getStringValueInternal(fieldArrayIndex, null);
   }

   public String getStringValue(int fieldArrayIndex, int subFieldIndex) {
      return getStringValueInternal(fieldArrayIndex, getSubField(subFieldIndex));
   }

   public String getStringValue(int fieldArrayIndex, String subFieldName) {
      return getStringValueInternal(fieldArrayIndex, getSubField(subFieldName));
   }

   private String getStringValueInternal(int fieldArrayIndex, SubField subField) {
      Object value = getValueInternal(fieldArrayIndex, subField);

      if (value == null)
         return null;

      switch (type)
      {
         case Fit.BASE_TYPE_ENUM:
            if (value.equals(Fit.ENUM_INVALID))
               return null;
            break;
         case Fit.BASE_TYPE_SINT8:
            if (value.equals(Fit.SINT8_INVALID))
               return null;
            break;
         case Fit.BASE_TYPE_UINT8:
            if (value.equals(Fit.UINT8_INVALID))
               return null;
            break;
         case Fit.BASE_TYPE_UINT8Z:
            if (value.equals(Fit.UINT8Z_INVALID))
               return null;
            break;
         case Fit.BASE_TYPE_SINT16:
            if (value.equals(Fit.SINT16_INVALID))
               return null;
            break;
         case Fit.BASE_TYPE_UINT16:
            if (value.equals(Fit.UINT16_INVALID))
               return null;
            break;
         case Fit.BASE_TYPE_UINT16Z:
            if (value.equals(Fit.UINT16Z_INVALID))
               return null;
            break;
         case Fit.BASE_TYPE_SINT32:
            if (value.equals(Fit.SINT32_INVALID))
               return null;
            break;
         case Fit.BASE_TYPE_UINT32:
            if (value.equals(Fit.UINT32_INVALID))
               return null;
            break;
         case Fit.BASE_TYPE_UINT32Z:
            if (value.equals(Fit.UINT32Z_INVALID))
               return null;
            break;
         case Fit.BASE_TYPE_FLOAT32:
            if (value.equals(Fit.FLOAT32_INVALID))
               return null;
            break;
         case Fit.BASE_TYPE_FLOAT64:
            if (value.equals(Fit.FLOAT64_INVALID))
               return null;
            break;
         case Fit.BASE_TYPE_BYTE:
            if (value.equals(Fit.BYTE_INVALID))
               return null;
            break;
         default:
            break;
      }

      return value.toString();
   }

   protected boolean read(InputStream in, int size) {
      try {
         DataInputStream data = new DataInputStream(in);
         if (type == Fit.BASE_TYPE_STRING) {
            try {
               ByteArrayOutputStream buffer = new ByteArrayOutputStream();
               int emptyStrings = 0;

               for (int i=0; i<size; i++)
               {
                  int b = in.read();
                  if (b == 0) {
                     if (buffer.size() > 0) {
                        while (emptyStrings > 0) {
                           values.add(new String());
                           emptyStrings--;
                        }

                        values.add(new String(buffer.toByteArray(), "UTF-8"));
                     } else {
                        emptyStrings++;
                     }

                     buffer.reset();
                  } else {
                     buffer.write(b);
                  }
               }

               if (buffer.size() > 0) {
                  while (emptyStrings > 0) {
                     values.add(new String());
                     emptyStrings--;
                  }

                  values.add(new String(buffer.toByteArray(), "UTF-8"));
               }
            } catch (java.io.EOFException e) {
               return true;
            }
         } else {
            int bytesLeft = size;
            boolean invalid = true;

            while (bytesLeft > 0) {
               switch (type) {
                  case Fit.BASE_TYPE_ENUM: {
                     Short value = (short) (data.readByte() & 0xFF);
                     values.add(value);
                     if (!value.equals(Fit.ENUM_INVALID))
                        invalid = false;
                     break;
                  }

                  case Fit.BASE_TYPE_UINT8: {
                     Short value = (short) (data.readByte() & 0xFF);
                     values.add(value);
                     if (!value.equals(Fit.UINT8_INVALID))
                        invalid = false;
                     break;
                  }

                  case Fit.BASE_TYPE_UINT8Z: {
                     Short value = (short) (data.readByte() & 0xFF);
                     values.add(value);
                     if (!value.equals(Fit.UINT8Z_INVALID))
                        invalid = false;
                     break;
                  }

                  case Fit.BASE_TYPE_SINT8: {
                     Byte value = data.readByte();
                     values.add(value);
                     if (!value.equals(Fit.SINT8_INVALID))
                        invalid = false;
                     break;
                  }

                  case Fit.BASE_TYPE_SINT16: {
                     Short value = data.readShort();
                     values.add(value);
                     if (!value.equals(Fit.SINT16_INVALID))
                        invalid = false;
                     break;
                  }

                  case Fit.BASE_TYPE_UINT16: {
                     Integer value = data.readByte() & 0xFF;
                     value <<= 8;
                     value |= data.readByte() & 0xFF;
                     values.add(value);
                     if (!value.equals(Fit.UINT16_INVALID))
                        invalid = false;
                     break;
                  }

                  case Fit.BASE_TYPE_UINT16Z: {
                     Integer value = data.readByte() & 0xFF;
                     value <<= 8;
                     value |= data.readByte() & 0xFF;
                     values.add(value);
                     if (!value.equals(Fit.UINT16Z_INVALID))
                        invalid = false;
                     break;
                  }

                  case Fit.BASE_TYPE_SINT32: {
                     Integer value = data.readInt();
                     values.add(value);
                     if (!value.equals(Fit.SINT32_INVALID))
                        invalid = false;
                     break;
                  }

                  case Fit.BASE_TYPE_UINT32: {
                     Long value = (long) (data.readByte() & 0xFF);
                     value <<= 8;
                     value |= data.readByte() & 0xFF;
                     value <<= 8;
                     value |= data.readByte() & 0xFF;
                     value <<= 8;
                     value |= data.readByte() & 0xFF;
                     values.add(value);
                     if (!value.equals(Fit.UINT32_INVALID))
                        invalid = false;
                     break;
                  }

                  case Fit.BASE_TYPE_UINT32Z: {
                     Long value = (long) (data.readByte() & 0xFF);
                     value <<= 8;
                     value |= data.readByte() & 0xFF;
                     value <<= 8;
                     value |= data.readByte() & 0xFF;
                     value <<= 8;
                     value |= data.readByte() & 0xFF;
                     values.add(value);
                     if (!value.equals(Fit.UINT32Z_INVALID))
                        invalid = false;
                     break;
                  }

                  case Fit.BASE_TYPE_FLOAT32: {
                     Float value = data.readFloat();
                     values.add(value);
                     if (!value.equals(Fit.FLOAT32_INVALID))
                        invalid = false;
                     break;
                  }

                  case Fit.BASE_TYPE_FLOAT64: {
                     Double value = data.readDouble();
                     values.add(value);
                     if (!value.equals(Fit.FLOAT64_INVALID))
                        invalid = false;
                     break;
                  }

                  case Fit.BASE_TYPE_BYTE: {
                     Short value = (short) (data.readByte() & 0xFF);
                     values.add(value);
                     if (!value.equals(Fit.BYTE_INVALID))
                        invalid = false;
                     break;
                  }

                  default:
                     return false;
               }

               bytesLeft -= Fit.baseTypeSizes[type & Fit.BASE_TYPE_NUM_MASK];
            }

            if (invalid)
               values.clear();
         }
      } catch (java.io.IOException e) {
         return false;
      }

      return true;
   }

   protected void write(OutputStream out, FieldDefinition fieldDef) {
      int bytesLeft = fieldDef.size - getSize();

      write(out);

      // Fill remaining bytes with invalid.
      while (bytesLeft > 0) {
         writeValue(out, null);
         bytesLeft -= Fit.baseTypeSizes[type & Fit.BASE_TYPE_NUM_MASK];
      }
   }

   protected void write(OutputStream out) {
      for (Object value : values) {
         writeValue(out, value);
      }
   }

   private void writeValue(OutputStream out, Object value) {
      try {
         DataOutputStream data = new DataOutputStream(out);

         if (value == null) {
            switch (type) {
               case Fit.BASE_TYPE_ENUM:
                  data.writeByte(Fit.ENUM_INVALID);
                  break;
               case Fit.BASE_TYPE_UINT8:
                  data.writeByte(Fit.UINT8_INVALID);
                  break;
               case Fit.BASE_TYPE_UINT8Z:
                  data.writeByte(Fit.UINT8Z_INVALID);
                  break;
               case Fit.BASE_TYPE_SINT8:
                  data.writeByte(Fit.SINT8_INVALID);
                  break;
               case Fit.BASE_TYPE_BYTE:
                  data.writeByte(Fit.BYTE_INVALID);
                  break;
               case Fit.BASE_TYPE_SINT16:
                  data.writeShort(Fit.SINT16_INVALID);
                  break;
               case Fit.BASE_TYPE_UINT16:
                  data.writeShort(Fit.UINT16_INVALID);
                  break;
               case Fit.BASE_TYPE_UINT16Z:
                  data.writeShort(Fit.UINT16Z_INVALID);
                  break;
               case Fit.BASE_TYPE_SINT32:
                  data.writeInt(Fit.SINT32_INVALID);
                  break;
               case Fit.BASE_TYPE_UINT32:
                  data.writeInt((int)Fit.UINT32_INVALID.longValue());
                  break;
               case Fit.BASE_TYPE_UINT32Z:
                  data.writeInt((int)Fit.UINT32Z_INVALID.longValue());
                  break;
               case Fit.BASE_TYPE_STRING:
                  data.writeByte(0);
                  break;
               case Fit.BASE_TYPE_FLOAT32:
                  data.writeFloat(Fit.FLOAT32_INVALID);
                  break;
               case Fit.BASE_TYPE_FLOAT64:
                  data.writeDouble(Fit.FLOAT64_INVALID);
                  break;
               default:
                  break;
            }
         } else { // if (value != null)
            switch (type) {
               case Fit.BASE_TYPE_ENUM:
               case Fit.BASE_TYPE_UINT8:
               case Fit.BASE_TYPE_UINT8Z:
               case Fit.BASE_TYPE_SINT8:
               case Fit.BASE_TYPE_BYTE: {
                  if (value instanceof String)
                     System.err.printf("Field.write(): Field %s value should not be string value %s\n", name, value);
                  data.writeByte((int)Math.round(((Number) value).doubleValue()));
                  break;
               }

               case Fit.BASE_TYPE_SINT16:
               case Fit.BASE_TYPE_UINT16:
               case Fit.BASE_TYPE_UINT16Z: {
                  data.writeShort((int)Math.round(((Number) value).doubleValue()));
                  break;
               }

               case Fit.BASE_TYPE_SINT32:
               case Fit.BASE_TYPE_UINT32:
               case Fit.BASE_TYPE_UINT32Z: {
                  data.writeInt((int)Math.round(((Number) value).doubleValue()));
                  break;
               }

               case Fit.BASE_TYPE_STRING: {
                  OutputStreamWriter stringWriter = new OutputStreamWriter(out, "UTF-8");
                  stringWriter.write(value.toString());
                  stringWriter.flush();
                  out.write(0);
                  break;
               }

               case Fit.BASE_TYPE_FLOAT32: {
                  data.writeFloat(((Number) value).floatValue());
                  break;
               }

               case Fit.BASE_TYPE_FLOAT64: {
                  data.writeDouble(((Number) value).doubleValue());
                  break;
               }

               default:
                  break;
            }
         } // if (value != null)
      } catch (java.io.IOException e) {
      }
   }
}