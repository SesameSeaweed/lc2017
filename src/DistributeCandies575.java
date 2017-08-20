import java.util.HashSet;
import java.util.Set;

public class DistributeCandies575 {
    public static int distributeCandies(int[] candies) {
        Set<Integer> set = new HashSet<>();

        for(int candy : candies) {
            set.add(candy);
        }

        return Math.min(candies.length/2, set.size());
    }

    public static void main(String[] args) {
        int[] candies = {1,1,1,1};
        System.out.print(distributeCandies(candies));
    }
}
