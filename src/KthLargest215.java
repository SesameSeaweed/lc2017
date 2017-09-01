import java.util.Arrays;

public class KthLargest215 {
    public static int findKthLargest(int[] nums, int k) {
        int[] out = binarySort(nums);
        return out[nums.length - k];
    }

    private static int[] mergeSort(int[] nums1, int[] nums2) {
        int[] out = new int[nums1.length+nums2.length];
        int index1 = 0;
        int index2 = 0;
        int i = 0;
        while(index1 < nums1.length && index2 < nums2.length){
            while(index1 < nums1.length && index2 < nums2.length && nums1[index1] > nums2[index2]) {
                out[i++] = nums2[index2++];
            }
            while(index1 < nums1.length && index2 < nums2.length && nums1[index1] <= nums2[index2]) {
                out[i++] = nums1[index1++];
            }
        }
        while(index1 < nums1.length) {
            out[i++] = nums1[index1++];
        }
        while(index2 < nums2.length) {
            out[i++] = nums2[index2++];
        }
        return out;
    }

    private static int[] binarySort(int[] nums) {
        if(nums.length <= 1) return nums;

        int mid = nums.length/2;

        int[] nums1 = Arrays.copyOfRange(nums, 0, mid);
        int[] nums2 = Arrays.copyOfRange(nums, mid, nums.length);
        int[] out = mergeSort(binarySort(nums1), binarySort(nums2));
        return out;
    }
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 3;
        System.out.print(findKthLargest(nums, k));
    }
}
