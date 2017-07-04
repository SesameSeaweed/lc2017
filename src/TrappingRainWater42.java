public class TrappingRainWater42 {
    public static int trap(int[] height) {
        if(height == null || height.length < 1) return 0;
        int[] maxLeft = new int[height.length];
        int[] maxRight = new int[height.length];
        int maxLeftSoFar = height[0];
        int maxRightSoFar = height[height.length - 1];
        int out = 0;

        for(int i = 0; i < height.length; i++) {
          if(height[i] > maxLeftSoFar) {
              maxLeft[i] = height[i];
              maxLeftSoFar = height[i];
          }else {
              maxLeft[i] = maxLeftSoFar;
          }
        }

        for(int i = height.length - 1; i >= 0; i--) {
            if(height[i] > maxRightSoFar) {
                maxRight[i] = height[i];
                maxRightSoFar = height[i];
            } else {
                maxRight[i] = maxRightSoFar;
            }
        }

        for(int i = 0; i < height.length ; i++) {
            int tmp = Math.min(maxLeft[i], maxRight[i]) - height[i];
            if(tmp > 0) out += tmp;
        }
        return out;
    }

    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.print(trap(height));
    }
}
