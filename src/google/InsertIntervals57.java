package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertIntervals57 {
    private static class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(intervals == null || intervals.isEmpty()) return Arrays.asList(newInterval);
        intervals.sort((a,b)->(a.start - b.start == 0 ? a.end-b.end : a.start - b.start));
        List<Interval> out = new ArrayList<>();
        boolean added = false;
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        if(newInterval.end < start) {
            out.add(newInterval);
        }
        for(int i = 0; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);
            start = intervals.get(i).start;
            end = intervals.get(i).end;
            if(curr.end < newInterval.start) {
                out.add(curr);
            } else {
                if(curr.start > newInterval.end) {
                    if(!added) {
                        out.add(newInterval);
                        added = true;
                    }
                    out.add(curr);
                } else {
                    while(i < intervals.size() - 1 && newInterval.end >= intervals.get(i+1).start) {
                        i++;
                        curr = intervals.get(i);
                    }
                    end = Math.max(curr.end, newInterval.end);
                    out.add(new Interval(Math.min(start, newInterval.start) ,end));
                    added = true;
                }
            }
        }
        if(out.get(out.size() - 1).end < newInterval.start) out.add(newInterval);
        return out;
    }

    public static void main(String[] args) {
//        Interval v1 = new Interval(1,3);
//        Interval v2 = new Interval(6, 9);
//        Interval newInterval = new Interval(2,5);
//        List<Interval> intervals = Arrays.asList(v1, v2);

        Interval v1 = new Interval(1,2);
        Interval v2 = new Interval(3,5);
        Interval v3 = new Interval(6,7);
        Interval v4 = new Interval(8,10);
        Interval v5 = new Interval(12, 16);
        Interval v6 = new Interval(4,9);

        List<Interval> intervals = Arrays.asList(v1, v2, v3, v4, v5);

//        Interval v1 = new Interval(3,5);
//        Interval v2 = new Interval(12,15);
//        Interval newInterval = new Interval(6,6);
//        List<Interval> intervals = Arrays.asList(v1,v2);
        List<Interval> out = insert(intervals, v6);
        for(Interval i : out) {
            System.out.println("(" + i.start + ", " + i.end+ ")");
        }
    }

}
