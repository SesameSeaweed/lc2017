package google2;

public class BurstBalloons312 {
    public static int maxCoins(int[] nums) {
        int[] newNums = new int[nums.length+2];
        newNums[0] = 1;
        newNums[newNums.length-1] = 1;
        int[][] visited = new int[newNums.length][newNums.length];
        int[][] dp = new int[newNums.length][newNums.length];

        for(int i = 1; i < newNums.length-1; i++) {
            newNums[i] = nums[i-1];
        }
        return helper(newNums, 1, nums.length, visited, dp);
    }

    private static int helper(int[] nums, int left, int right, int[][] visited, int[][] dp) {
        if(visited[left][right] == 1) return dp[left][right];

        int out = 0;
        for(int k = left; k <= right; k++) {
            int mid = nums[k] * nums[left-1] * nums[right+1];
            int leftMax = helper(nums, left, k-1, visited, dp);
            int rightMax = helper(nums, k+1, right, visited, dp);
            out = Math.max(out, leftMax+rightMax+mid);
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
