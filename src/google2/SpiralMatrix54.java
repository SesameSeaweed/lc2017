package google2;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix54 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return new ArrayList<>();
        List<Integer> out = new ArrayList<>();
        int cycle = 0;
        int row = 0;
        int col = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        if(m == 1) {
            for(int i : matrix[0]) {
                out.add(i);
            }
            return out;
        }
        if(n == 1) {
            for(int[] rowE : matrix) {
                out.add(rowE[0]);
            }
            return out;
        }
        int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};

        int d = 0;
        out.add(matrix[0][0]);
        while(out.size() < m*n) {
            row = row + dirs[d][0];
            col = col + dirs[d][1];

            if(col == n - cycle - 1 && d==0) {
                d++;
            }

            if(row == m - cycle - 1 && d == 1) {
                d++;
            }

            if(col == cycle && d == 2) {
                d++;
            }

            if(row == cycle+1 && d == 3) {
                d = 0;
                cycle++;
                row = cycle;
            }
            out.add(matrix[row][col]);
        }
        return out;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}, {17,18,19,20}};
//        int[][] matrix = {{3}, {2}};
//        int[][] matrix = {{2,3,4},{5,6,7},{8,9,10},{11,12,13},{14,15,16}};
        List<Integer> out = spiralOrder(matrix);
        System.out.print(out);
    }
}
