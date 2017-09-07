
public class LongestPalindrome5 {
    public static String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return s;
        String out = "" + s.charAt(0);

        boolean[][] dp = new boolean[s.length()][s.length()];

        for(int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }

        for(int i = s.length()-1; i >= 0; i--) {
            for(int j = i+1; j < s.length(); j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
                if(dp[i][j] && out.length() < j-i+1) out = s.substring(i,j+1);
            }
        }
        return out;
    }

    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(longestPalindrome(s));
    }
}
