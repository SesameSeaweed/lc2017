import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum40 {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> out = new ArrayList<>();

        Arrays.sort(candidates);
        for(int i = 0; i < candidates.length; i++) {
            List<Integer> path = new ArrayList<>();
            path.add(candidates[i]);
            helper(candidates, path, target - candidates[i], i, out);
        }
        return out;
    }

    private static void helper(int[] candidates, List<Integer> path, int target, int index, List<List<Integer>> out) {
        if(target == 0) {
            if(!out.contains(path)) {
                out.add(new ArrayList<>(path));
            }
            return;
        }

        for(int i = index + 1; i < candidates.length; i++) {
            if(target >= candidates[i]) {
                path.add(candidates[i]);
                helper(candidates, path, target - candidates[i], i, out);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;

        List<List<Integer>> out = combinationSum2(candidates, target);
        out.forEach(System.out::println);
    }
}
