package google2;

public class PatchingArrays330 {
    public static int minPatches(int[] nums, int n) {
        long miss = 1l;
        int i = 0;
        int out = 0;
        while(miss <= n) {
            if(i >= nums.length || miss < nums[i] ) {
                out++;
                miss = miss+miss;
            }else {
                miss += nums[i++];

            }
        }
        return out;
    }

    public static void main(String[] args) {
        int[] nums = {};
        System.out.print(minPatches(nums,20));
    }
}
