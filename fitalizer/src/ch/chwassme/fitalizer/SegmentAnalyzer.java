package ch.chwassme.fitalizer;

import java.util.Collection;
import java.util.DoubleSummaryStatistics;
import java.util.function.DoubleConsumer;

import org.apache.commons.math3.stat.Frequency;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

public class SegmentAnalyzer {

  public void analyze(Collection<Segment> segments) {
	DoubleSummaryStatistics length = segments.stream().mapToDouble(s -> s.getLength()).summaryStatistics();
	DoubleSummaryStatistics height = segments.stream().mapToDouble(s -> s.getHeight()).summaryStatistics();
	System.out.println(length);
	System.out.println(height);
	Frequency frequency = new Frequency();
	DescriptiveStatistics stats = new DescriptiveStatistics(DescriptiveStatistics.INFINITE_WINDOW);
	segments.stream().mapToDouble(s -> s.getGrade() * 100).forEach(new DoubleConsumer() {

	  @Override
	  public void accept(double gradePercent) {
		frequency.addValue(Math.round(gradePercent));
		stats.addValue(gradePercent);
	  }
	});
	System.out.println(frequency);
	System.out.println(stats);
  }
}
