package jiuzhang;

public class KthSmallestInUnsortedArrays {
    public static int kthSmallest(int k, int[] nums) {
        // write your code here
        return quickSearch(nums, k-1, 0, nums.length-1);
    }

    public static int quickSearch(int[] nums, int k, int left, int right) {
        int start = left;
        int end = right;

        if(start == end) return nums[start];
        int mid = (end - start) /2 + start;
        int pivot = nums[mid];

        while(start <= end) {

            while(start <= end && nums[start] < pivot) {
                start++;
            }

            while(start <= end && nums[end] > pivot) {
                end--;
            }

            if(start <= end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }

        if(end >= k && end >= left) {
            quickSearch(nums, k, left, end);
        }else if(start <= k && right >= start)
            quickSearch(nums, k, start, right);
        return nums[k];
    }

    public static void main(String[] args) {
        int[] nums = {3,4,1,2,5};
        int k = 4;
        System.out.println(kthSmallest(k, nums));
    }
}
