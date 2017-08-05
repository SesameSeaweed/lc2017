package google;

public class NumberHigherLower375 {
    public static int getMoneyAmount(int n) {
        int[][] dp = new int[n+1][n+1];
        return helper(dp, 1, n);
    }

    private static int helper(int[][] dp, int start, int end) {
        int out = Integer.MAX_VALUE;
        if(start >= end) {
            return 0;
        }
        if(dp[start][end] != 0) return dp[start][end];

        for(int i = start; i <= end; i++) {
            int tmp = i + Math.max(helper(dp, start, i-1), helper(dp, i+1, end));
            out = Math.min(tmp, out);
        }
        dp[start][end] = out;
        return out;
    }

    public static void main(String[] args) {
        int n = 10;
        System.out.print(getMoneyAmount(n));
    }
}
