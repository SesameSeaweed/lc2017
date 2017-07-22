import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class SlidingWindowMax239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] out = new int[nums.length - k + 1];

        Queue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());


        for(int i = 0; i < nums.length; i++) {
           if(i >= k) {
               queue.remove(nums[i-k]);
           }
           queue.offer(nums[i]);
           if(i >= k - 1) {
               out[i - k +1] = queue.peek();
           }
        }
        return out;
    }
}
