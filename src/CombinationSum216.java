import java.util.ArrayList;
import java.util.List;

public class CombinationSum216 {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> out = new ArrayList<>();

        for(int i = 1; i <= 9; i++) {
            List<Integer> path = new ArrayList<>();
            path.add(i);
            helper(k - 1, n - i, i, out, path);
        }
        return out;
    }

    private static void helper(int k, int target, int index, List<List<Integer>> out, List<Integer> path) {
        if(target == 0 && k == 0) {
            out.add(new ArrayList<>(path));
            return;
        }

        for(int i = index+1; i <= 9 ;i++) {
            if(target >= i) {
                path.add(i);
                helper(k - 1, target - i, i, out, path);
                path.remove(path.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        int n = 9;
        int k = 3;
        List<List<Integer>> out = combinationSum3(k, n);
        out.forEach(System.out::println);
    }
}
