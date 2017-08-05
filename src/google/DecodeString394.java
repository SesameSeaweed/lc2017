package google;

import java.util.Stack;

public class DecodeString394 {
    public static String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        Stack<Integer> count = new Stack<>();
        StringBuilder out = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == ']') {
                StringBuilder sb = new StringBuilder();
                StringBuilder sb1 = new StringBuilder();
                while(stack.peek() != '[') {
                    sb.append(stack.pop());
                }
                stack.pop();
                sb.reverse();
                int digit = count.pop();
                while(digit > 0) {
                    sb1.append(sb);
                    digit--;
                }
                out = sb1;
            } else {
                if(c == '[') {
                    stack.push(c);
                } else {
                    if(c - '0' >= 0 && c - '0' <= 9) {
                        int temp = 0;
                        while(Character.isDigit(s.charAt(i))) {
                            temp = temp * 10 + s.charAt(i) - '0';
                            i++;
                        }
                        i--;
                        count.push(temp);
                    }else{
                      stack.push(c);
                      out = new StringBuilder();
                    }
                }
            }
        }

        return out.toString();
    }


    public static void main(String[] args) {
        String S = "3[a]2[bc]";
        System.out.print(decodeString(S));
    }
}
