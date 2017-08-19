package google2;

import java.util.Arrays;

public class Heaters475 {
//    public static int findRadius(int[] houses, int[] heaters) {
//        int max = Integer.MIN_VALUE;
//        Arrays.sort(heaters);
//        for(int house : houses) {
//            int index = Arrays.binarySearch(heaters, house);
//            if(index < 0) index = - (index + 1);
//            int left = index-1 >= 0 ? house - heaters[index-1] : Integer.MAX_VALUE;
//            int right = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;
//            max = Math.max(max, Math.min(left,right));
//        }
//        return max;
//    }

    public static int findRadius(int[] houses, int[] heaters) {
        int max = Integer.MIN_VALUE;
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int j = 0;
        for(int i = 0; i < houses.length; i++) {
            while(j < heaters.length-1 && Math.abs(heaters[j] - houses[i]) >= Math.abs(heaters[j+1] - houses[i]))
                j++;
            max = Math.max(max, Math.abs(heaters[j]-houses[i]));
        }
        return max;
    }
    public static void main(String[] args) {
        int[] houses = {1,2,3};
        int[] heaters = {2};
        System.out.print(findRadius(houses, heaters));
    }
}
