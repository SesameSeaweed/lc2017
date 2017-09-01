import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrickWall554 {
    public static int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = wall.size();
        for(List<Integer> brick : wall) {
            int sum = 0;
            for(int i = 0; i < brick.size()-1; i++) {
                sum += brick.get(i);
                if(map.containsKey(sum)) {
                    map.put(sum, map.get(sum) + 1);
                }else {
                    map.put(sum, 1);
                }
            }
        }

        int out = Integer.MAX_VALUE;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            out = Math.min(out, n - entry.getValue());
        }
        return out;
    }

    public static void main(String[] args) {
            List<List<Integer>> wall = Arrays.asList(Arrays.asList(1,2,2,1),
                    Arrays.asList(3,1,2),
                    Arrays.asList(1,3,2),
                    Arrays.asList(2,4),
                    Arrays.asList(3,1,2),
                    Arrays.asList(1,3,1,1)
                    );

//        List<List<Integer>> wall = Arrays.asList(Arrays.asList(1,1),
//                Arrays.asList(2),
//                Arrays.asList(1,1));
        System.out.print(leastBricks(wall));
    }

}
