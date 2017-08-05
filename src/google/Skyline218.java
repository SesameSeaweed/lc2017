package google;

import java.util.*;

public class Skyline218 {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> out = new ArrayList<>();
        List<int[]> height = new ArrayList<>();

        for(int[] b : buildings) {
            height.add(new int[] {b[0], -b[2]});
            height.add(new int[] {b[0], b[2]});
        }

        Collections.sort(height, new Comparator<int[]>() {
            @Override public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0]) return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(0, new Comparator<Integer>() {
            @Override public int compare(Integer i1, Integer i2) {
                return i2 - i1;
            }
        });

        pq.offer(0);
        int prev = 0;
        for(int[] hei : height) {
            if(hei[1] < 0) {
                pq.add(-hei[1]);
            }else {
                pq.remove(hei[1]);
            }
            int curr = pq.peek();
            if(prev != curr) {
                out.add(new int[] {hei[0], curr});
                prev = curr;
            }
        }
        return out;
    }

    public static void main(String[] args) {

    }
}
