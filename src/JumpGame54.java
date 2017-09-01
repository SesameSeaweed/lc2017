
public class JumpGame54 {
//    public static int jump(int[] nums) {
//        int[] steps = new int[nums.length];
//        int[] where = new int[nums.length];
//
//        steps[0] = 0;
//        where[0] = -1;
//
//        for(int i = 1; i < nums.length; i++) {
//            steps[i] = Integer.MAX_VALUE;
//        }
//
//        for(int i = 1; i < nums.length; i++) {
//            for(int j = 0; j < i; j++) {
//                if(j+nums[j] >= i) {
//                    if(steps[j]+1 < steps[i]) {
//                        where[i] = j;
//                        steps[i] = steps[j]+1;
//                    }
//                }
//            }
//        }
//        return steps[nums.length-1];
//    }

    public static int jump(int[] nums) {
        int start = 0;
        int end = 0;
        int steps = 0;
        int far = nums[0];

        while(end < nums.length - 1) {
            steps++;
            far = end;
            for(int i = start; i <= end; i++) {
                if(nums[i]+i > far) {
                    far = nums[i] + i;
                }
            }
            start = end + 1;
            end = far;
        }
        return steps;
    }

    public static void main(String[] args) {
//        int[] nums = {2,3,1,1,2,4,2,0,1,1};
        int[] nums = {2,3,1,1,4};
        System.out.println(jump(nums));
    }
}
