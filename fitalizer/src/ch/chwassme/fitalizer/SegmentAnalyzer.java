package ch.chwassme.fitalizer;

import java.util.Collection;
import java.util.DoubleSummaryStatistics;
import java.util.function.DoubleConsumer;

import org.apache.commons.math3.stat.Frequency;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class SegmentAnalyzer {

  public void analyze(Collection<Segment> segments) {
	DoubleSummaryStatistics distance = segments.stream().mapToDouble(s -> s.getDistance()).summaryStatistics();
	DoubleSummaryStatistics height = segments.stream().mapToDouble(s -> s.getHeight()).summaryStatistics();
	DoubleSummaryStatistics grade = segments.stream().mapToDouble(s -> s.getGrade()).summaryStatistics();
	System.out.println(distance);
	System.out.println(height);
	System.out.println(grade);
	final Frequency frequency = new Frequency();
	final DescriptiveStatistics stats = new DescriptiveStatistics(DescriptiveStatistics.INFINITE_WINDOW);
	segments.stream().mapToDouble(s -> s.getGrade() * 100).forEach(new DoubleConsumer() {

	  @Override
	  public void accept(double gradePercent) {
		frequency.addValue(Math.round(gradePercent));
		stats.addValue(gradePercent);
	  }
	});
	System.out.println(frequency);
	// System.out.println(stats);
  }
}