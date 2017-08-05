package google;


public class TrappingWater42 {

    public static int trap(int[] height) {
        if(height == null || height.length < 2) return 0;

        int[] left = new int[height.length];
        int[] right = new int[height.length];
        int max = 0;

        int leftMax = height[0];
        int rightMax = height[height.length-1];

        for(int i = 0; i < height.length; i++) {
            left[i] = Math.max(height[i], leftMax);
            leftMax = left[i];
        }

        for(int i = height.length - 1; i >= 0; i--) {
            right[i] = Math.max(height[i], rightMax);
            rightMax = right[i];
        }

        for(int i = 0; i < height.length; i++) {
            max += Math.min(right[i], left[i]) - height[i];
        }
        return max;
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.print(trap(height));
    }
}
