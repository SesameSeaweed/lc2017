import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Matrix01542 {
    public static int[][] updateMatrix(int[][] matrix) {
        if(matrix== null || matrix.length == 0) return matrix;
        Queue<int[]> queue = new LinkedList<int[]>();
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 1) {
                    matrix[i][j] = Integer.MAX_VALUE;
                }else {
                    queue.offer(new int[] {i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for(int[] dir : dirs) {
                int x = dir[0] + curr[0];
                int y = dir[1] + curr[1];
                if(x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] < matrix[curr[0]][curr[1]]+1) continue;

                matrix[x][y] = matrix[curr[0]][curr[1]]+1;
                queue.offer(new int[] {x, y});
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = {{0,0,0},{0,1,0}, {1,1,1}};
        matrix = updateMatrix(matrix);
        System.out.print(Arrays.deepToString(matrix));
    }
}
