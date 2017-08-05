package google;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReverseVowel345 {


    public static String reverseVowels(String s) {
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u','A', 'E', 'I', 'O', 'U'));
        char[] chars = s.toCharArray();
        int i = 0;
        int j = s.length() -1;
        while(i <= j) {
            while(i <= j && !set.contains(s.charAt(i))) {
                i++;
            }
            while(i <= j && !set.contains(s.charAt(j))) {
               j--;
            }
            if(i <= j && set.contains(s.charAt(i)) && set.contains(s.charAt(j))) {
                char c = chars[i];
                chars[i++] = chars[j];
                chars[j--] = c;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        String s = "hello";
        System.out.print(reverseVowels(s));
    }

}
