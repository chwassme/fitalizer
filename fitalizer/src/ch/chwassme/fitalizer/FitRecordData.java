package ch.chwassme.fitalizer;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.SortedSet;
import java.util.TreeSet;

import com.garmin.fit.Decode;
import com.garmin.fit.MesgBroadcaster;
import com.garmin.fit.RecordMesg;
import com.garmin.fit.RecordMesgListener;

public class FitRecordData {

  public static FitRecordData read(InputStream in) {
	MesgBroadcaster mesgBroadcaster = new MesgBroadcaster(new Decode());

	final FitRecordData data = new FitRecordData();
	mesgBroadcaster.addListener(new RecordMesgListener() {

	  @Override
	  public void onMesg(RecordMesg mesg) {
		data.addData(mesg);
	  }
	});
	mesgBroadcaster.run(in);
	return data;
  }

  private final SortedSet<RecordData> data;

  private FitRecordData() {
	data = new TreeSet<RecordData>();
  }

  public void addData(RecordMesg record) {
	RecordData recordData = RecordData.createFrom(record);
	if (recordData != null) {
	  data.add(recordData);
	}
  }

  public Collection<Segment> segments() {
	return segments((Integer) null);
  }

  public Collection<Segment> segments(Integer threshold) {
	Collection<Segment> segments = new ArrayList<Segment>();
	Segment segment = null;
	for (RecordData data : this.data) {
	  if (segment == null) {
		segment = Segment.create(data, threshold);
	  } else if (segment.finishedBy(data, threshold)) {
		segment.finish(data);
		segments.add(segment);
		segment = Segment.createFromAdjacent(segment);
	  }
	  // ignore open segments at the end
	}
	return segments;
  }

  public Collection<RecordData> getData() {
	return new ArrayList<RecordData>(this.data);
  }

}
