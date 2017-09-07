import java.util.Arrays;

public class RotateMatrix48 {
    public static void rotate(int[][] matrix) {
        int n = matrix.length;

        int[][] out = new int[n][n];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                out[j][n-i-1] = matrix[i][j];
            }
        }
        matrix = Arrays.copyOf(out, n);
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
        System.out.print(Arrays.deepToString(matrix));
    }
}
