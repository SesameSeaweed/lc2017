import java.util.Arrays;

public class ThreeSumCloset16 {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int nearest = Integer.MAX_VALUE;
        int out = 0;
        for(int i = 0; i < nums.length-2; i++) {
            int start = i+1;
            int end = nums.length - 1;

            while(start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if(sum == target) return target;
                if(sum < target) {
                    start++;
                }else {
                    end--;
                }
                nearest = Math.min(nearest, Math.abs(target - sum));
                if(nearest == Math.abs(target - sum)) out=sum;
            }
        }
        return out;
    }

    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        System.out.print(threeSumClosest(nums, 1));
    }
}
