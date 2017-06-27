import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class ContainsDup220 {
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
    	if(k < 1 || t < 0) return false;
       SortedSet<Long> set = new TreeSet<>();

       for(int i = 0; i < nums.length; i++) {
  
        SortedSet<Long> range = set.subSet((long)nums[i]-t,  (long) nums[i]+t+1);
        if(!range.isEmpty()) return true;
        if(i >= k) set.remove((long) nums[i-k]);
        set.add((long) nums[i]);
       }
       return false;
    }

    public static void main(String[] args) {
    	int[] nums = {1,2,3,4,5,6,7};
    	int k = 1;
    	int t = 2;
    	System.out.println(containsNearbyAlmostDuplicate(nums, k, t));
    }
}