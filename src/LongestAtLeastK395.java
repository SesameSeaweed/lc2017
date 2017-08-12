import java.util.HashSet;
import java.util.Set;

public class LongestAtLeastK395 {
    public static int longestSubstring(String s, int k) {
        int[] chars = new int[26];
        Set<Character> set = new HashSet<>();
        boolean charLess = false;
        int max = 0;

        for(char c : s.toCharArray()) {
            chars[c-'a']++;
        }

        for(int i = 0; i < 26; i++) {
            if(chars[i] >= k) {
                set.add((char) ('a'+i));
            } else {
               if(chars[i] != 0 ) charLess = true;
            }
        }

        if(!charLess) return s.length();
        for(int i = 0; i < s.length(); i++) {
            if(!set.contains(s.charAt(i))) {
                max = Math.max(max, longestSubstring(s.substring(0, i), k));
                while(i < s.length() && !set.contains(s.charAt(i))) {
                    i++;
                }
                max = Math.max(max, longestSubstring(s.substring(i),k));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "ababbc";
        int k = 3;
        System.out.print(longestSubstring(s, k));
    }
}
