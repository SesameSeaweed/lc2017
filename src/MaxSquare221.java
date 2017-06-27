public class MaxSquare221 {
    public static int maximalSquare(char[][] matrix) {
    	if(matrix == null || matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;

        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) {
        	dp[i][0] = matrix[i][0] - '0';
        	max = Math.max(max, dp[i][0]);
        }

        for(int j = 0; j < n; j++) {
        	dp[0][j] = matrix[0][j] - '0';
        	max = Math.max(max, dp[0][j]);
        }

        for(int i = 1; i < m; i++) {
        	for(int j = 1; j < n; j++) {
        		if(matrix[i][j] - '0' != 0) {
                    int temp = minFromThree(dp[i-1][j], dp[i-1][j-1], dp[i][j-1]);
        		    dp[i][j] = temp + 2*(int) Math.sqrt(temp) + 1;
        		    max = Math.max(max, dp[i][j]);
        		}else {
        			dp[i][j] = 0;
        		}
        		
        	}
        }
        // System.out.println(Arrays.deepToString(dp));
        return max;
    }

    private static int minFromThree(int a, int b, int c) {
    	return Math.min(Math.min(a,b), c);
    }

    public static void main(String[] args) {
    	char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '1', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '1', '1', '1', '0'}};
    	System.out.println(maximalSquare(matrix));
    }
}