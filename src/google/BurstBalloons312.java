package google;

public class BurstBalloons312 {

    public static int maxCoins(int[] nums) {
        int[][] dp = new int[nums.length+2][nums.length+2];
        int[][] visited = new int[nums.length+2][nums.length+2];

        int[] newNums = new int[nums.length + 2];
        newNums[0] = 1;
        newNums[newNums.length - 1] = 1;
        for(int i = 1; i < nums.length + 1; i++) {
            newNums[i] = nums[i-1];
        }

        return helper(dp, visited, newNums, 1, nums.length);
    }

    private static int helper(int[][] dp, int[][] visited, int[] nums, int left, int right) {
        if(visited[left][right] == 1) return dp[left][right];

        int out = 0;
        for(int k = left; k <= right; k++) {
            int mid = nums[left-1] * nums[k] * nums[right+1];
            int leftMax = helper(dp, visited, nums, left, k-1);
            int rightMax = helper(dp, visited, nums, k+1, right);
            out = Math.max(out, mid + leftMax + rightMax);
        }
        visited[left][right] = 1;
        dp[left][right] = out;
        return out;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,5,8};
        System.out.print(maxCoins(nums));
    }
}

