import java.util.ArrayList;
import java.util.List;


public class LongestIncreasingSub300 {
    public static int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        List<List<Integer>> out = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            List<Integer> path = new ArrayList<>();
            path.add(nums[i]);
            helper(nums, path, out, i);
        }

        int max = 0;

        for(List<Integer> item : out) {
            max = Math.max(item.size(), max);
        }
        return max;
    }

    private static void helper(int[] nums, List<Integer> path, List<List<Integer>> out, int index) {

        for(int i = index + 1; i < nums.length;i++) {
            if(i < nums.length && nums[i] > path.get(path.size() - 1)) {
                path.add(nums[i]);
                helper(nums, path, out, i);
                out.add(new ArrayList<Integer>(path));
                path.remove(path.size()-1);

            }
        }

    }

    public static void main(String[] args) {
//        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] nums = {2,2};
        System.out.print(lengthOfLIS(nums));
    }
}
