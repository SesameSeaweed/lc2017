package jiuzhang;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class SlidingWindowMaximum {
    public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        // write your code here
        ArrayList<Integer> out = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();

        for(int i = 0; i < k-1; i++) {
            inqueue(deque, nums[i]);
        }

        for(int i = k-1; i < nums.length; i++) {
                inqueue(deque, nums[i]);
                out.add(deque.peekFirst());
                outQueue(deque, nums[i-k+1]);
        }
        return out;
    }

    private void inqueue(Deque<Integer> queue, int num) {
        while (!queue.isEmpty() && queue.peekLast() < num) {
            queue.pollLast();
        }
        queue.offer(num);
    }

    private void outQueue(Deque<Integer> queue, int num) {
        if(queue.pollFirst() == num) {
            queue.pollFirst();
        }
    }
}
