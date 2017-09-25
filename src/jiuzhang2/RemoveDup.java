package jiuzhang2;

public class RemoveDup {
    public static int removeDuplicates(int[] nums) {
        // write your code here
        int size = 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[size] != nums[i]) {
                nums[++size] = nums[i];
            }
        }
        return size;
    }


    public static void main(String[] args) {
        int[] nums = {1,1,2,2,3};
        System.out.println(removeDuplicates(nums));
    }
}
