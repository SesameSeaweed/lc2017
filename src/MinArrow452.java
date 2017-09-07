import java.util.Arrays;
import java.util.Comparator;

public class MinArrow452 {
    public static int findMinArrowShots(int[][] points) {
        if(points == null || points.length == 0) return 0;
        if(points.length == 1) return 1;

        Arrays.sort(points, new Comparator<int[]>() {
            @Override public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });

        int start = points[0][0];
        int end = points[0][1];
        int count = 1;

        for(int i = 1; i < points.length; i++) {
            if(points[i][0] > end) {
                count++;
                start = points[i][0];
                end = points[i][1];
            }else {
                end = Math.min(end, points[i][1]);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] points = {{10,16}, {2,8}, {7,12}, {1,6}};
        System.out.print(findMinArrowShots(points));
    }
}
