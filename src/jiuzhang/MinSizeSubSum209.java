package jiuzhang;

public class MinSizeSubSum209 {
    public static int minSubArrayLen(int s, int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int i = nums.length - 1; i >= 0; i--) {
            int temp = s - nums[i];
            if(temp <= 0) return 1;

            for(int j = i-1; j >= 0; j--) {
                temp = temp - nums[j];
                if(temp <= 0) {
                    min = Math.min(i-j+1, min);
                    break;
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;


    }

    public static void main(String[] args) {
//        int[] nums = {2,3,1,2,4,3};
        int[] nums = {1,2,3,4,5};
//        int[] nums = {5,1,3,5,10,7,4,9,2,8};
        System.out.print(minSubArrayLen(15, nums));
    }
}
