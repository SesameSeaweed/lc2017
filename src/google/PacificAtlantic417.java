package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by pxu on 7/3/17.
 */
public class PacificAtlantic417 {

    public static List<int[]> pacificAtlantic(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return new ArrayList<>();

        int m = matrix.length;
        int n = matrix[0].length;

        boolean[][] pacVisited = new boolean[m][n];
        boolean[][] atlVisited = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            dfs(matrix, i, 0, m, n, pacVisited);
            dfs(matrix, i, n - 1, m, n, atlVisited);
        }

        for(int i = 0; i < n; i++) {
            dfs(matrix, 0, i, m, n, pacVisited);
            dfs(matrix, n-1, i, m, n, atlVisited);
        }

        List<int[]> out = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(pacVisited[i][j] && atlVisited[i][j]) out.add(new int[] {i, j});
            }
        }
        return out;
    }

    private static void dfs(int[][] matrix, int i, int j, int m, int n, boolean[][] visited) {
        if(i < 0 || i >= m || j < 0 || j >= n || visited[i][j]) return;

        visited[i][j] = true;
        int[][] dirs = {{0,1}, {0, -1}, {1, 0}, {-1, 0}};
        for(int[] dir : dirs) {
            int x = dir[0] + i;
            int y = dir[1] + j;

            if(x >= 0 && x < m && y >=0 && y <n && !visited[i][j]) {
                if(matrix[x][y] >= matrix[i][j]) {
                    dfs(matrix, x, y, m, n, visited);
                }
            }
        }

    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,2,3,5}, {3,2,3,4,4}, {2,4,5,3,1}, {6,7,1,4,5}, {5,1,1,2,4}};
        List<int[]> out = pacificAtlantic(matrix);
        for(int[] it : out) {
            System.out.println(Arrays.toString(it));
        }
    }
}
