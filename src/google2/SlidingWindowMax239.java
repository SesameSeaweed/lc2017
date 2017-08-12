package google2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class SlidingWindowMax239 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] out = new int[nums.length-k+1];
        Queue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        for(int i = 0; i < nums.length; i++) {
            pq.offer(nums[i]);
            if(i >= k-1) {
                out[i-k+1] = pq.peek();
                pq.remove(nums[i-k+1]);
            }
        }
        return out;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] out = maxSlidingWindow(nums,k);
        System.out.print(Arrays.toString(out));
    }
}
