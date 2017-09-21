package jiuzhang;

import java.util.HashMap;
import java.util.Map;

public class LargestWithAtMostK159 {
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        if(s == null || s.length() == 0 || k <= 0) return 0;
        if(s.length() <= k ) return s.length();
        int left = 0;
        int right = 0;
        int count = 0;
        int max = 1;

        Map<Character, Integer> map = new HashMap<>();

        for(; right < s.length(); right++) {
            char c = s.charAt(right);
            if(!map.containsKey(c) || map.get(c) == 0) {
                count++;
            }
            map.put(c, map.getOrDefault(c, 0) + 1);

            while(count <= k && right + 1< s.length()) {
                char t = s.charAt(++right);
                if(map.containsKey(t) && map.get(t) > 0) {
                    map.put(t, map.get(t)+1);
                    if(max < right - left + 1) max = right - left + 1;
                } else {
                    map.put(t, 1);
                    if(max < right - left + 1) max = count == k ? right -left : right - left + 1;
                    count++;
                }

            }
            char m = s.charAt(left);
            if(map.containsKey(m) && map.get(m) == 1) {
                count--;
            }
            map.put(m, map.get(m) - 1);
            left++;
        }
        return max;
    }

    public static void main(String[] args) {
//        String s = "gjtlsblxhvobbcgyedaucxdqicqvlrmnfbbbfcfgmjzvchszwmjfzz";
//        String s = "kb";
        String s = "ecbea";
        int k = 3;
//        String s = "w";
//        int k = 1;
        System.out.print(lengthOfLongestSubstringKDistinct(s, k));
    }
}
