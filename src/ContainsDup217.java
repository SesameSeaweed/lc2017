import java.util.Set;
import java.util.HashSet;

public class ContainsDup217 {
    private static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
        	if(set.contains(num)) return true;
        	else {
        		set.add(num);
        	}
        }
        return false;
    }

    public static void main(String[] args) {
    	int[] nums = {1,2,3,4,5,1};
    	System.out.println(containsDuplicate(nums));
    }
}