package google;

import java.util.ArrayList;
import java.util.List;

public class MaxProductOfWordsLength318 {
    public static int maxProduct(String[] words) {
        List<List<Integer>> out = new ArrayList<>();
        for(int i = 0; i < words.length; i++) {
            helper(words, i, new ArrayList<>(), out);
        }

        int max = 0;

        for(List<Integer> foo : out) {
            for(Integer bar : foo) {
                max = Math.max(bar, max);
            }
        }
        return max;
    }

    private static void helper(String[] words, int index, List<Integer> path, List<List<Integer>> out) {

        for(int i = index+1; i < words.length; i++) {
            while(i< words.length && !isCommon(words[index], words[i])) {
                path.add(words[index].length() * words[i].length());
                i++;
            }
        }
        if(path != null && !path.isEmpty()) {
            out.add(path);
        }
    }

    private static boolean isCommon(String s, String t) {
        int[] dics = new int[26];
        for(char c : s.toCharArray()) {
            dics[c-'a']++;
        }

        for(char c : t.toCharArray()) {
           if(dics[c-'a'] != 0) return true;
        }
        return false;
    }

    public static void main(String[] args) {
//        String[] array = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        String[] array = {"a", "ab", "abc", "d", "cd", "bcd", "abcd"};
//        String[] array = {"a", "aa", "aaa", "aaaa"};
//        String[] array = {"abc",""};
        System.out.print(maxProduct(array));
    }
}
