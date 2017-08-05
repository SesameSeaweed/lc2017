package google;

import java.util.Stack;

public class ValidParentheses20 {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if(current == '(' || current == '{' || current == '[') {
                stack.push(s.charAt(i));
            }else {
                if(!stack.isEmpty()) {
                    char c = stack.pop();
                    if(current == ')') {
                        if(c != '(') return false;
                    }
                    if(current == ']') {
                        if(c != '[') return false;
                    }
                    if(current == '}') {
                        if(c != '{') return false;
                    }

                }else return false;
            }
        }
        if(!stack.isEmpty()) return false;
        return true;
    }

    public static void main(String[] args) {
        String s = "()[]{}";
        System.out.print(isValid(s));
    }
}
