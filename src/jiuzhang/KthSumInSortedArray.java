package jiuzhang;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSumInSortedArray {
    public static int kthSmallestSum(int[] A, int[] B, int k) {
        // write your code here
        int t = 1;

        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>(){
            @Override
            public int compare(Node n1, Node n2) {
                return n1.sum - n2.sum;
            }
        });

        pq.offer(new Node(0, 0, A[0]+B[0]));

        while(t < k) {
            Node curr = pq.poll();
            int currX = curr.index1;
            int currY = curr.index2;

            if(currY+1 == B.length && currX+1 == A.length) return -1;

            if(currY+1 == B.length) {
                currY = 0;
                while(currX < A.length - 1 && B[currY] + A[currX +1] < curr.sum) {
                    currY++;
                }
                if(currY >= B.length) return -1;
                pq.offer(new Node(currX+1, currY, A[currX+1] + B[currY]));
                t++;
                continue;
            }

            if(currX+1 == A.length) {
                currX = 0;
                while(currY < B.length - 1 && A[currX] + B[currY+1] < curr.sum) {
                    currX++;
                }
                if(currY >= A.length) return -1;
                pq.offer(new Node(currX, currY+1, A[currX] + B[currY+1]));
                t++;
                continue;
            }

            if( A[currX] + B[currY+1] > A[currX+1] + B[currY]) {
                pq.offer(new Node(currX+1, currY, A[currX+1] + B[currY]));
            } else {
                pq.offer(new Node(currX, currY+1, A[currX] + B[currY+1]));
            }
            t++;
        }
        return pq.poll().sum;
    }

    private static class Node {
        int index1;
        int index2;
        int sum;

        Node(int index1, int index2, int sum) {
            this.index1 = index1;
            this.index2 = index2;
            this.sum = sum;
        }
    }

    public static void main(String[] args) {
        int[] A = {1,7,11};
        int[] B = {2,4,6};

        System.out.println(kthSmallestSum(A, B, 10));

    }
}
