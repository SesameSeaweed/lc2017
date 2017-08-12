package google2;

public class PoorPigs458 {
    public static int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int out = 0;
        while(Math.pow(minutesToTest/minutesToDie + 1, out) < buckets) {
            out++;
        }
        return out;
    }

    public static void main(String[] args) {
        int buckets = 1000;
        int minutesToDie = 15;
        int minutesToTest = 60;
        System.out.print(poorPigs(buckets, minutesToDie, minutesToTest));
    }
}
