package jiuzhang;

public class LongestWithoutRepeating {

    public static int lengthOfLongestSubstring(String s) {
        // write your code here
        if(s == null || s.length() == 0 ) return 0;
        int[] map = new int[256];
        int j = 0;
        int max = 0;

        for(int i = 0; i <= j && j < s.length(); i++, j++) {
            while(j < s.length()) {
                char c = s.charAt(j);
                if(map[c] == 0) {
                    map[c]++;
                    max = Math.max(j-i+1, max);
                    j++;
                } else {
                    map[c]++;
                    while(i <= j && s.charAt(i) != c) {
                        map[s.charAt(i)]--;
                        i++;
                    }
                    break;
                }
            }
            map[s.charAt(i)]--;
        }
        return max;
    }

    public static void main(String[] args) {
//        String s = "an++--viaj";
//        String s = "bbbb";
//        String s = "s";
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
