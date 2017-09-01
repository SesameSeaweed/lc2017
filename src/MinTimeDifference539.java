import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MinTimeDifference539 {
    public static int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints, new Comparator<String>() {
            @Override public int compare(String o1, String o2) {
                if(o1.substring(0,2).compareTo(o2.substring(0,2)) == 0) return o1.substring(3,5).compareTo(o2.substring(3,5));
                return o1.substring(0,2).compareTo(o2.substring(0,2));
            }
        });

        int min = 24*60-1;
        for(int i = 1; i < timePoints.size(); i++) {
            String o1 = timePoints.get(i-1);
            String o2 = timePoints.get(i);
            int hour1 = Integer.parseInt(o1.substring(0,2));
            int hour2 = Integer.parseInt(o2.substring(0,2));
            int min1 = Integer.parseInt(o1.substring(3,5));
            int min2 = Integer.parseInt(o2.substring(3,5));
            int temp = (hour2 - hour1) * 60 + (min2 - min1);
            min = Math.min(min, temp);
        }
        String o1 = timePoints.get(0);
        String o2 = timePoints.get(timePoints.size()-1);
        int hour1 = Integer.parseInt(o1.substring(0,2));
        int hour2 = Integer.parseInt(o2.substring(0,2));
        int min1 = Integer.parseInt(o1.substring(3,5));
        int min2 = Integer.parseInt(o2.substring(3,5));
        int temp = (23-hour2) * 60 + (60 - min2) + hour1*60 + min1;
        return  Math.min(min, temp);
    }

    public static void main(String[] args) {
        List<String> timePoints = Arrays.asList("00:00", "22:59", "21:48");
        System.out.print(findMinDifference(timePoints));
    }
}
