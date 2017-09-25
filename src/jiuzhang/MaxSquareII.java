package jiuzhang;

public class MaxSquareII {
    static int[][] left = null;
    static int[][] up = null;
    static int[][] dp = null;
    public static int maxSquare2(int[][] matrix) {
        // write your code here
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;

        left = new int[m][n];
        up = new int[m][n];
        dp = new int[m][n];

        left[0][0] = 0;

        for(int i = 0; i < m; i++) {
            left[i][0] = 0;
        }
        for(int i = 0; i < m; i++) {
            for(int j = 1; j < n; j++) {
                if(matrix[i][j-1] == 0) {
                    left[i][j] = left[i][j-1]+1;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            up[0][i] = 0;
        }

        for(int i = 1; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i-1][j] == 0) {
                    up[i][j] = up[i-1][j]+1;
                }
            }
        }

        for(int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i] == 1 ? 1 : 0;
        }

        for(int j = 0; j < m; j++) {
            dp[j][0] = matrix[j][0] == 1 ? 1 : 0;
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 1) {
                    if(i >= 1 && j >= 1) {
                        dp[i][j] = Math.min(Math.min(left[i][j], up[i][j]), dp[i-1][j-1]) + 1;
                    }else {
                        dp[i][j] = matrix[i][j] == 1 ? 1 : 0;
                    }

                    max = Math.max(dp[i][j], max);
                }
            }
        }
        return max*max;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1,0,1,0,0},
                {1,0,0,1,0},
                {1,1,0,0,1},
                {1,0,0,1,0}
        };

        System.out.print(maxSquare2(matrix));

    }
}
