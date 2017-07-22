import java.util.Stack;

public class LongestValidParentheses32 {
    public static int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int curr = -1;
        int max = 0;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                stack.push(i);
            }else {
                if(!stack.isEmpty()) {
                    stack.pop();
                    if(!stack.isEmpty()) {
                        max = Math.max(max, i - Math.max(curr, stack.peek()));
                    }else {
                        max = Math.max(max, i - curr);
                    }
                }else {
                    curr = i;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "()(()))";
        System.out.print(longestValidParentheses(s));
    }
}
