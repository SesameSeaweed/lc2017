package jiuzhang;

import java.util.Stack;

public class LargestRectangleHistogram {
//    public static int largestRectangleArea(int[] height) {
//        // write your code here
//        Stack<Integer> stack = new Stack<>();
//        int out = 0;
//
//        stack.push(0);
//
//        for(int i = 0; i < height.length; i++) {
//            int curr = (i == height.length - 1) ? -1 : height[i];
//            while(!stack.isEmpty() && curr <= height[stack.peek()]) {
//                int preIndex = stack.pop();
//                int w = stack.isEmpty()? i : i - 1 - stack.peek();
//                out = Math.max(out, height[preIndex] * w);
//            }
//            stack.push(i);
//
//        }
//        return out;
//    }


    public static int largestRectangleArea(int[] height) {
        if(height == null || height.length == 0) return 0;

        Stack<Integer> stack = new Stack<>();
        int out = 0;

        for(int i = 0; i <= height.length; i++) {
            int curr = i == height.length ? -1 : height[i];

            while(!stack.isEmpty() && curr <= height[i]) {
                int h = height[stack.pop()];
                int w = stack.isEmpty() ? i : i - 1 - stack.peek();
                out = Math.max(out, h * w);
            }
            stack.push(i);
        }
        return out;
    }

    public static void main(String[] args) {
        int[] height = {2,1,5,6,2,3};
        System.out.print(largestRectangleArea(height));
    }
}
