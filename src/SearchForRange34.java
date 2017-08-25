import java.util.Arrays;

public class SearchForRange34 {
    public static int[] searchRange(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int[] out = new int[2];
        out[0]=-1;
        out[1]=-1;

        while(start <= end) {
            int mid = (end - start) / 2 + start;
            if(nums[mid] == target) {
                while(mid > start && nums[mid-1] == nums[mid]) {
                    mid--;
                }
                out[0] = mid;

                while(mid < end && nums[mid] == nums[mid+1]) {
                    mid++;
                }
                out[1] = mid;
                break;
            }else {
                if(nums[mid] < target) {
                    start = mid + 1;
                }else {
                    end = mid - 1;
                }
            }
        }
        return out;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] out = searchRange(nums, target);
        System.out.print(Arrays.toString(out));
    }
}
