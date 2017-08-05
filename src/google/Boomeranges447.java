package google;

import java.util.HashMap;
import java.util.Map;

public class Boomeranges447 {
    public static int numberOfBoomerangs(int[][] points) {
        Map<Integer, Integer> map = new HashMap<>();
        int out = 0;

        for(int i = 0; i < points.length; i++) {
            for(int j = 0; j < points.length; j++) {
                if(i == j) continue;

                int d = getDistance(points[i], points[j]);
                map.put(d, map.getOrDefault(d, 0)+1);
            }
            for(int val : map.values()) {
                out += val * (val - 1);
            }
            map.clear();
        }
        return out;
    }

    private static int getDistance(int[] pointX, int[] pointY) {
        return (pointY[1] - pointX[1])*(pointY[1] - pointX[1]) + (pointY[0] - pointX[0]) * (pointY[0] - pointX[0]);
    }

    public static void main(String[] args) {
        int[][] points = {{1,0},{0,0}, {2,0}};
        System.out.print(numberOfBoomerangs(points));
    }
}
