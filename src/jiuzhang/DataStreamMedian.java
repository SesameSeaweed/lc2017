package jiuzhang;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DataStreamMedian {
    /*
     * @param nums: A list of integers
     * @return: the median of numbers
     */
    public static int[] medianII(int[] nums) {
        // write your code here
        int[] out = new int[nums.length];

        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(1, new Comparator<Integer>() {
            @Override public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        maxHeap.add(nums[0]);
        out[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            int x = maxHeap.peek();
            if(nums[i] > x) {
                minHeap.add(nums[i]);
            }else {
                maxHeap.add(nums[i]);
            }

            if(maxHeap.size() > minHeap.size()+1) {
                minHeap.add(maxHeap.poll());
            } else if(maxHeap.size() < minHeap.size()) {
                maxHeap.add(minHeap.poll());
            }
            out[i] = maxHeap.peek();
        }
        return out;
    }


    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int[] out = medianII(nums);
        System.out.print(Arrays.toString(out));
    }

}
