package google;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxSlidingWindow239 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        int[] res = new int[nums.length+1-k];
        for(int i = 0; i < nums.length; i++) {
            if(i >= k) {
                queue.remove(nums[i-k]);
            }
            queue.offer(nums[i]);
            if(i + 1 >= k) {
                res[i + 1 - k] = queue.peek();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k  = 3;
        int[] out = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(out));
    }
}
