import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

public class Matrix542 {
    public static int[][] updateMatrix(int[][] matrix) {
    	if(matrix == null || matrix.length == 0) return new int[0][0];
        Queue<int[]> queue = new LinkedList<>();
        int m = matrix.length;
        int n = matrix[0].length;

        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		if(matrix[i][j] == 1) matrix[i][j] = Integer.MAX_VALUE;
        		else queue.offer(new int[] {i, j});
        	}
        }

        int[][] dirs = {{1,0}, {-1, 0}, {0, 1}, {0, -1}};
        while(!queue.isEmpty()) {
             

        	int[] cell = queue.poll();
        	for(int[] dir : dirs) {
        		int x = dir[0] + cell[0];
        		int y = dir[1] + cell[1];

        		if(x < 0 || x >= m || y < 0 || y >= n) continue;

        		if(matrix[x][y] <= matrix[cell[0]][cell[1]] + 1) continue;
        		queue.offer(new int[] {x, y});
        		matrix[x][y] = matrix[cell[0]][cell[1]] + 1;
        	}
        }
        return matrix;
    }

    public static void main(String[] args) {
    	int[][] matrix = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}, {1,1,1}};
    	System.out.println(Arrays.deepToString(matrix));
    } 
}