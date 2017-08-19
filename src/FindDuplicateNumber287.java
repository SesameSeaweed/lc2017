public class FindDuplicateNumber287 {
    public static int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;

        while(true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast) break;
        }

        int t = 0;
        while(true) {
            slow = nums[slow];
            t=nums[t];
            if(slow == t) break;
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums= {1,3,4,2,1};
        System.out.print(findDuplicate(nums));
    }
}
