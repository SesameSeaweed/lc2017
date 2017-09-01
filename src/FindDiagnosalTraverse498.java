import java.util.Arrays;

public class FindDiagnosalTraverse498 {
    public static int[] findDiagonalOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[] out = new int[m*n];
        int[][] dirs = {{1,-1}, {-1,1}};
        int d = 1;
        int col = 0;
        int row = 0;

        for(int i = 0; i < m*n; i++) {
            out[i] = matrix[row][col];
            row = row + dirs[d][0];
            col = col + dirs[d][1];

            if(row >= m) {
                row = m-1;
                col += 2;
                d = 1-d;
            }
            if(col >= n) {
                col = n - 1;
                row += 2;
                d = 1-d;
            }
            if(row < 0) {
                row = 0;
                d = 1-d;
            }
            if(col < 0) {
                col = 0;
                d = 1-d;
            }
        }
        return out;
    }

    public static void main(String[] args) {
        int[][] nums = {{1,2,3},{4,5,6},{7,8,9}};
        int[] out = findDiagonalOrder(nums);
        System.out.print(Arrays.toString(out));
    }
}
