package google2;

import java.util.HashSet;
import java.util.Set;

public class PerfectRectangle391 {
    public static boolean isRectangleCover(int[][] rectangles) {
        if(rectangles == null || rectangles.length == 0) return false;

        int x1 = Integer.MAX_VALUE;
        int y1 = Integer.MAX_VALUE;
        int x2 = Integer.MIN_VALUE;
        int y2 = Integer.MIN_VALUE;
        int area = 0;

        Set<String> set = new HashSet<>();
        for(int[] rec  : rectangles) {
            x1 = Math.min(x1, rec[0]);
            x2 = Math.max(x2, rec[2]);
            y1 = Math.min(y1, rec[1]);
            y2 = Math.max(y2, rec[3]);

            area += (rec[2] - rec[0]) * (rec[3] - rec[1]);

            String sb1 = rec[0] + "-" + rec[1];
            String sb2 = rec[2] + "-" + rec[1];
            String sb3 = rec[2] + "-" + rec[3];
            String sb4 = rec[0] + "-" + rec[3];

            if(!set.add(sb1)) {
                set.remove(sb1);
            }
            if(!set.add(sb2)) {
                set.remove(sb2);
            }
            if(!set.add(sb3)) {
                set.remove(sb3);
            }
            if(!set.add(sb4)) {
                set.remove(sb4);
            }
        }

        String sb1 = x1 + "-" + y1;
        String sb2 = x2 + "-" + y1;
        String sb3 = x2 + "-" + y2;
        String sb4 = x1 + "-" + y2;

        if(set.size() != 4 || !set.contains(sb1) || !set.contains(sb2) || !set.contains(sb3)|| !set.contains(sb4)) return false;
        return area == (x2 - x1) * (y2 - y1);
    }

    public static void main(String[] args) {
        int[][] rectangles = {{1,1,3,3}, {3,1,4,2}, {3,2,4,4}, {1,3,2,4}, {2,3,3,4}};
        System.out.print(isRectangleCover(rectangles));
    }
}
