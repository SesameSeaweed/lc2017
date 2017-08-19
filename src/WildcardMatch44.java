public class WildcardMatch44 {
    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;

        for(int i = 1; i<= m; i++) {
            dp[i][0] = false;
        }

        int i = 1;
        while(i <= n && p.charAt(i-1) == '*') {
            dp[0][i] = true;
            i++;
        }

        for(int j = 1; j <= m; j++) {
            for(int t = 1; t <= n; t++) {
                if(s.charAt(j-1) == p.charAt(t-1) || p.charAt(t-1) == '?') dp[j][t] = dp[j-1][t-1];
                if(p.charAt(t-1) == '*') dp[j][t] = dp[j-1][t] || dp[j-1][t-1] || dp[j][t-1];
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String s = "aab";
        String p = "c*a*b";
        System.out.print(isMatch(s,p));
    }
}
