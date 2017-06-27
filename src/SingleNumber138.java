import java.util.Map;
import java.util.HashMap;

public class SingleNumber138 {
    public static int[] singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] out = new int[2];

        for(int num : nums) {
        	if(map.containsKey(num)) {
        		map.put(num, 1+map.get(num));
        	}else {
        		map.put(num, 1);
        	}
        }
        int i = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
        	if(entry.getValue() != 2) {
        		out[i++] = entry.getKey();
        	}
        }
        for(int j = 0; j < out.length; j++) {
        	System.out.println(out[j]);
        }
        return out;
    }

    public static void main(String[] args) {
		int[] nums = {1,1,2,2,3,4};
    	singleNumber(nums);
    }
}