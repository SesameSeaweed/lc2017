import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAnagrams438 {
    public static List<Integer> findAnagrams(String s, String p) {
        int[] pDict = new int[26];
        int[] sDict = new int[26];
        int len = p.length();

        if(s.length() < p.length()) return new ArrayList<>();

        List<Integer> out = new ArrayList<>();
        for(char c : p.toCharArray()) {
            pDict[c-'a']++;
        }
        int start = 0;
        while(start < len) {
            sDict[s.charAt(start) - 'a']++;
            start++;
        }
        start = 0;
        if(Arrays.equals(pDict, sDict)) out.add(0);

        while( start < s.length() - len) {
            sDict[s.charAt(start)-'a']--;
            sDict[s.charAt(start+len)-'a']++;
            if(Arrays.equals(pDict, sDict)) out.add(1+start);
            start++;
        }
        return out;
    }

    public static void main(String[] args) {
        String s = "abab";
        String p = "ba";
        List<Integer> out = findAnagrams(s,p);
        System.out.println(out);
    }
}
