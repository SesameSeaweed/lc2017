import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParentheses301 {
    public static List<String> removeInvalidParentheses(String s) {
        List<String> out = new ArrayList<>();
        helper(s, 0, 0, out, new char[] {'(', ')'});
        return out;
    }

    private static void helper(String s, int lastCheck, int lastRemoval, List<String> out, char[] pa) {
        int  value = 0;
        for(int i = lastCheck+1; i < s.length(); i++) {

            if(s.charAt(i) == pa[0]) value++;
            if(s.charAt(i) == pa[1]) value--;

            if(value >= 0) continue;

            for(int j = lastRemoval; j <= i; j++) {
                if(s.charAt(j) == pa[1] && (j == lastRemoval || s.charAt(j-1) != pa[1])) {
                    helper(s.substring(0, j)+s.substring(j+1, s.length()), i, j, out, new char[]{'(', ')'});
                }
            }
            return;
        }

        String reverse = new StringBuilder(s).reverse().toString();
        if(pa[0] == '(') {
            helper(reverse, 0, 0, out, new char[] {')', '('});
        }else {
            out.add(reverse);
        }
    }

    public static void main(String[] args) {
        List<String> out = removeInvalidParentheses("(())");
        System.out.println(out);
    }
}
