package jiuzhang;

import java.util.Stack;

public class MaximumRectangle {
    /*
    * @param matrix: a boolean 2D matrix
    * @return: an integer
    */
    public static int maximalRectangle(boolean[][] matrix) {
        // write your code here

        if(matrix == null || matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] nums = new int[n];
        int j = 0;
        int max = 0;
        while(j < m) {
            for(int i = 0; i < n; i++) {
                if(j == 0 && matrix[j][i]) {
                    nums[i] = 1;
                }else {
                    if(j != 0)
                    nums[i] = matrix[j][i] == true ? 1 + nums[i] : 0;
                }

            }
            max = Math.max(max, largestRectangle(nums));
            j++;
        }
        return max;
    }

    private static int largestRectangle(int[] nums) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i <= nums.length ; i++) {
            int curr = i== nums.length ? -1 : nums[i];
            while (!stack.isEmpty() && curr < nums[stack.peek()]) {
                int preIndex = stack.pop();
                int w = stack.isEmpty() ? i : i - 1 - stack.peek();
                max = Math.max(max, w * nums[preIndex]);
            }
            stack.push(i);
        }
        return max;
    }

    public static void main(String[] args) {
        boolean[][] matrix = {
                {true, true, false, false, true},
                {false, true, false, false, true},
                {false, false, true, true, true},
                {false, false, true, true, true},
                {false, false, false, false, true}
        };

//        boolean[][] matrix = {
//                {true},
//                {false},
//                {true},
//                {true},
//                {true},
//                {true},
//                {false}
//        };

        System.out.print(maximalRectangle(matrix));
    }
}
