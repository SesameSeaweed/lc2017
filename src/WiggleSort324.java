import java.util.Arrays;

public class WiggleSort324 {
    public static void wiggleSort(int[] nums) {
        sort(nums);
        int[] out = new int[nums.length];
        int mid = (nums.length+1)/2;
        int count = 0;
        int start = 0;
        if(mid - 1 > 0 && nums[mid - 1] == nums[mid] && nums.length % 2 == 0) {
            out[0] = nums[mid];
            start = 1;
            mid++;
        }
        for(int i = start; i < nums.length; i++) {
            out[i] = nums[count];
            if(i < nums.length - 1) out[++i] = nums[count+mid];
            count++;
        }
        if(out[0] > out[1]) {
           for(int i = 0; i < nums.length; i++) {
               nums[i] = out[nums.length-1 - i];
           }
        }else {
            for(int i = 0; i < nums.length; i++) {
                nums[i]= out[i];
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    private static void sort(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j < nums.length; j++) {
                if(nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 1, 1, 6, 4};
        wiggleSort(nums);
    }
}
