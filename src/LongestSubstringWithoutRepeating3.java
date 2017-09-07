import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeating3 {
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = -1;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c) && map.get(c) >= left) {

                    int temp = Math.min(i-left, i - map.get(c));
                    max = Math.max(max,temp);
                    left = map.get(c);

            } else {
                max = Math.max(max, i-left);
            }
            map.put(s.charAt(i), i);
        }
        return max;
    }

    public static void main(String[] args) {
//        String s = "abcabcbb";
//        String s = "bbbbb";
//        String s = "pwwkew";
//        String s = "c";
//        String s = "aab";
//        String s = "dvdf";
        String s = "ggububgvfk";
//        String s ="tmmzuxt";
        System.out.print(lengthOfLongestSubstring(s));
    }
}
