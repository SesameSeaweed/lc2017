import java.util.Map;
import java.util.HashMap;

public class SingleNumber137 {
    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
        	if(map.containsKey(num)) {
        		map.put(num, 1+map.get(num));
        	}else {
        		map.put(num, 1);
        	}
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
        	if(entry.getValue() != 3) return entry.getKey();
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
    	int[] nums = {1,1,1,2,2,2,3};
    	System.out.println(singleNumber(nums));
    }
}