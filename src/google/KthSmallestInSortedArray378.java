package google;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallestInSortedArray378 {
    private static class Tuple {
        private int x;
        private int y;
        private int val;
        Tuple(int i, int j, int val) {
            this.x = i;
            this.y = j;
            this.val = val;
        }
    }

    public static int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;

        Queue<Tuple> queue = new PriorityQueue<Tuple>(new Comparator<Tuple>() {
            @Override public int compare(Tuple o1, Tuple o2) {
                return o1.val  - o2.val;
            }
        });
        for(int i = 0; i < n; i++) queue.offer(new Tuple(0, i, matrix[0][i]));

        for(int i = 0; i < k - 1; i++) {
            Tuple curr = queue.poll();
            if(curr.x == m-1) continue;
            queue.offer(new Tuple(curr.x+1, curr.y, matrix[curr.x+1][curr.y]));
        }
        return queue.poll().val;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,5,9}, {10,11,13}, {12,13,15}};
        System.out.print(kthSmallest(matrix, 8));
    }
}
