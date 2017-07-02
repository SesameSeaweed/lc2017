import java.util.Arrays;

public class NextPermutation31 {
    public static void nextPermutation(int[] nums) {
        if(nums == null || nums.length < 2) return;

        int length = nums.length;
        int first = length - 2;
        int second = length - 1;

        while(first >= 0) {
            if(nums[first] < nums[second]) break;
            first--;
            second--;
        }

        int j = length - 1;
        for(; j >=0 && first >= 0 ; j--) {
            int temp = nums[first];
            if(temp < nums[j]) {
                nums[first] = nums[j];
                nums[j] = temp;
                break;
            }
        }

        Arrays.sort(nums, second, length);

        return;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        nextPermutation(nums);
    }
}
