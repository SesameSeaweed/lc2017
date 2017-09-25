package jiuzhang;

import java.util.ArrayList;
import java.util.List;

public class LongestSub {
    public static int longestIncreasingSubsequence(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0) return 0;
        int max = 0;
        List<Integer> path = null;

        for(int i = 0; i < nums.length; i++) {
            path = new ArrayList<>();
            path.add(nums[i]);
            int count = 1;
            max = Math.max(max, helper(nums, i, path, count));
        }
        return max;
    }

    private static int helper(int[] nums, int index, List<Integer> path, int max) {
        for(int i = index+1; i < nums.length; i++) {
            if(nums[i] > nums[index]) {
                path.add(nums[i]);
                max = helper(nums, i, path, max);
                path.remove(path.size()-1);
            }
        }
        max =  Math.max(max, path.size());
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3,2,1};
        System.out.print(longestIncreasingSubsequence(nums));
    }
}
