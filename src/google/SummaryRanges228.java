package google;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges228 {
    public static List<String> summaryRanges(int[] nums) {
        List<String> out = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(nums[i]);
            int j = i;
            while (i < nums.length - 1 && nums[i] + 1 == nums[i+1]) {
                i++;
            }
            if(i < nums.length && j < i) {
                sb.append("->").append(nums[i]);
                out.add(sb.toString());
            }else {
                out.add(sb.toString());
            }
        }
        return out;
    }

    public static void main(String[] args) {
        int[] nums = {0};
        List<String> out = summaryRanges(nums);
        System.out.println(out);
    }
}
