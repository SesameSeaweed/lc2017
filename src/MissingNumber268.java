public class MissingNumber268 {
    public static int missingNumber(int[] nums) {
        int sum = 0;
        for(int num: nums)
            sum += num;

        return ( (nums.length * (nums.length + 1) ) - 2 * sum ) / 2;

    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,4};
        System.out.print(missingNumber(nums));
    }
}
