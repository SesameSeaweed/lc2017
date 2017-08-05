package google;

public class NumberOfIsland200 {

    public static int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;

        int m = grid.length;
        int n = grid[0].length;
        int out = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j, m, n);
                    out++;
                }
            }
        }
        return out;
    }

    private static void dfs(char[][] grid, int i, int j, int m, int n) {
        if(i >= m || i < 0 || j >= n || j < 0 || grid[i][j] != '1') return;

        if(grid[i][j] == '1') {
            grid[i][j] = '2';
            dfs(grid, i-1, j, m, n);
            dfs(grid, i+1, j, m, n);
            dfs(grid, i, j-1, m, n);
            dfs(grid, i, j+1, m, n);
        }
    }

    public static void main(String[] args) {
        char[][] grid = {{'1','1','1','1','0'}, {'1','1','0','1','0'}, {'1','1','0','0','0'}, {'0','0','0','0','0'}};

        System.out.println(numIslands(grid));
    }
}
