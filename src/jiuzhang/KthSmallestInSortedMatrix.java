package jiuzhang;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestInSortedMatrix {

    public static int kthSmallest(int[][] matrix, int k) {
        // write your code here
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>(){
            @Override
            public int compare(Node n1, Node n2) {
                return n1.val - n2.val;
            }
        });

        int m = matrix.length;
        int n = matrix[0].length;

        pq.offer(new Node(0, 0, matrix[0][0]));
        int[][] dirs = {{1,0}, {0,1}};
        boolean[][] hashed = new boolean[m][n];

        int currX = 0;
        int currY = 0;

        for(int i = 0; i < k-1; i++) {
            Node currNode = pq.poll();
            currX = currNode.x;
            currY = currNode.y;

            int currx1 = dirs[0][0] + currX;
            int curry1 = dirs[0][1] + currY;

            int currx2 = dirs[1][0] + currX;
            int curry2 = dirs[1][1] + currY;

            if(currx1 >= m || curry1 >= n ) {
                currx1 = currx2;
                curry1 = curry2;
            }

            if( currx2 >= m || curry2 >= n ) {
                currx2 = currx1;
                curry2 = curry1;
            }

            if(currx1 == currx2 && curry1 == curry2 && !hashed[currx1][curry1]) {
                pq.offer(new Node(currx1, curry1, matrix[currx1][curry1]));
                hashed[currx1][curry1] = true;
            }
            else {
               if(!hashed[currx1][curry1]) pq.offer(new Node(currx1, curry1, matrix[currx1][curry1]));
               if(!hashed[currx2][curry2]) pq.offer(new Node(currx2, curry2, matrix[currx2][curry2]));
                hashed[currx1][curry1] = true;
                hashed[currx2][curry2] = true;
            }
        }
        return pq.poll().val;
    }

    private static class Node {
        int x;
        int y;
        int val;
        Node(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    public static void main(String[] args) {
//        int[][] matrix = {{1,5,7}, {3, 7, 8}, {4,8,9}};
        int[][] matrix = {{1,2,3,4,5}, {2,3,4,5,6},{3,4,5,6,7}, {4,5,6,7,8}};
        System.out.print(kthSmallest(matrix,19));
    }
}
