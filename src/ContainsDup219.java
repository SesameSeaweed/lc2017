import java.util.Map;
import java.util.HashMap;

public class ContainsDup219 {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
    	if(k <= 0) return false;

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
        	if(map.containsKey(nums[i])) {
        		if(i - map.get(nums[i]) <= k) return true;
        	}
        	map.put(nums[i], i);
        }
        return false;
    }

    public static void main(String[] args) {
    	int[] nums = {1,2,3,4,5,6,7,1,8,9,1};
    	System.out.println(containsNearbyDuplicate(nums, 1));
    }
}