package google;

public class RegularExpressionMatch10 {
    public static boolean isMatch(String s, String p) {

        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i-1]) {
                dp[0][i+1] = true;
            }
        }

        for(int i = 0; i < s.length(); i++) {
            for(int j = 0; j < p.length(); j++) {
                if(s.charAt(i+1) == p.charAt(j+1)) {
                    dp[i+1][j+1] = dp[i][j];
                }
                    if(p.charAt(j+1)=='.') {
                        dp[i+1][j+1] = dp[i][j];
                    }
                if(p.charAt(j+1) == '*') {
                    if(p.charAt(j) != s.charAt(i+1) && p.charAt(j) != '.') {
                        dp[i+1][j+1] = dp[i+1][j-1];
                    }else{
                        dp[i+1][j+1] = (dp[i][j+1] || dp[i+1][j] || dp[i][j]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    public static void main(String[] args) {
        String s = "abc";
        String p = "abc";
        System.out.println(isMatch(s,p));
    }
}
