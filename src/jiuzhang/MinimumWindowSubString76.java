package jiuzhang;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubString76 {
    public static String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();

        for(Character c : t.toCharArray()) {
            if(map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            }else {
                map.put(c, 1);
            }
        }

        int left = 0;
        int right = 0;
        int leftMin = 0;
        int rightMin = 0;
        int count = 0;
        int minWindow = s.length() + 1;

        for(; right < s.length(); right++) {
            if(map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right), map.get(s.charAt(right))-1);
                if(map.get(s.charAt(right)) >= 0) count++;
            }

            while(count == t.length()) {
                if(right - left +1 < minWindow) {
                    leftMin = left;
                    rightMin = right;
                    minWindow = rightMin - leftMin + 1;
                }

                if(map.containsKey(s.charAt(left))) {
                    map.put(s.charAt(left), map.get(s.charAt(left))+1);
                    if(map.get(s.charAt(left)) >= 1) {
                        count--;
                    }
                }
                left++;
            }
        }

        return minWindow == s.length() + 1 ? "" : s.substring(leftMin, rightMin + 1);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
//        String s = "abc";
//        String t = "ac";
        System.out.println(minWindow(s, t));
    }

}
