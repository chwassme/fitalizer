package ch.chwassme.fitalizer;

import com.garmin.fit.DateTime;
import com.garmin.fit.RecordMesg;
import com.google.common.base.Objects;

public class RecordData implements Comparable<RecordData> {

  private final RecordMesg data;

  public RecordData(RecordMesg msg) {
	this.data = msg;
  }

  public Float getDistance() {
	return data.getDistance();
  }

  public Float getAltitude() {
	return data.getAltitude();
  }

  public DateTime getDateTime() {
	return data.getTimestamp();
  }

  public Long getTimestamp() {
	return getDateTime().getTimestamp();
  }

  public int getHeartrate() {
	return data.getHeartRate();
  }

  @Override
  public int compareTo(RecordData d) {
	return getTimestamp().compareTo(d.getTimestamp());
  }

  @Override
  public String toString() {
	return Objects.toStringHelper(this).addValue(getDateTime()).addValue(getDistance()).addValue(getAltitude()).toString();
  }

}
