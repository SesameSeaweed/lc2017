package jiuzhang;

public class NumberOfIsland {

    public static int numIslands(boolean[][] grid) {
        // write your code here
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == true) {
                    dfs(grid, i, j, m, n);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(boolean[][] grid, int i, int j, int m, int n) {
        int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};

        for(int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];

            if(x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == false) continue;
            grid[x][y] = false;
            dfs(grid, x, y, m, n);
        }
    }

    public static void main(String[] args) {
        boolean[][] grid = {{true, true, false, false, false},
                {false,true,false,false,true},
                {false, false, false, true, true},
                {false, false, false, false, false},
                {false, false, false, false, true}};

        System.out.println(numIslands(grid));
    }
}
