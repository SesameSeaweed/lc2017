package google;

public class FindPeakElement162 {
    public static int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        return helper(nums, 0, nums.length-1);
    }

    private static int helper(int[] nums, int start, int end) {
        if(start == end) return start;

        int mid = (end - start) / 2 + start;

        if(nums[mid] > nums[mid +1]) {
            return helper(nums, start, mid);
        }else {
            return helper(nums, mid+1, end);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.print(findPeakElement(nums));
    }
}
