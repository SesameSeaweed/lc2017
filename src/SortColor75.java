import java.util.Arrays;

public class SortColor75 {
    public static void sortColors(int[] nums) {
        int zero = 0;
        int one = 0;

        for(int i = 0; i < nums.length; i++) {
           if(nums[i] == 0) zero++;
            if(nums[i] == 1) one++;
        }

        for(int i = 0; i < zero; i++) {
            nums[i] = 0;
        }
        for(int i = zero; i < zero+one; i++) {
            nums[i] = 1;
        }
        for(int i = zero+one; i < nums.length; i++) {
            nums[i] = 2;
        }

        System.out.print(Arrays.toString(nums));
    }


    public static void main(String[] args) {
        int[] nums = {0,0,1,2,1,1,0,2,2};
        sortColors(nums);
    }
}
