package google;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParenthese22 {
    public static List<String> generateParenthesis(int n) {
        List<String> out = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        path.append("(");
        helper(out, path, n, 1, 0);
        return out;
    }

    private static void helper(List<String> out, StringBuilder path, int max, int left, int right) {
        if(path.length() == max * 2) {
            if(isvalid(path)) out.add(path.toString());
            return;
        }

       if(left < max) {
           helper(out, path.append("("), max, left+1, right);
           path.deleteCharAt(path.length()-1);
       }
       if(right < max) {
           helper(out, path.append(")"), max, left, right+1);
           path.deleteCharAt(path.length()-1);
       }
    }

    private static boolean isvalid(StringBuilder path) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < path.length(); i++) {
            if(path.charAt(i) == '(') stack.push(path.charAt(i));
            else if(!stack.isEmpty()) {
                stack.pop();
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 3;
        List<String> out = generateParenthesis(n);
        System.out.print(out);
    }
}
