public class PerfectSquare {

    public static int numSquares(int n) {
        int[] dp = n <=4 ? new int[5] : new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 1;

        for(int i = 5; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for(int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i - j*j] + 1, min);
                min = dp[i];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 13;
        System.out.println(numSquares(n));
    }
}
