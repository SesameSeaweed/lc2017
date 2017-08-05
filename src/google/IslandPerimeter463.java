package google;

public class IslandPerimeter463 {
    public static int islandPerimeter(int[][] grid) {
        int island = 0;
        int neighbor = 0;
        int m = grid.length;
        int n = grid[0].length;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    island++;
                    if(i < m - 1 && grid[i+1][j] == 1) neighbor++;
                    if(j < n - 1 && grid[i][j+1] == 1) neighbor++;
                }
            }
        }
        return island * 4 - neighbor * 2;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,1,0,0}, {1,1,1,0}, {0,1,0,0}, {1,1,0,0}};
        System.out.println(islandPerimeter(grid));
    }
}
