package jiuzhang;

import java.util.*;

public class PlanesInSky {

    private static class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private static class Point implements Comparable<Point> {
        int val;
        int flag;

        Point(int val, int flag) {
            this.val = val;
            this.flag = flag;
        }

        @Override
        public int compareTo(Point p1) {
            if(p1.val == this.val) return this.flag - p1.flag;
            return this.val - p1.val;
        }
    }
    public static int countOfAirplanes(List<Interval> airplanes) {
        // write your code here
        if(airplanes== null || airplanes.size() == 0) return 0;
        List<Point> list = new ArrayList<>();

        for(Interval i : airplanes) {
            list.add(new Point(i.start, 1));
            list.add(new Point(i.end, 0));
        }

        Collections.sort(list);

        int count = 0;
        int max = 0;
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i).flag == 1) {
                count++;
            }else count--;
            max = Math.max(max, count);
        }
        return max;
    }

    public static void main(String[] args) {
        Interval i1 = new Interval(1,10);
        Interval i2 = new Interval(2,3);
        Interval i3 = new Interval(5,8);
        Interval i4 = new Interval(4,7);
        List<Interval> airplanes = Arrays.asList(i1, i2, i3, i4);
        System.out.print(countOfAirplanes(airplanes));
    }
}
