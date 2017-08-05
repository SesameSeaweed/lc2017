package google;

public class FindPeekElement162 {
    public static int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length-1;

        while(low < high)
        {
            int mid1 = (high - low)/2 + low;
            int mid2 = mid1+1;
            if(nums[mid1] < nums[mid2])
                low = mid2;
            else
                high = mid1;
        }
        return low;
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.print(findPeakElement(nums));
    }
}
