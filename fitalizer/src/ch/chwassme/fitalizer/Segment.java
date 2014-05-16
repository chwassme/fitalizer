package ch.chwassme.fitalizer;

import com.google.common.base.Objects;

public class Segment {

  private static final int DEFAULT_THRESHOLD = 100;

  public static Segment create(RecordData start, int threshold) {
	return new Segment(start, threshold);
  }

  public static Segment createFromAdjacent(Segment segment) {
	if (!segment.isFinished()) {
	  throw new IllegalStateException("segment must be finished");
	}
	return create(segment.end, segment.threshold);
  }

  private final RecordData start;
  private final int threshold;
  private RecordData end;

  private Segment(RecordData start, int threshold) {
	if (start.getDistance() == null || start.getAltitude() == null) {
	  throw new IllegalArgumentException("distance or altitude may not be null");
	}
	if (threshold <= 0) {
	  throw new IllegalArgumentException("threshold must be positive");
	}
	this.start = start;
	this.threshold = threshold;
  }

  public boolean finishedBy(RecordData data) {
	return finishedBy(data, DEFAULT_THRESHOLD);
  }

  public boolean finishedBy(RecordData data, Integer threshold) {
	assert (data.getDistance() >= start.getDistance());
	if (data.getDistance() == start.getDistance()) {
	  return false;
	}
	if (threshold == null) {
	  threshold = DEFAULT_THRESHOLD;
	}
	double distance = data.getDistance() - start.getDistance();
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

  public double getLength() {
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
	return Math.pow(Math.pow(getLength(), 2) - Math.pow(getHeight(), 2), 0.5);
  }

  public double getHeight() {
	double startAltitude = start.getAltitude();
	double endAltitude = end.getAltitude();
	return endAltitude - startAltitude;
  }

  @Override
  public String toString() {
	return Objects.toStringHelper(this)
		.addValue(start)
		.addValue(end)
		.addValue(threshold)
		.addValue(String.format("%5.1f", getLength()))
		.addValue(String.format("%4.1f", getHeight()))
		.addValue(String.format("%5.1f%%", getGrade() * 100.))
		.toString();
  }
}
