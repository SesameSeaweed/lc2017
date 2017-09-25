package jiuzhang;

public class EditDistance {
    public static int minDistance(String word1, String word2) {
        // write your code here
        if(word1 == null && word2 == null) return 0;

        if(word1 == null || word1.length() == 0) return word2.length();
        if(word2 == null || word2.length() == 0) return word1.length();

        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];

        for(int i=0; i<= n; i++){
            dp[0][i] = i;
        }
        for(int i=0; i <= m; i++){
            dp[i][0] = i;
        }

        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String word1 = "mart";
        String word2 = "karma";
        System.out.print(minDistance(word1, word2));
    }
}
