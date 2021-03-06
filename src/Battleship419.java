public class Battleship419 {
    public static int countBattleships(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int out = 0;

        for(int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X' && (i == 0 || board[i - 1][j] != 'X') && (j == 0 || board[i][j - 1] != 'X')) {
                    out++;
                }
            }
        }
        return out;
    }


    public static void main(String[] args) {
        char[][] board = {{'.','.','.','X'}, {'X','X','X','X'}, {'.','.','.','X'}};
        System.out.print(countBattleships(board));
    }
}
