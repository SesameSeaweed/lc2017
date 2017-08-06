import java.util.Arrays;

public class ProductOfArray238 {
    public static int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int[] out = new int[nums.length];
        int leftCurrent = 1;
        int rightCurrent = 1;
        left[0] = 1;
        right[nums.length-1] = 1;

        for(int i = 1; i < nums.length; i++) {
            left[i] = leftCurrent * nums[i-1];
            leftCurrent = left[i];
        }

        for(int i = nums.length - 2; i >= 0; i--) {
            right[i] = rightCurrent * nums[i+1];
            rightCurrent = right[i];
        }

        for (int i = 0; i < nums.length; i++) {
            out[i] = left[i] * right[i];
        }
        return out;

    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] out = productExceptSelf(nums);
        System.out.print(Arrays.toString(out));
    }
}
