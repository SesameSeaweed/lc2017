import java.util.ArrayList;
import java.util.List;

public class CombinationSum39 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> out = new ArrayList<>();
        for(int i = 0; i < candidates.length; i++) {
            List<Integer> path = new ArrayList<>();
            path.add(candidates[i]);
            helper(candidates, target - candidates[i], i, path, out);
        }
        return out;
    }

    private static void helper(int[] nums, int target, int index, List<Integer> path, List<List<Integer>> out ) {
        if(target == 0) {
            out.add(new ArrayList<>(path));
            return;
        }

        for(int i = index; i < nums.length; i++) {
            if(target >= nums[i]) {
                path.add(nums[i]);
                helper(nums, target - nums[i], i, path, out);
                path.remove(path.size() - 1);
            }
        }
        return;
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> out = combinationSum(candidates, target);
        out.forEach(System.out::println);

    }
}
