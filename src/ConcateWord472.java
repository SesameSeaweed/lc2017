import java.util.*;

public class ConcateWord472 {
    public static List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> out = new ArrayList<>();
        Arrays.sort(words, new Comparator<String>() {
            @Override public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        int minLength = words[0].length();
        Set<String> dict = new HashSet<>(Arrays.asList(words));
        for(int i = 0; i < words.length; i++) {
            if(isConcated(words[i], dict)) {
                out.add(words[i]);
            }
            dict.add(words[i]);
        }
        return out;
    }

    private static boolean isConcated(String word, Set<String> dict) {
        if(dict.isEmpty()) return false;
        boolean[] dp = new boolean[word.length()+1];
        dp[0] = true;
        for(int i = 1; i < dp.length; i++) {
            for(int j = 0; j < i; j++) {
                if(!dp[j]) continue;
                if(dict.contains(word.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[word.length()];
    }

    public static void main(String[] args) {
        String[] words = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
        List<String> out = findAllConcatenatedWordsInADict(words);
        System.out.print(out);
    }
}
