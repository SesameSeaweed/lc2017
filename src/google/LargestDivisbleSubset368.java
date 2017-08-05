package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisbleSubset368 {
    public static List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> out = new ArrayList<>();
        Arrays.sort(nums);

        int[] dp = new int[nums.length];
        dp[0] = 1;

        for(int i = 1; i < nums.length; i++) {
            for(int j = i - 1; j >= 0; j--) {
                if(nums[i] % nums[j] == 0) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int maxIndex = 0;
        for(int i = 1; i < nums.length; i++) {
            maxIndex = dp[i] > dp[maxIndex] ? i : maxIndex;
        }

        int temp = nums[maxIndex];
        int index = dp[maxIndex];
        for(int i = maxIndex; i >= 0; i--) {
            if(temp % nums[i] == 0 && dp[i] == index) {
                out.add(nums[i]);
                temp = nums[i];
                index--;
            }
        }
        return out;
    }

    public static void main(String[] args) {
        int[] nums = {4,8,10,240};
        List<Integer> out = largestDivisibleSubset(nums);
        System.out.println(out);
    }
}
