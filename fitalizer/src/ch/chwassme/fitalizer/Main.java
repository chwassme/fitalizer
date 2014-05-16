package ch.chwassme.fitalizer;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collection;

public class Main {

  public static void main(String[] args) {
	String filename;
	filename = "data/calpe_koenig.fit";
	filename = "data/m312.fit";
	filename = "data/flach_1s.fit";
	BufferedInputStream bis = null;
	try {
	  bis = new BufferedInputStream(new FileInputStream(filename));
	  FitRecordData data = FitRecordData.read(bis);
	  Collection<Segment> segments = data.segments(10);
	  new SegmentAnalyzer().analyze(segments);
	  print(data.getData());
	  print(segments);
	} catch (Exception e) {
	  e.printStackTrace();
	  System.err.println(e);
	} finally {
	  try {
		if (bis != null) {
		  bis.close();
		}
	  } catch (IOException ignore) {
	  }
	}
  }

  private static void print(Collection<? extends Object> data) {
	data.stream().forEachOrdered(d -> System.out.println(d.toString()));
  }

}
