package google2;

public class OnesAndZeros474 {
    public static int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];

        for(String str : strs) {
            int[] count = count(str);
            for(int i = m; i >= count[0]; i--) {
                for(int j = n; j >= count[1]; j--) {
                    dp[i][j] = Math.max(dp[i-count[0]][j-count[1]]+1, dp[i][j]);
                }
            }
        }
        return dp[m][n];
    }

    private static int[] count(String str) {
        int[] out = new int[2];
        for(char c : str.toCharArray()) {
            if(c == '0') out[0]++;
            else out[1]++;
        }
        return out;
    }

    public static void main(String[] args) {
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int m =5;
        int n = 3;
        System.out.print(findMaxForm(strs, m,n));
    }
}
