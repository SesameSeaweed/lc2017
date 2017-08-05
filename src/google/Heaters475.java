package google;

import java.util.Arrays;

public class Heaters475 {

    public static int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int i = 0;
        int j = 0;

        int out = 0;
        for(; i < houses.length; i++) {
            while(j < heaters.length - 1 && Math.abs(heaters[j] - houses[i]) >= Math.abs(heaters[j+1] - houses[i])) {
                j++;
            }
            out = Math.max(out, Math.abs(heaters[j] - houses[i]));
        }
        return out;
    }

    public static void main(String[] args) {
        int[] houses = {1,2,3,4};
        int[] heaters = {1,4};
        System.out.println(findRadius(houses, heaters));
    }
}
