package google2;


public class PerfectSquares279 {
    public static int numSquares(int n) {
        int[] dp = new int[n >= 5 ? n+1 : 5];
        if(n < 2) return 1;
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 1;
        if(n <= 4) return dp[n];

        for(int i = 5; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for(int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int n = 13;
        System.out.print(numSquares(n));
    }
}
