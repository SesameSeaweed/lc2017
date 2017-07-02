import java.util.Arrays;
import java.util.Comparator;

public class NonOverlapIntervals435 {
    private static class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }
    public static int eraseOverlapIntervals(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override public int compare(Interval o1, Interval o2) {
                if (o1.end == o2.end) return o2.start - o1.start;
                return o1.end - o2.end;
            }
        });

        int end = intervals[0].end;
        int count = 0;
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i].start >= end) {
                end = intervals[i].end;
            }else count++;
        }
        return count;
    }

    public  static void main(String[] args) {
        Interval i1 = new Interval(1,100);
        Interval i2 = new Interval(11,22);
        Interval i3 = new Interval(1,11);
        Interval i4 = new Interval(2,12);
        Interval[] intervals = {i1, i2, i3, i4};
        System.out.println(eraseOverlapIntervals(intervals));

    }
}
