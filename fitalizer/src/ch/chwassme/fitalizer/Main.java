package ch.chwassme.fitalizer;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import com.garmin.fit.RecordMesg;
import com.garmin.fit.RecordMesgListener;

public class Main {

  private static class Listener implements RecordMesgListener {

	@Override
	public void onMesg(RecordMesg mesg) {
	}

  }

  public static void main(String[] args) {
	String filename;
	filename = "data/calpe_koenig.fit";
	filename = "data/m312.fit";
	BufferedInputStream bis = null;
	try {
	  bis = new BufferedInputStream(new FileInputStream(filename));
	  FitRecordData data = FitRecordData.read(bis);
	  new SegmentAnalyzer().analyze(data.segments(50f));
	} catch (Exception e) {
	  e.printStackTrace();
	  System.err.println(e);
	} finally {
	  try {
		if (bis != null) {
		  bis.close();
		}
	  } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	  }
	}
  }

  // public static void main(String[] args) {
  //
  // Decode decode = new Decode();
  // MesgBroadcaster mesgBroadcaster = new MesgBroadcaster(decode);
  // Listener listener = new Listener();
  // String filename = "data/test.fit";
  //
  // FileInputStream in;
  // try {
  // in = new FileInputStream(filename);
  // } catch (java.io.IOException e) {
  // throw new RuntimeException("Error opening file " + filename + " [1]");
  // }
  //
  // try {
  // if (!Decode.checkIntegrity((InputStream) in))
  // throw new RuntimeException("FIT file integrity failed.");
  // } finally {
  // try {
  // in.close();
  // } catch (java.io.IOException e) {
  // throw new RuntimeException(e);
  // }
  // }
  //
  // try {
  // in = new FileInputStream(filename);
  // } catch (java.io.IOException e) {
  // throw new RuntimeException("Error opening file " + filename + " [2]");
  // }
  //
  // mesgBroadcaster.addListener((RecordMesgListener) listener);
  //
  // try {
  // mesgBroadcaster.run(in);
  // } catch (FitRuntimeException e) {
  // System.err.print("Exception decoding file: ");
  // System.err.println(e.getMessage());
  //
  // try {
  // in.close();
  // } catch (java.io.IOException f) {
  // throw new RuntimeException(f);
  // }
  //
  // return;
  // }
  //
  // try {
  // in.close();
  // } catch (java.io.IOException e) {
  // throw new RuntimeException(e);
  // }
  //
  // System.out.println("Decoded FIT file " + filename + ".");
  // }

}
