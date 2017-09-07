import java.util.ArrayList;
import java.util.List;

public class PalindromePartition131 {
    public static List<List<String>> partition(String s) {
        if (s == null || s.length() == 0)
            return new ArrayList<>();

        List<List<String>> out = new ArrayList<>();
        List<List<String>>[] res = new List[s.length()+1];
        res[0] = new ArrayList<>();
        res[0].add(new ArrayList<>());

        boolean[][] isPal = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            res[i + 1] = new ArrayList<>();
            for (int left = 0; left <= i; left++) {
                if (s.charAt(left) == s.charAt(i) && (i-left <= 1 || isPal[left + 1][i - 1])) {
                    isPal[left][i] = true;
                    String str = s.substring(left, i + 1);
                    for (List<String> r : res[left]) {
                        List<String> ri = new ArrayList<>(r);
                        ri.add(str);
                        res[i + 1].add(ri);
                    }
                }
            }
        }
        return res[s.length()];
    }

    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> out = partition(s);
        System.out.println(out);
    }
}
