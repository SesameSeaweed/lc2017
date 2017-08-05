package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals56 {
    private static class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }

    public static List<Interval> merge(List<Interval> intervals) {
       intervals.sort((t1, t2) -> Integer.compare(t1.start, t2.start));
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        List<Interval> out = new ArrayList<>();

        for(Interval i : intervals) {
            if(i.start > end) {
                out.add(new Interval(start, end));
                start = i.start;
                end = i.end;
            }else {
                end = Math.max(i.end, end);
            }
        }
        out.add(new Interval(start, end));
        return out;
    }

    public static void main(String[] args) {
        Interval i1 = new Interval(1,3);
        Interval i2 = new Interval(2,6);
        Interval i3 = new Interval(8,10);
        Interval i4 = new Interval(15,18);

        List<Interval> intervals = Arrays.asList(i1, i2, i3, i4);
        List<Interval> out = merge(intervals);
        for(Interval i : out) {
            System.out.println("(" + i.start + ", " + i.end + ")");
        }
    }
}
