public class LongReplacement424 {
    public static int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int start = 0;
        if(s == null || s.length() == 0 || k < 0) return 0;
        count[s.charAt(start)-'A']++;
        int out = 0;

        for(int i = start+1; i < s.length(); i++) {
            count[s.charAt(i)-'A']++;
            int maxCnt = maxCount(count);
            if(i-start+1-maxCnt <= k) {
                out = Math.max(out, i-start+1);
            }else {
                count[s.charAt(start++)-'A']--;
            }
        }
        return out;
    }

    private static int maxCount(int[] count) {
        int out = 0;
        for(int i = 0; i < 26; i++) {
            out = Math.max(out, count[i]);
        }
        return out;
    }

    public static void main(String[] args) {
//        String s = "ABAB";
        String s = "AABABBA";
        int k = 2;
        System.out.print(characterReplacement(s,k));
    }
}
