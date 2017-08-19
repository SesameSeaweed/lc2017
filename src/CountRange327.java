public class CountRange327 {
    public static int countRangeSum(int[] nums, int lower, int upper) {
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            long sum = nums[i];
            if(nums[i] >= lower && nums[i] <= upper) {
                sum = nums[i];
                count++;
            }
            count += helper(nums, lower, upper, i+1, sum);
        }
        return count;
    }

    public static int helper(int[] nums, int lower, int upper, int index, long sum) {
        int count = 0;
        for(int i = index; i < nums.length; i++) {
            sum += nums[i];
            if(sum >= lower && sum <= upper) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {-2147483647,0,-2147483647,2147483647};
        System.out.print(countRangeSum(nums, -564, 3864));
    }
}
