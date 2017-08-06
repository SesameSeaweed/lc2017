package google2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class QueueReconstruction406 {
    public static int[][] reconstructQueue(int[][] people) {
        int[][] out = new int[people.length][];

        int m = people.length;
        int n = people[0].length;

        Arrays.sort(people, new Comparator<int[]>() {
            @Override public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) return o1[1] - o2[1];
                return o2[0] - o1[0];
            }
        });

        ArrayList<int[]> list = new ArrayList<>(m);
        for(int[] p : people) {
            list.add(p[1], p);
        }
        return list.toArray(new int[m][n]);
    }

    public static void main(String[] args) {
        int[][] people = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        int[][] out = reconstructQueue(people);
        System.out.print(Arrays.deepToString(out));
    }
}
