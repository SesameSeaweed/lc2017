public class CircularArrayLoop457 {
    public static boolean circularArrayLoop(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        int slow = 0;
        int fast = 0;
        int count = 0;

        while(count < nums.length) {
            count++;
            slow += nums[slow];
            int fastIndex = fast+nums[fast];
            if(fastIndex < 0) {
                fastIndex = nums.length + fastIndex;
            }
            fastIndex = fastIndex%nums.length;
            fast +=nums[fastIndex];
            if(slow < 0) slow = slow + nums.length;
            if(fast < 0) {
                fast = nums.length + fast;
            }
            slow = slow % nums.length;
            fast = fast % nums.length;
            if(fast == slow) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.print(circularArrayLoop(nums));
    }
}
