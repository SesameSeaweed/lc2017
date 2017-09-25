package jiuzhang;

public class WoodCut {
    public static int woodCut(int[] L, int k) {
        int longest = 0;

        for(int i = 0; i < L.length; i++) {
            longest = Math.max(longest, L[i]);
        }

        int start = 1;
        int end = longest;

        while(start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if(count(L, mid) < k) {
                end = mid;
            }else {
                start = mid;
            }
        }

        if(count(L, end) >= k) return end;
        if(count(L, start) >= k) return start;
        return 0;
    }

    private static int count(int[] L, int length) {
        int sum = 0;

        for(int i = 0; i < L.length; i++) {
            sum += L[i]/length;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] L = {232, 124, 456};
        System.out.println(woodCut(L, 7));
    }
}
