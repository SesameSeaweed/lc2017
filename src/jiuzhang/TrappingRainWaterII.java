package jiuzhang;

import java.util.PriorityQueue;

public class TrappingRainWaterII {
    /*
     * @param heights: a matrix of integers
     * @return: an integer
     */
    public static int trapRainWater(int[][] heights) {
        // write your code here
        if(heights == null || heights.length == 0) return 0;
        int m = heights.length;
        int n = heights[0].length;
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        boolean[][] flag = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            pq.offer(new Node(i, 0, heights[i][0]));
            flag[i][0] = true;
        }

        for(int i = 1; i < n; i++) {
            pq.offer(new Node(0, i, heights[0][i]));
            flag[0][i] = true;
        }

        for(int i = 1; i < m; i++) {
            pq.offer(new Node( i, n-1, heights[i][n-1]));
            flag[i][n-1] = true;
        }

        for(int i = 1; i < n; i++) {
            pq.offer(new Node(m-1, i, heights[m-1][i]));
            flag[m-1][i] = true;
        }

        int[][] dirs = {{1,0}, {0,1}, {-1,0}, {0,-1}};
        int out = 0;

        while(!pq.isEmpty()) {
            Node node = pq.poll();

            for(int[] dir : dirs) {
                int x = node.x + dir[0];
                int y = node.y + dir[1];

                if(x >= m || y >= n || x < 0 || y < 0 || flag[x][y]) continue;
                flag[x][y] = true;

                if(heights[x][y] < node.label) {
                    out += node.label - heights[x][y];
                    pq.offer(new Node(x, y, node.label));
                }else {
                    pq.offer(new Node(x, y, heights[x][y]));
                }
            }
        }
        return out;
    }

    private static class Node implements Comparable<Node>{
        int label;
        int x;
        int y;

        Node(int x, int y, int label) {
            this.x = x;
            this.y = y;
            this.label = label;
        }

        @Override public int compareTo(Node o) {
            return this.label - o.label;
        }
    }

    public static void main(String[] args) {
        int[][] heights = { {12,13,0,12},
                {13,4,13,12},
                {13,8,10,12},
                {12,13,12,12},
                {13,13,13,13} };

        System.out.print(trapRainWater(heights));
    }
}
