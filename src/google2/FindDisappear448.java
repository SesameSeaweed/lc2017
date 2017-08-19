package google2;

import java.util.ArrayList;
import java.util.List;

public class FindDisappear448 {
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> out = new ArrayList<>();
        int n = nums.length;
        for(int i= 0; i < n; i++ ) {
            nums[(nums[i]-1)%n] += n;
        }
        for(int i = 0; i < n; i++) {
            if(nums[i] <= n) {
                out.add(i+1);
            }
        }
        return out;
    }
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> out = findDisappearedNumbers(nums);
        System.out.print(out);
    }
}
