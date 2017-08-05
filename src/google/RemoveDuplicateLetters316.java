package google;

import java.util.Iterator;
import java.util.Stack;

public class RemoveDuplicateLetters316 {
    public static String removeDuplicateLetters(String s) {
        boolean[] visited = new boolean[26];
        int[] chars = new int[26];
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            chars[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            chars[c-'a']--;

            if(visited[c - 'a']) continue;
            while (!stack.isEmpty() && c < stack.peek() && chars[stack.peek() - 'a'] != 0) {
                visited[stack.peek()-'a'] = false;
                stack.pop();
            }
            stack.push(c);
            visited[c-'a'] = true;
        }

        Iterator it = stack.iterator();
        StringBuilder sb = new StringBuilder();
        while (it.hasNext()) {
            sb.append(it.next());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "cbacdcbc";
        System.out.println(removeDuplicateLetters(s));
    }

}
