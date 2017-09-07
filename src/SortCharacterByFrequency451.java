import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortCharacterByFrequency451 {
    public static String frequencySort(String s) {
        StringBuilder sb = new StringBuilder("");
        Map<Character, Integer> map = new HashMap<>();

        for(char c : s.toCharArray()) {
            if(map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            }else {
                map.put(c,1);
            }
        }

        List<Character>[] bucket = new List[s.length()+1];
        for(int i = 0; i < bucket.length; i++) {
            bucket[i] = new ArrayList<>();
        }

        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            int frequency = entry.getValue();
            bucket[frequency].add(entry.getKey());
        }

        for(int i = bucket.length-1; i >= 0; i--) {
            if(bucket[i].size() > 0) {
                for(Character c : bucket[i]) {
                    for(int j = i; j > 0; j--) {
                        sb.append(c);
                    }
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "eeeee";
        System.out.print(frequencySort(s));
    }
}
