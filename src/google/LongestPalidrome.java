package google;

import java.util.HashMap;
import java.util.Map;

public class LongestPalidrome {
    public static int longestPalindrome(String s) {
        if(s == null || s.length() == 0) return 0;
        int max = 0;
        boolean isSingle = false;

        Map<Character, Integer> map = new HashMap<>();

        for(char c : s.toCharArray()) {
            if(map.containsKey(c)) {
                map.put(c, map.get(c)+1);
            }else {
                map.put(c,1);
            }
        }

        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            if(entry.getValue() % 2 == 0) {
                max += entry.getValue();
            }else {
                max += entry.getValue() - 1;
                isSingle = true;
            }
        }
        return isSingle ? max+1 : max;
    }

    public static void main(String[] args) {
        String s = "ccc";
        System.out.print(longestPalindrome(s));
    }
}
