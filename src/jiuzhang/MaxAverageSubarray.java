package jiuzhang;

public class MaxAverageSubarray {

    public static double maxAverage(int[] nums, int k) {
        // write your code here
        double max = Integer.MIN_VALUE;
        double min = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }

        while(max - min >= 1e-6) {
            double mid = (max + min) / 2.0;
            if(valid(nums, k, mid)) {
                min = mid;
            }else {
                max = mid;
            }
        }
        return min;
    }

    private static boolean valid(int[] nums, int k, double mid) {
        int n = nums.length;

        double pre_min = 0;

        double[] sum = new double[n+1];
        sum[0] = 0;

        for(int i = 1; i <= n; i++) {
            sum[i] = sum[i-1] + nums[i-1] - mid;
            if(i>=k && sum[i] - pre_min >= 0) {
                return true;
            }

            if(i >= k) {
                pre_min = Math.min(pre_min, sum[i-k+1]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 12, -5, -6, 50, 3};
        int[] nums = {-1, 0 , 1};
        int k = 3;
        System.out.println(maxAverage(nums, k));
    }
}
