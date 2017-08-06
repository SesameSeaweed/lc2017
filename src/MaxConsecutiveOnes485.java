public class MaxConsecutiveOnes485 {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int currMax = 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                currMax++;
                max = Math.max(currMax, max);
            }else {
                max = Math.max(currMax, max);
                currMax = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1};
        System.out.print(findMaxConsecutiveOnes(nums));
    }
}
