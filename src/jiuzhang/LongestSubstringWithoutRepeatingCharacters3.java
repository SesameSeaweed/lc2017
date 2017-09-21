package jiuzhang;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters3 {
    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        if(s.length() == 1) return 1;
        int min = 0;
        Set<Character> set = new HashSet<>();

        for(int i = s.length() - 1; i > 0; i--) {
            set.clear();
            set.add(s.charAt(i));
            int temp = 1;
            for(int j = i-1; j >=0; j--) {
                if(set.add(s.charAt(j))) {
                    temp++;
                }else{
                    min = Math.max(temp, min);
                    break;
                }
            }
            min = Math.max(min, temp);
        }
        return min;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
