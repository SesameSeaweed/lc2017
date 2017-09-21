package amazon;

import java.util.*;

public class WordLadder127 {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> beginSet = new HashSet<String>(), endSet = new HashSet<String>();

        int len = 1;
        int strLen = beginWord.length();
        HashSet<String> visited = new HashSet<String>();

        beginSet.add(beginWord);
        endSet.add(endWord);
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> set = beginSet;
                beginSet = endSet;
                endSet = set;
            }

            Set<String> temp = new HashSet<>();
            for (String word : beginSet) {
                char[] chs = word.toCharArray();

                for (int i = 0; i < chs.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = chs[i];
                        chs[i] = c;
                        String target = String.valueOf(chs);

                        if (endSet.contains(target)) {
                            return len + 1;
                        }

                        if (!visited.contains(target) && wordList.contains(target)) {
                            temp.add(target);
                            visited.add(target);
                        }
                        chs[i] = old;
                    }
                }
            }

            beginSet = temp;
            len++;
        }

        return 0;
    }

    private static boolean trans(String s1, String s2) {
       int count = 0;

        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) count++;
            if(count > 1) return false;
        }
        return count == 1;
    }

    private static boolean stopSearch(String word, String tobe) {
        if(word.length() < 2) return false;

        if((word.charAt(0) > tobe.charAt(0)) && (word.charAt(1) > tobe.charAt(1))) return true;
        if((word.charAt(1) < tobe.charAt(1)) && (word.charAt(0) < tobe.charAt(0))) return true;
        return false;
    }
    public static void main(String[] args) {
        String beginWord = "hot";
        String endWord = "dog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
//        List<String> wordList = Arrays.asList("hot", "dog");
//        String beginWord = "leet";
//        String endWord = "code";
//        List<String> wordList = Arrays.asList("lest", "leet", "lose", "code", "lode", "robe", "lost");
        System.out.print(ladderLength(beginWord, endWord, wordList));
    }
}
