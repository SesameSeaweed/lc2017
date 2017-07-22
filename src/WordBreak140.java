import java.util.*;

public class WordBreak140 {
    public static List<String> wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0) return new ArrayList<>();
        return DFS(s, new HashSet<>(wordDict), new HashMap<String, LinkedList<String>>());
    }

     private static List<String> DFS(String s, Set<String> wordDict, HashMap<String, LinkedList<String>>map) {
        if (map.containsKey(s))
            return map.get(s);

        LinkedList<String>res = new LinkedList<String>();

        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> sublist = DFS(s.substring(word.length()), wordDict, map);
                for (String sub : sublist)
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
            }
        }
        map.put(s, res);
        return res;
    }

    public static void main(String[] args) {

    }
}
