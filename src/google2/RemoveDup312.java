package google2;

import java.util.*;

public class RemoveDup312 {
    public static String removeDuplicateLetters(String s) {
        Map<Character, Integer> map = new HashMap<>();

        Queue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
            @Override public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });

        for(int i = s.length() - 1; i >= 0; i--) {
            if(map.containsKey(s.charAt(i))) continue;
            map.put(s.charAt(i), i);
        }

       for(Map.Entry<Character, Integer> entry : map.entrySet()) {
           pq.offer(entry);
       }

        int start = 0;
        StringBuilder sb = new StringBuilder("");
        while(!pq.isEmpty()) {
            while(!pq.isEmpty() && sb.indexOf(""+pq.peek().getKey()) >= 0) pq.poll();
            if(pq.isEmpty()) return sb.toString();
            int index = pq.peek().getValue();
            char min = 'z';
            for(int i = start; i <= index; i++) {
                if(s.charAt(i) < min && sb.indexOf(""+s.charAt(i)) < 0) {
                    min = s.charAt(i);
                    start = i+1;
                }
            }
            sb.append(min);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        String s = "cbacdcbc";
//        String s = "ccacbaba";
        String s = "baab";
        System.out.print(removeDuplicateLetters(s));
    }
}
