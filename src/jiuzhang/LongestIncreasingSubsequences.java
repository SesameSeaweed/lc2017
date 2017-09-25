package jiuzhang;

public class LongestIncreasingSubsequences {
    boolean[][] flag;
    int[][] dp;
    public int longestIncreasingContinuousSubsequenceII(int[][] A) {
        // write your code here
        int out = 1;
        flag = new boolean[A.length][A[0].length];
        dp = new int[A.length][A[0].length];

        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < A[0].length; j++) {
                out = Math.max(out, search(A, i,j));
            }
        }
        return out;
    }

    private int search(int[][] A, int x, int y) {
        if(flag[x][y]) return dp[x][y];
        int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};

        int m = A.length;
        int n = A[0].length;
        int out = 1;

        for(int[] dir : dirs) {
            int i = dir[0] + x;
            int j = dir[1] + y;

            if(i >= m || j >= n || i < 0 || j < 0 || flag[i][j]) continue;

            if(A[i][j] < A[x][y]) {
                out = Math.max(out, 1+search(A, x, y));
            }
        }
        flag[x][y] = true;
        dp[x][y] = out;
        return dp[x][y];
    }
}
