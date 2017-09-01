public class NonDecreasingArray665 {
    public static boolean checkPossibility(int[] nums) {
        int cnt = 0;
        for(int i = 1; i < nums.length && cnt<=1 ; i++){
            if(nums[i-1] > nums[i]){
                cnt++;
                if(i-2<0 || nums[i-2] <= nums[i])nums[i-1] = nums[i];
                else nums[i] = nums[i-1];
            }
        }
        return cnt<=1;
    }

    public static void main(String[] args) {
//        int[] nums = {4,2,3};
//        int[] nums = {1,5,4,6,7,10,8,9};
        int[] nums = {1,2,4,5,3};
        System.out.println(checkPossibility(nums));
    }
}
