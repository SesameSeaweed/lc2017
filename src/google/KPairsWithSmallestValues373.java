package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class KPairsWithSmallestValues373 {
    public static List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> out = new ArrayList<>();
        if(nums1.length==0 || nums2.length==0 || k==0) return out;
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((a,b) -> (a[0] + a[1] - b[0] - b[1]));

        for(int i = 0; i < nums1.length; i++) {
            queue.add(new int[] {nums1[i], nums2[0], 0});
        }

        while(!queue.isEmpty() && k-- > 0) {
            int[] cur = queue.poll();
            out.add(new int[] {cur[0], cur[1]});
            if(cur[2] == nums2.length - 1) continue;
            queue.add(new int[] {cur[0], nums2[cur[2]+1], cur[2] + 1});
        }
        return out;
    }

    public static void main(String[] args) {
        int[] nums1 = {-10,-4,0,0,6};
        int[] nums2 = {3,5,6,7,8,100};
        List<int[]> out = kSmallestPairs(nums1, nums2, 10);
        for(int[] it : out) {
            System.out.print(Arrays.toString(it));
        }
    }
}
