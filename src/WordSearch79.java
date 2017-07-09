public class WordSearch79 {
    public static boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || word == null || word.length() == 0) return false;
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                boolean[][] visited = new boolean[m][n];
                StringBuilder sb = new StringBuilder();
                sb.append(board[i][j]);
                visited[i][j] =true;
                if(helper(board, m, n, i, j, sb, word.substring(1, word.length()), visited)) return true;
            }
        }
        return false;
    }

    private static boolean helper(char[][] board, int m, int n, int i, int j, StringBuilder sb, String word, boolean[][] visited) {
        if(word.length() == 0) return true;
        if(!word.startsWith(sb.toString())) return false;

        int[][] dirs = {{1,0}, {0,1}, {0,-1}, {-1,0}};

        for(int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if(x >= m || y >= n || x < 0 || y < 0 || visited[x][y]) continue;
            sb.append(board[x][y]);
            visited[x][y] = true;
            if(word.startsWith(sb.toString())) {
                return helper(board, m, n, x, y, sb, word.substring(sb.length() - 1, word.length()), visited);
            }
            sb.deleteCharAt(sb.length() - 1);
            visited[x][y] = false;
        }
        return false;
    }

    public static void main(String[] args) {
//        char[][] board = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
//        String s = "ABCCED";
//        String s = "SEE";
//        String s = "ABCB";

//        char[][] board = {{'a', 'b'}, {'c','d'}};
//        String s = "acdb";
        char[][] board = {{'c','a','a'}, {'a', 'a', 'a'}, {'b', 'c', 'd'}};
        String s = "aab";
        System.out.print(exist(board, s));
    }
}
