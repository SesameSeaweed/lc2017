import java.util.ArrayList;
import java.util.List;

public class MajorityElement229 {
    public static List<Integer> majorityElement(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();
        List<Integer> out = new ArrayList<>();

        int count1 = 0;
        int count2 = 0;
        int candidate1 = Integer.MIN_VALUE;
        int candidate2 = Integer.MIN_VALUE;

        for(int num : nums) {
            if(num == candidate1) {
                count1++;
            }else {
                if(num == candidate2) {
                    count2++;
                }else {
                    if(count1 != 0 && count2 != 0) {
                        count1--;
                        count2--;
                    }else {
                        if(count1 == 0) {
                            candidate1 = num;
                            count1++;
                        }else{
                            candidate2 = num;
                            count2++;
                        }

                    }
                }
            }
        }

        count1 = 0;
        count2 = 0;

        for(int num : nums) {
            if(num == candidate1) count1++;
            if(num == candidate2) count2++;
        }

        if(count1 > nums.length/3) out.add(candidate1);
        if(count2 > nums.length/3 && candidate1 != candidate2 && candidate2 != Integer.MIN_VALUE) out.add(candidate2);
        return out;
    }

    public static void main(String[] args) {
        int[] nums = {1,2};
        List<Integer> out = majorityElement(nums);
        System.out.print(out);
    }
}
