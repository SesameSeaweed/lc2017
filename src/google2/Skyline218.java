package google2;

import java.util.*;

public class Skyline218 {
    public static List<int[]> getSkyline(int[][] buildings) {
        List<int[]> out = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        for(int[] build : buildings) {
            int[] h1 = {build[0], -build[2]};
            int[] h2 = {build[1], build[2]};
            height.add(h1);
            height.add(h2);
        }

        height.sort(new Comparator<int[]>() {
            @Override public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });

        Queue<Integer> pq = new PriorityQueue<>((a,b)->(b-a));
        pq.offer(0);

        int prev = 0;
        for(int[] h : height) {
            if(h[1] < 0) {
                pq.offer(-h[1]);
            }else {
                pq.remove(h[1]);
            }
            int curr = pq.peek();
            if(prev != curr) {
                out.add(new int[]{h[0], curr});
                prev = curr;
            }
        }
        return out;
    }

    public static void main(String[] args) {
        int[][] buildings = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
        List<int[]> out = getSkyline(buildings);
        out.stream().map(a->Arrays.toString(a));
    }
}
