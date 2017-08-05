package google;

import java.util.*;

public class WordBreak140 {

    public static List<String> wordBreak(String s, List<String> wordDict) {
        Map<String, ArrayList<String>> map = new HashMap<>();

        return helper(s, wordDict, map);
    }

    private static List<String> helper(String s, List<String> wordDict, Map<String, ArrayList<String>> map) {
        if (map.containsKey(s))
            return map.get(s);

        ArrayList<String>res = new ArrayList<>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String>sublist = helper(s.substring(word.length()), wordDict, map);
                for (String sub : sublist)
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
            }
        }
        map.put(s, res);
        return res;

    }

    public static void main(String[] args) {
//        String s = "catsanddog";
//        List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        List<String> wordDict = Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");
        List<String> out = wordBreak(s, wordDict);
        System.out.print(out);
    }
}
