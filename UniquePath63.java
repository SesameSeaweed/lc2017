public class UniquePath63 {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0) return 0;

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[m-1][n-1] == 1) return 0;

        int[][] path = new int[m][n];

         for(int i = 0; i < n; i++) {
        	if(obstacleGrid[0][i] == 0) path[0][i] = 1;
        	else break;
        }
        for(int i = 0; i < m; i++) {
        	if(obstacleGrid[i][0] == 0) path[i][0] = 1;
        	else break;
        }


        for(int i = 1; i < m; i++) {
        	for(int j = 1; j < n; j++) {
        		if(obstacleGrid[i][j] == 0) path[i][j] = path[i-1][j] + path[i][j-1];
        		else path[i][j] = 0;
        	}
        }
        return path[m-1][n-1];
    }

    public static void main(String[] args) {
    	int[][] obstacleGrid = {{0,0,0}, {0,1,0}, {0,0,0}};
    	System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }
}