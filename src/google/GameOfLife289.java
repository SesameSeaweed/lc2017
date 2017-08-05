package google;

import java.util.Arrays;

public class GameOfLife289 {
    public static void gameOfLife(int[][] board) {
        if(board == null || board.length == 0) return;

        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];
        int[][] out = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(visited[i][j]) continue;
                helper(board, i, j, m, n, visited, out);
            }
        }

        for(int i = 0; i < m; i++) {
            board[i] = out[i].clone();
            System.out.println(Arrays.toString(out[i]));
        }
        return;
    }

    private static void helper(int[][] board, int i, int j, int m, int n, boolean[][] visited, int[][] out) {
        int[][] dirs = {{1,0}, {-1, 0}, {1, 1}, {1, -1}, {0, 1}, {0, -1}, {-1, -1}, {-1,1}};

        if(!visited[i][j]) {
            int count = 0;
            for(int[] dir : dirs) {
                int x = i + dir[0];
                int y = j + dir[1];
                if(x < m && y < n && x >= 0 && y >= 0 && board[x][y] == 1) count++;
            }
            if(board[i][j] == 1) {
                if(count == 2 || count == 3) {
                    out[i][j] = 1;
                }
            } else {
                if(count == 3) out[i][j] = 1;
            }

            visited[i][j] = true;
        }
    }

    public static void main(String[] args) {
        int[][] board = {{0,0,0,0},{0,1,1,0},{0,1,1,0},{0,0,0,0}};
        gameOfLife(board);
    }
}
