package ch.chwassme.fitalizer;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;

public class Main12 {


  public static void main(String[] args) {

//    String filename = "fitalizer/data/12h Challenge Zwift 1.fit";
//    String filename = "fitalizer/data/12h Challenge Zwift 2.fit";
//    String filename = "fitalizer/data/12hfixed1.fit";
    String filename = "fitalizer/data/teide.fit";
//    String filename = "fitalizer/data/12hfixed2.fit";
//    String filename = "fitalizer/data/partial.fit";
//    String filename = "fitalizer/data/complete.fit";
    BufferedInputStream bis = null;
    try {
      bis = new BufferedInputStream(new FileInputStream(filename));
      FitRecordData data = FitRecordData.read(bis);
      print(data.getData());
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if (bis != null) {
          bis.close();
        }
      } catch (IOException ignore) {
      }
    }
  }

  private static void print(Collection<RecordData> data) {
    for (RecordData datum : data) {
      System.out.println(datum.getAltitude());
    }
  }

//  private static void print(Collection<? extends Object> data) {
//    data.forEach(Main12::print);
//  }

//  private static void print(Object o) {
//  }
}
