import java.util.ArrayList;
import java.util.List;

public class Subset78 {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> out = new ArrayList<>();
        out.add(new ArrayList<>());

        helper(nums, 0, new ArrayList<>(), out);


        return out;
    }

    private static void helper(int[] nums, int index, List<Integer> path, List<List<Integer>> out) {

        for(int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            if(!out.contains(path)) out.add(new ArrayList<>(path));
            helper(nums, i+1, path, out);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> out = subsets(nums);
        System.out.print(out);
    }
}
