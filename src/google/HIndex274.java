package google;

public class HIndex274 {
    public static int hIndex(int[] citations) {
        int[] bucket = new int[citations.length+1];

        for(int i = 0; i < citations.length; i++) {
            if(citations[i] == 0) continue;
            for(int j = 0; j<= citations.length && j <= citations[i]; j++) {
                bucket[j]++;
            }
        }

        for(int i = citations.length; i >= 1 ; i--) {
            if(bucket[i] >= i) return i;
        }
        return 0;
    }

    public static void main(String[] args) {
//        int[] citations = {3, 0, 6, 1, 5};
        int[] citations = {0};
        System.out.print(hIndex(citations));
    }
}
