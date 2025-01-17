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

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import com.garmin.fit.Decode.RETURN;

public class FileUtil {

   static public Collection<byte[]> split(InputStream input) {
      Collection<byte[]> files = new ArrayList<byte[]>();

      try {
         byte[] data = new byte[input.available()];
         int pos = 0;
         byte fileHdrSize;
         int fileDataSize;
         int fileSize;
         
         input.read(data);
         
         while (pos < data.length) {
            fileHdrSize = data[pos];
            fileDataSize = data[pos + 4] & 0xFF;
            fileDataSize |= (int) (data[pos + 5] & 0xFF) << 8;
            fileDataSize |= (int) (data[pos + 6] & 0xFF) << 16;
            fileDataSize |= (int) (data[pos + 7] & 0xFF) << 24;
            
            if (data[pos + 8] != '.')
               break;
            if (data[pos + 9] != 'F')
               break;
            if (data[pos + 10] != 'I')
               break;
            if (data[pos + 11] != 'T')
               break;
   
            fileSize = fileHdrSize + fileDataSize + 2;
            
            if ((pos + fileSize) > data.length)
               break;
            
            files.add(Arrays.copyOfRange(data, pos, pos + fileSize));
            pos += fileSize;
         }
         
         if (pos < data.length)
            files.add(Arrays.copyOfRange(data, pos, data.length));
      } catch (IOException e) {
      }

      return files;
   }

   static public Collection<byte[]> prepend(Collection<byte[]> files, File fromFileType,
         File toFileType) {
      Collection<byte[]> fromFiles = new ArrayList<byte[]>();
      Collection<byte[]> toFiles = new ArrayList<byte[]>();
      Collection<byte[]> returnFiles = new ArrayList<byte[]>();

      // Read each file to get list of files to prepend.
      for (byte[] file : files) {
         Decode decode = new Decode();
         Decode.RETURN decodeReturn = RETURN.CONTINUE;
         boolean decodeComplete = false;
         int datum;
         ByteArrayInputStream fileStream = new ByteArrayInputStream(file);

            while (!decodeComplete) {
               datum = fileStream.read();
               
               if (datum < 0) {
                  System.out.println("end of stream");
                  break; // Unexpected end of stream.
               }
               
               decodeReturn = decode.read((byte) datum);

               switch (decodeReturn) {
                  case MESG:
                     Mesg mesg = decode.getMesg();
                     
                     if (mesg.name.equals("file_id")) {
                        FileIdMesg fileIdMesg = new FileIdMesg(mesg);

                        if (fileIdMesg.getType().equals(fromFileType))
                           fromFiles.add(file);
   
                        if (fileIdMesg.getType().equals(toFileType))
                           toFiles.add(file);
                        
                        decodeComplete = true;
                     }
                     break; 

                  case END_OF_FILE:
                     decodeComplete = true;
                     break;
                     
                  default:
                     break;
               }
            }
      }

      // Create list of prepended files.
      for (byte[] file : files) {
         if (toFiles.contains(file)) {
            byte[] newFile;
            int newFileLength = file.length;
            int newFilePos = 0;
            
            for (byte[] fromFile : fromFiles) {
               newFileLength += fromFile.length;
            }

            newFile = new byte[newFileLength];
            
            for (byte[] fromFile : fromFiles) {
               System.arraycopy(fromFile, 0, newFile, newFilePos, fromFile.length);
               newFilePos += fromFile.length;
            }
            
            System.arraycopy(file, 0, newFile, newFilePos, file.length);

            returnFiles.add(newFile);
         } else {
            returnFiles.add(file); // No files to prepend so pass straight through.
         }
      }
      
      return returnFiles;
   }
}
