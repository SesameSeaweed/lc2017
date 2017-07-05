public class MatchSticks473 {
    public static boolean makesquare(int[] nums) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        if(sum % 4 != 0) return false;

        return dfs(nums, new int[4], 0, sum/4);
    }

    private static boolean dfs(int[] nums, int[] path, int index, int target) {
        if(index == nums.length ) {
            if(path[0] == target && path[1] == target && path[2] == target && path[3] == target ) return true;
            return false;
        }

        for(int i = 0; i < 4; i++) {
            if(path[i] + nums[index] > target) continue;
            path[i] += nums[index];
            if(dfs(nums, path, index+1, target)) return true;
            path[i] = path[i] - nums[index];
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,2,2};
        System.out.print(makesquare(nums));
    }
}
