package jiuzhang;

import java.util.ArrayList;
import java.util.List;

public class FindPeekElementII {
    /**
     * @param A: An integer matrix
     * @return: The index of the peak
     */
    public static List<Integer> findPeakII(int[][] A) {
        // write your code here
        int m = A.length;
        int n = A[0].length;

        int start = 1;
        int end = m -1;
        List<Integer> out = new ArrayList<>();

        while(start < end) {
            int mid = (end - start) / 2 + start;
            int col = find(mid, A);
            if(A[mid][col] < A[mid-1][col]) {
                end = mid - 1;
            }else {
                if(A[mid][col] < A[mid+1][col]) {
                    start = mid+1;
                }else {
                    out.add(mid);
                    out.add(col);
                    return out;
                }
            }
        }
        return out;
    }

    private static int find(int mid, int[][] A) {
        int col = 0;

        for(int i = 0; i < A[0].length; i++) {
            if(A[mid][i] > A[mid][col]) {
                col = i;
            }
        }
        return col;
    }

    public static void main(String[] args) {
//        int[][] A = {
//                {1,2,3,4,5},
//                {16,41,23,22,6},
//                {15,17,24,21,7},
//                {14,18,19,20,8},
//                {13,12,11,10,9}
//        };
//
//        int[][] A = {
//                {1,5,3},
//                {4,10,9},
//                {2,8,7}
//        };
        int[][] A = {
                {1,2,3,4,5,6},
                {14,15,16,17,18,8},
                {12,13,11,10,9,7}
        };
        List<Integer> out = findPeakII(A);
        System.out.println(out);
    }
}
