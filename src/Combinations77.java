import java.util.ArrayList;
import java.util.List;

public class Combinations77 {
    public static List<List<Integer>> combine(int n, int k) {
        if(k > n) return new ArrayList<>();

        List<List<Integer>> out = new ArrayList<>();

        for(int i = 1; i <= n; i++) {
            List<Integer> path = new ArrayList<>();
            path.add(i);
            helper(n, k, i, path, out);
        }
        return out;
    }

    private static void helper(int n, int k, int index, List<Integer> path, List<List<Integer>> out) {
        if(path.size() == k) {
            out.add(new ArrayList<>(path));
            return;
        }

        for(int i = index+1; i <= n; i++) {
            path.add(i);
            helper(n, k, i, path, out);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> out = combine(4,2);
        System.out.print(out);
    }
}
