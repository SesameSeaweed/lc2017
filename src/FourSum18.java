import java.util.*;

public class FourSum18 {
    public static List<List<Integer>> fourSum1(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> out = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            List<int[]> indexes = threeSum(nums, target - nums[i]);
            if(indexes != null && !indexes.isEmpty()) {
                for(int[] index : indexes) {
                    if(i != index[0] && i != index[1] && i != index[2]) {
                        List<Integer> tmp = Arrays.asList(nums[i], nums[index[0]], nums[index[1]], nums[index[2]]);
                        tmp.sort((a,b)->(a-b));
                        if(!out.contains(tmp)) out.add(tmp);
                    }
                }
            }
        }
        return out;
    }

    private static List<int[]> twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        List<int[]> out = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                out.add(new int[] {map.get(target - nums[i]), i});
            }else {
                map.put(nums[i], i);
            }
        }
        return out;
    }

    private static List<int[]> threeSum(int[] nums, int target) {
        List<int[]> out = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            List<int[]> indexes = twoSum(nums, target - nums[i]);
            if(indexes != null && !indexes.isEmpty()) {
                for(int[] index : indexes) {
                    if(i != index[0] && i != index[1]) {
                        out.add(new int[] {i, index[0], index[1]});
                    }
                }
            }
        }
        return out;
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> out = new ArrayList<>();

        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 3; i++) {
            if(i!=0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1; j < nums.length - 2; j++) {
                if(j != i+1 && nums[j] == nums[j-1]) continue;
                int left = j+1;
                int right = nums.length - 1;

                while(left < right) {
                    int sum = nums[i]+nums[j]+nums[left]+nums[right];
                    if(sum > target) {
                        right--;
                    }else if(sum < target) {
                        left++;
                    }else {
                        List<Integer> tmp = Arrays.asList(nums[i], nums[j], nums[left],nums[right]);
                        out.add(tmp);
                        left++;
                        right--;while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }

                    }
                }
            }
        }
        return out;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
//        int[] nums = {-497,-494,-484,-477,-453,-453,-444,-442,-428,-420,-401,-393,-392,-381,-357,-357,-327,-323,-306,-285,-284,-263,-262,-254,-243,-234,-208,-170,-166,-162,-158,-136,-133,-130,-119,-114,-101,-100,-86,-66,-65,-6,1,3,4,11,69,77,78,107,108,108,121,123,136,137,151,153,155,166,170,175,179,211,230,251,255,266,288,306,308,310,314,321,322,331,333,334,347,349,356,357,360,361,361,367,375,378,387,387,408,414,421,435,439,440,441,470,492};
        List<List<Integer>> out = fourSum(nums, 0);
        System.out.print(out);
    }
}
