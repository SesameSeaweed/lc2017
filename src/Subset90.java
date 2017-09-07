import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset90 {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> out = new ArrayList<>();
        out.add(new ArrayList<>());

        for(int i = 0; i < nums.length; i++) {

            if(i >= 1 && nums[i-1] == nums[i]) continue;
            List<Integer> path = new ArrayList<>();
            path.add(nums[i]);
            out.add(new ArrayList<>(path));

            helper(nums, i, path, out);
        }
        return out;
    }

    private static void helper(int[] nums, int index, List<Integer> path, List<List<Integer>> out) {

        for(int i = index+1; i < nums.length; i++) {
            path.add(nums[i]);
            out.add(new ArrayList<>(path));
            helper(nums, i, path, out);
            path.remove(path.size() - 1);
            while(i+1 < nums.length && nums[i] == nums[i+1]) i++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2};
        List<List<Integer>> out = subsetsWithDup(nums);
        System.out.print(out);
    }
}
