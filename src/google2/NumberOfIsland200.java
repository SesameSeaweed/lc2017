package google2;

public class NumberOfIsland200 {

    public static int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0) return 0;

        int m = grid.length;
        int n = grid[0].length;
        int res = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, m, n, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private static void dfs(char[][] grid, int m, int n, int i, int j ) {

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0,1}};

        for(int[] dir : dirs) {
            int x = dir[0] + i;
            int y = dir[1] + j;

            if(x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == '0') continue;
            grid[x][y] = '0';
            dfs(grid,m,n,x,y);
        }
    }

    public static void main(String[] args) {
        char[][] grid = {{'1','1','0','0','0'}, {'1','1','0','0','0'}, {'0','0','1','0','0'}, {'0','0','0','1','1'}};
        System.out.println(numIslands(grid));
    }
}
