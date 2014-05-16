package ch.chwassme.fitalizer;

import com.garmin.fit.DateTime;
import com.garmin.fit.RecordMesg;
import com.google.common.base.Objects;

public class RecordData implements Comparable<RecordData> {

  public static RecordData createFrom(RecordMesg msg) {
	if (msg.getDistance() == null || msg.getAltitude() == null) {
	  return null;
	}
	return new RecordData(msg);
  }

  private final RecordMesg data;

  private RecordData(RecordMesg msg) {
	this.data = msg;
  }

  public Double getDistance() {
	return toDouble(data.getDistance());
  }

  public Double getAltitude() {
	return toDouble(data.getAltitude());
  }

  public DateTime getDateTime() {
	return data.getTimestamp();
  }

  public Integer getTimestamp() {
	return toInteger(getDateTime().getTimestamp());
  }

  public Integer getHeartrate() {
	return toInteger(data.getHeartRate());
  }

  public Double getSpeed() {
	return toDouble(data.getSpeed());
  }

  @Override
  public int compareTo(RecordData d) {
	return getTimestamp().compareTo(d.getTimestamp());
  }

  @Override
  public String toString() {
	return Objects.toStringHelper("data")
		.addValue(getTimestamp())
		.addValue(String.format("%10.3f", getDistance()))
		.addValue(String.format("%6.1f", getAltitude()))
		.addValue(String.format("%4.1f", getSpeed()))
		.addValue(String.format("%3d", getHeartrate()))
		.toString();
  }

  private Integer toInteger(Short s) {
	return s != null ? s.intValue() : null;
  }

  private Integer toInteger(Long l) {
	return l != null ? new Integer(l.intValue()) : null;
  }

  private Double toDouble(Float f) {
	return f != null ? new Double(f) : null;
  }

}
