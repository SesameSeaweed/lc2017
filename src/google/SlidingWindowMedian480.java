package google;

import java.util.*;

public class SlidingWindowMedian480 {

    public static double[] medianSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) return new double[0];
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        double[] out = new double[nums.length - k + 1];

        for(int i = 0; i < nums.length; i++) {
            if(i >= k) {
                queue.remove(nums[i-k]);
            }
            queue.add(nums[i]);
            if(i >= k - 1) {
                out[i-k+1] = findMedian(queue, k);
            }
        }
        return out;
    }

    private static double findMedian(Queue<Integer> queue, int k) {
        int[] nums = new int[k];
        int index = 0;
        for(Integer i : queue) {
            nums[index++] = i;
        }
        Arrays.sort(nums);
        if(k % 2 == 1) {
            return (double) nums[ k/ 2];

        }else {
            return ((double) nums[k / 2 ] + (double)nums[k / 2 -1])/2;
        }
    }

    public static void main(String[] args) {
//        int[] nums = {1,3,-1,-3,5,3,6,7};
//        int k = 3;
        int[] nums = {2147483647,2147483647};
        int k = 2;
        System.out.println(Arrays.toString(medianSlidingWindow(nums, k)));
    }
}
