import java.util.Arrays;

public class ImageSmoother661 {
    public static int[][] imageSmoother(int[][] M) {
        int length = M.length;
        int width = M[0].length;

        int[][] out = new int[length][width];

        for(int i = 0; i < length; i++) {
            for(int j = 0; j < width; j++) {
                out[i][j] = dfs(M, length, width, i, j);
            }
        }
        return out;
    }

    private static int dfs(int[][] M, int length, int width, int i, int j) {
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}, {-1,-1},{1,1},{-1,1},{1,-1}};
        int count = 9;
        int sum = M[i][j];

        for(int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if(x < 0 || x >= length || y < 0 || y >= width) {
                count--;
                continue;
            }
            sum += M[x][y];
        }
        return Math.floorDiv(sum,count);
    }

    public static void main(String[] args) {
        int[][] M = {{1,1,1}, {1,0,1},{1,1,1}};
        int[][] out = imageSmoother(M);
        System.out.print(Arrays.deepToString(out));
    }
}
