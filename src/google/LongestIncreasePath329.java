package google;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pxu on 7/8/17.
 */
public class LongestIncreasePath329 {


    public static int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                List<Integer> path = new ArrayList<>();
                path.add(matrix[i][j]);
                max = Math.max(helper(matrix, path, i, j, m, n), max);
            }
        }
        return max;
    }

    public static int helper(int[][] matrix, List<Integer> path, int i, int j, int m, int n) {
        int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0, -1}};
        int max = 1;
        for(int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if(x < 0 || y < 0 || x >= m || y >= n || matrix[x][y] <= matrix[i][j])  continue;
            path.add(matrix[x][y]);
            max = helper(matrix, path, x, y, m, n);
            max = Math.max(path.size(), max);
            path.remove(path.size() - 1);
        }
        return max;
    }

    public static void main(String[] args) {
//        int[][] matrix = {{9,9,4}, {6,6,8}, {2,1,1}};
//        int[][] matrix = {{3,4,5}, {3,2,6}, {2,2,1}};
        int[][] matrix = {{7,7,5}, {2,4,6}, {8,2,0}};
        System.out.print(longestIncreasingPath(matrix));
    }
}
