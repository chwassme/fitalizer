package ch.chwassme.fitalizer;

import com.google.common.base.Objects;

public class Segment {

  private static final float DEFAULT_THRESHOLD = 100f;

  public static Segment create(RecordData start) {
	return new Segment(start);
  }

  public static Segment createFromAdjacent(Segment segment) {
	if (!segment.isFinished()) {
	  throw new IllegalStateException("segment must be finished");
	}
	return create(segment.end);
  }

  private final RecordData start;
  private RecordData end;

  private Segment(RecordData start) {
	if (start.getDistance() == null) {
	  throw new IllegalArgumentException("distance may not be null");
	}
	this.start = start;
  }

  public boolean finishedBy(RecordData data) {
	return finishedBy(data, DEFAULT_THRESHOLD);
  }

  public boolean finishedBy(RecordData data, Float threshold) {
	assert (data.getDistance() > start.getDistance());
	if (threshold == null) {
	  threshold = DEFAULT_THRESHOLD;
	}
	float distance = data.getDistance() - start.getDistance();
	return (distance > threshold);
  }

  public boolean isFinished() {
	return end != null;
  }

  public void finish(RecordData end) {
	if (isFinished()) {
	  throw new IllegalStateException("Segment is already finished");
	}
	this.end = end;
  }

  public double getDistance() {
	if (!isFinished()) {
	  throw new IllegalStateException("segment must be finished");
	}
	return end.getDistance() - start.getDistance();
  }

  public double getGrade() {
	if (!isFinished()) {
	  return Double.NaN;
	}
	if (getHorizontalDistance() == 0.) {
	  return 0.;
	}
	return getHeight() / getHorizontalDistance();
  }

  private double getHorizontalDistance() {
	return Math.pow(Math.pow(getDistance(), 2) - Math.pow(getHeight(), 2), 0.5);
  }

  public double getHeight() {
	double startAltitude = start.getAltitude();
	double endAltitude = end.getAltitude();
	return endAltitude - startAltitude;
  }

  @Override
  public String toString() {
	return Objects.toStringHelper(this).addValue(start).addValue(end).addValue(getDistance()).addValue(getHeight())
		.addValue(String.format("%.1f%%", getGrade() * 100.)).toString();
  }

}
