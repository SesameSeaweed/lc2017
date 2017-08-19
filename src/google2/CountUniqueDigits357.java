package google2;

public class CountUniqueDigits357 {
    public static int countNumbersWithUniqueDigits(int n) {
        if(n == 0) return 1;
        if(n == 1) return 10;

        int[] dp = new int[n+1];
        for(int i = 2; i <= n; i++) {
            int tmp = 9;
            for(int j = i-1; j>=1; j--) {
                tmp *= 10-j;
            }
            dp[i] = dp[i-1] + tmp;
        }

        return dp[n]+10;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.print(countNumbersWithUniqueDigits(n));
    }
}
