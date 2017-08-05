import java.util.Arrays;

public class MoveZero283 {
    public static void moveZeroes(int[] nums) {
        for(int i = 0; i < nums.length; i++ ) {
            if(nums[i] != 0) continue;

            for(int j = i+1; j < nums.length; j++) {
                while(j < nums.length && nums[j] == 0) j++;
                if(j == nums.length) return;
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,1,0,0,0,3,2};
        moveZeroes(nums);
        System.out.print(Arrays.toString(nums));
    }
}
