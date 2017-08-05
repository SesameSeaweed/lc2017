public class MinimumMove453 {
    public static int minMoves(int[] nums) {
        int sum = 0;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < min) min = nums[i];
            sum += nums[i];
        }

        return sum - nums.length * min;
    }

    public static void main(String[] args) {
        int[] nums = {1,Integer.MAX_VALUE};
        System.out.print(minMoves(nums));
    }
}
