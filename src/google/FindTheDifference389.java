package google;

public class FindTheDifference389 {
    public static char findTheDifference(String s, String t) {
        int[] dic = new int[26];
        for(char c : s.toCharArray()) {
            dic[c-'a']++;
        }

        for(char c : t.toCharArray()) {
            dic[c - 'a']--;
        }

        for(int i = 0; i < dic.length; i++) {
            if(dic[i] != 0) return (char) ('a' + i);
        }
        return 'a';
    }

    public static void main(String[] args) {
        String s = "abcd";
        String t = "abcde";
        System.out.println(findTheDifference(s,t));
    }
}
