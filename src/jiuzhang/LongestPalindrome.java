package jiuzhang;

public class LongestPalindrome {
    public static String longestPalindrome(String s) {
        // write your code here
        if(s == null || s.length() == 0) return "";
        boolean[][] dp = new boolean[s.length()][s.length()];
        int max = 0;
        String out = null;

        for(int i = 0; i < dp.length; i++) {
            dp[i][i] = true;
        }

        for(int i = dp.length-1; i >= 0; i--) {
            for(int j = i+1; j < dp.length; j++) {
                if(s.charAt(i) == s.charAt(j) && (j-i < 3 || dp[i+1][j-1])) {
                    dp[i][j] = true;
                    if(j-i+1 > max) {
                        max = j-i+1;
                        out = s.substring(i, j+1);
                    }
                }
            }
        }
        return out;
    }

    public static void main(String[] args) {
        String s = "abcdzdcab";
        System.out.println(longestPalindrome(s));
    }
}
