package jiuzhang;

public class MaxProductSubarray {
    public static int maxProduct(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0) return 0;

        int max = nums[0];
        int min = nums[0];
        int out = nums[0];

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] < 0) {
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(nums[i] * max, nums[i]);
            min = Math.min(nums[i] * min, nums[i]);
            out = Math.max(out, max);
        }
        return out;
    }

    public static void main(String[] args) {

    }
}
