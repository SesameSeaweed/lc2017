public class WiggleSubsequence376 {
//    public static int wiggleMaxLength(int[] nums) {
//        int[] p = new int[nums.length];
//        int[] q = new int[nums.length];
//        p[0] = 1;
//        q[0] = 1;
//
//        for(int i = 1; i< nums.length; i++) {
//            for(int j = 0; j < i; j++) {
//                if(nums[i] > nums[j]) {
//                    p[i] = Math.max(p[i], q[j] +1);
//                }if(nums[i] < nums[j]) {
//                    q[i] = Math.max(q[i], p[j] + 1);
//                } else {
//                    p[i] = Math.max(p[i], p[i-1]);
//                    q[i] = Math.max(q[i-1], q[i]);
//                }
//            }
//
//        }
//        return Math.max(p[nums.length-1],q[nums.length-1]);
//    }

    public static int wiggleMaxLength(int[] nums) {
        int p = 1;
        int q = 1;

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i-1]) {
                p = q+1;
            }else {
                if(nums[i] < nums[i-1]) {
                    q = p+1;
                }
            }
        }
        return Math.max(p,q);
    }

    public static void main(String[] args) {
        int[] nums = {1,17,5,10,13,15,10,5,16,8};
        System.out.print(wiggleMaxLength(nums));
    }
}
