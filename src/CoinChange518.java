public class CoinChange518 {
    public static int change(int amount, int[] coins) {

        int[] dp = new int[amount+1];
        dp[0] = 1;

        for(int coin : coins) {
            for(int i = 1; i <= amount; i++) {
                if(i >= coin) {
                    dp[i] += dp[i-coin];
                }
            }
        }

        return dp[amount];
    }


    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1,2,5};
        System.out.print(change(amount, coins));
    }

}
