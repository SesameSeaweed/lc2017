public class FindMinInSortedArray154 {
    public static int findMin(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int start = 0;
        int end = nums.length - 1;

        while(start < end) {
            int mid = (end - start) / 2 + end;
            if(mid - 1>=start && mid+1 <=end) {
                if(nums[mid-1] < nums[mid] && nums[mid] < nums[mid+1]) {
                    end = mid;
                }else {
                    if(nums[mid-1] > nums[mid] && nums[mid] > nums[mid+1]) {
                        start = mid;
                    }else {
                        if(nums[mid-1] >= nums[mid] && nums[mid+1] >= nums[mid]) {
                            return nums[mid];
                        }
                    }
                }
            }
            if(nums[start] < nums[end]) {
                end--;
            }else {
                start++;
            }
        }
        return Math.min(nums[start], nums[end]);
    }

    public static void main(String[] args) {

    }
}
