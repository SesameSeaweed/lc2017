package google;

import java.util.HashMap;
import java.util.Map;

public class LongestSequence128 {
    public static int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int max = 1;

        for(Integer num : nums) {
            if(!map.containsKey(num)) {
                int left = map.containsKey(num-1) ? map.get(num - 1) : 0;
                int right = map.containsKey(num+1) ? map.get(num + 1) : 0;

                int sum = left+1+right;
                max = Math.max(max, sum);
                map.put(num, sum);
                map.put(num - left, sum);
                map.put(num + right, sum);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.print(longestConsecutive(nums));
    }
}
