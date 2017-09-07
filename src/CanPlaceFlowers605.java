public class CanPlaceFlowers605 {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed == null || flowerbed.length == 0) {
            if (n > 0)
                return false;
            else
                return true;
        }

        if (flowerbed.length == 1) {
            if (flowerbed[0] == 0)
                return n <= 1;
            return n <= 0;
        }

        if (flowerbed.length == 2) {
            if (flowerbed[0] == 0 && flowerbed[1] == 0 && n <= 1) return true;
            return n <= 0;
        }

        int[] dp = new int[flowerbed.length];
        dp[0] = (flowerbed[0] == 0 && flowerbed[1] == 0) ? 1 : 0;
        dp[1] = flowerbed[0] == 1 ? 0 : (flowerbed[2] == 0 && flowerbed[1] == 0)? 1 : dp[0];

        for (int i = 2; i < flowerbed.length; i++) {
            if (i < flowerbed.length - 1 && flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0 && flowerbed[i] == 0) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + 1);
            } else dp[i] = dp[i-1];
            if (i == flowerbed.length - 1 ) {
                if (flowerbed[i - 1] == 0 && flowerbed[i] == 0 && dp[i-1] == dp[i-2])
                    dp[i] += 1;
            }
        }

        return dp[flowerbed.length - 1] >= n;
    }

    public static void main(String[] args) {
//        int[] flowerbed = {1,0,1,0,1,0,1};
        int[] flowerbed = {1,0};
        int n = 0;
        System.out.println(canPlaceFlowers(flowerbed, n));
    }
}
