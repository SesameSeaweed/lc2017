package google2;

import java.util.Comparator;
import java.util.PriorityQueue;

public class TrappingRainWater407 {
    private static class Cell {
        int x;
        int y;
        int val;

        public Cell(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    public static int trapRainWater(int[][] heightMap) {
        if(heightMap == null || heightMap.length == 0) return 0;
        int m = heightMap.length;
        int n = heightMap[0].length;
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        int out = 0;
        boolean[][] visited = new boolean[m][n];

        PriorityQueue<Cell> pq = new PriorityQueue<>(new Comparator<Cell>() {
            @Override public int compare(Cell o1, Cell o2) {
                return o1.val - o2.val;
            }
        });

        for(int i = 0; i < m; i++) {
            pq.add(new Cell(i, 0, heightMap[i][0]));
            pq.add(new Cell(i, n-1, heightMap[i][n-1]));
            visited[i][0] = true;
            visited[i][n-1] = true;
        }

        for(int i = 0; i < n; i++) {
            pq.add(new Cell(0, i, heightMap[0][i]));
            pq.add(new Cell(m-1, i,heightMap[m-1][i]));
            visited[0][i] = true;
            visited[m-1][i] = true;
        }

        int level = 0;

        while (!pq.isEmpty()) {
            level = Math.max(pq.peek().val, level);
            Cell curr = pq.poll();

            for(int[] dir : dirs) {
                int x = curr.x + dir[0];
                int y = curr.y + dir[1];
                if(x < 0 || y < 0 || x >= m || y >= n || visited[x][y]) continue;

                visited[x][y] = true;
                if(heightMap[x][y] < level) {
                    out += level-heightMap[x][y];
                }
                pq.add(new Cell(x,y, heightMap[x][y]));
            }
        }
        return out;
    }

    public static void main(String[] args) {
        int[][] heightMap = {{1,4,3,1,3,2}, {3,2,1,3,2,4}, {2,3,3,2,3,1}};
        System.out.println(trapRainWater(heightMap));
    }
}
