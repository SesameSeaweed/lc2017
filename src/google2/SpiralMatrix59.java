package google2;

import java.util.Arrays;

public class SpiralMatrix59 {
    public static int[][] generateMatrix(int n) {
        if(n == 0) return new int[0][];
        int[][] out = new int[n][n];
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};

        int col = 0;
        int row = 0;
        int d = 0;
        int cycle = 0;
        int i = 1;
        out[0][0] = 1;
        while(i < n*n) {
            row = row + dirs[d][0];
            col = col + dirs[d][1];

            if(col == n - cycle - 1 && d==0) {
                d++;
            }

            if(row == n - cycle - 1 && d == 1) {
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
            out[row][col] = ++i;
        }
        return out;
    }


    public static void main(String[] args) {
        int n = 3;
        int[][] out = generateMatrix(n);
        System.out.println(Arrays.deepToString(out));
    }
}
