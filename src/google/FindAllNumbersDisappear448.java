package google;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappear448 {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> out = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if((nums[i] >= 1) && nums[nums[i] - 1] > 0) {
                nums[nums[i] - 1] = nums[nums[i] - 1] * (-1);
            }
            if(nums[i] < 0) {
                nums[nums[i] * (-1) - 1] =  nums[nums[i] * (-1) - 1]  < 0 ? nums[nums[i] * (-1) - 1] : nums[nums[i] * (-1) - 1] * (-1);
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                out.add(i+1);
            }
        }
        return out;
    }
    public static void main(String[] args) {
        int[] nums = {1,1};
        List<Integer> out = findDisappearedNumbers(nums);
        System.out.print(out);
    }
}
