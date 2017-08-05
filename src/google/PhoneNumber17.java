package google;

import java.util.*;

public class PhoneNumber17 {
    public static List<String> letterCombinations(String digits) {
        String[] dict = {"abc", "def", "hgi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        Map<String, List<String>> map = new HashMap<>();
        map.put("2", Arrays.asList("a","b","c"));
        map.put("3", Arrays.asList("d","e","f"));
        map.put("4", Arrays.asList("g","h","i"));
        map.put("5", Arrays.asList("j","k","l"));
        map.put("6", Arrays.asList("m","n","o"));
        map.put("7", Arrays.asList("p","q","r","s"));
        map.put("8", Arrays.asList("t","u","v"));
        map.put("9", Arrays.asList("w","x","y","z"));

        return helper(digits, dict, map);
    }

    private static List<String> helper(String digits, String[] dict, Map<String, List<String>> map) {
        if(digits.length() == 0) return new ArrayList<>();

        if(map.containsKey(digits)) {
            return map.get(digits);
        }

        List<String> temp = new ArrayList<>();
            char c = digits.charAt(0);
            for(char t : dict[c-'0'-2].toCharArray()) {
                List<String> list = helper(digits.substring(1, digits.length()), dict, map);
                for(String s : list) {
                    temp.add(t + s);
                }
            }
        map.put(digits, temp);
        return temp;
    }

    public static void main(String[] args) {
        String digits = "234";
        List<String> out = letterCombinations(digits);
        System.out.print(out);
    }
}
