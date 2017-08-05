import java.util.Arrays;

public class MinimumMove462 {
    public static int minMoves2(int[] nums) {
        Arrays.sort(nums);
        long min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            long left = 0;
            long right = 0;
            for(int j=0; j < i; j++) {
                left += nums[j];
            }

            for(int k = i+1; k < nums.length; k++) {
                right += nums[k];
            }
            min = Math.min(min, (long) nums[i] * (long) (i * 2 - nums.length + 1) - left + right);
        }
        return (int) min;
    }

    public static void main(String[] args) {
        int[] nums = {203125577,-349566234,230332704,48321315,66379082,386516853,50986744,-250908656,-425653504,-212123143};
        System.out.println(minMoves2(nums));
    }
}
