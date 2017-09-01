
public class MaxProductSubarray152 {
    public static int maxProduct(int[] nums) {
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
            max = Math.max(max * nums[i], nums[i]);
            min = Math.min(min * nums[i], nums[i]);
            out = Math.max(max, out);
        }
        return out;
    }

   public static void main(String[] args) {
       int[] nums = {-2,-1,-9,-6};
       System.out.print(maxProduct(nums));
   }
}
