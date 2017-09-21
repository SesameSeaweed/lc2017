package jiuzhang;

public class WordSearch {

    public static boolean exist(char[][] board, String word) {
        // write your code here
        if(board == null || board.length == 0 || board[0].length == 0) return false;

        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = null;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == word.charAt(0)) {
                    visited = new boolean[m][n];
                    visited[i][j] = true;
                     if(dfs(board, i, j, word, 1, m, n, visited)) return true;
                }
            }
        }
        return false;
    }


    private static boolean dfs(char[][] board, int i, int j, String word, int index, int m, int n, boolean[][] visited) {
        if(index == word.length()) return true;

        int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};


        for(int[] dir : dirs) {
            int x = dir[0] + i;
            int y = dir[1] + j;
            if(x < 0 || y < 0 || x >= m || y >= n || visited[x][y] || board[x][y] != word.charAt(index)) continue;
            visited[x][y] = true;
            if(dfs(board, x, y, word, index+1, m, n, visited)) return true;
            visited[x][y] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };

        String s = "ABCB";
        System.out.println(exist(board, s));
    }
}
