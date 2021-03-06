package google;

public class OneAndZero474 {
    public static int findMaxForm(String[] strs, int m, int n) {
        int[][] dp  = new int[m+1][n+1];

        for(String str : strs) {
            int[] count = count(str);
            for (int i=m;i>=count[0];i--)
                for (int j=n;j>=count[1];j--)
                    dp[i][j] = Math.max(1 + dp[i-count[0]][j-count[1]], dp[i][j]);
        }
        return dp[m][n];
    }

    private static int[] count(String s) {
        int[] out = new int[2];

        for(char c : s.toCharArray()) {
            out[c - '0']++;
        }
        return out;
    }

    public static void main(String[] args) {

    }
}
