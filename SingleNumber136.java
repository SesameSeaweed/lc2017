public class SingleNumber136 {
    public static int singleNumber(int[] nums) {
    	int out = 0;
        for(int num : nums) {
        	out ^= num;
        }
        return out;
    }

    public static void main(String[] args) {
    	int[] nums = {1,1,2,2,3,3,4};
    	System.out.println(singleNumber(nums));
    }
}