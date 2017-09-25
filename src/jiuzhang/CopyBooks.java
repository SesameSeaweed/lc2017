package jiuzhang;

public class CopyBooks {
    public static int copyBooks(int[] pages, int k) {
        // write your code

        int max = 0;
        int total = 0;

        for(int i = 0; i < pages.length; i++) {
            max = Math.max(max, pages[i]);
            total += pages[i];
        }

        int start = max;
        int end = total;

        while(start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if(count(pages, mid) > k) {
                start = mid;
            }else {
               end = mid;
            }
        }
        if(count(pages, start) <= k) return start;
        return end;
    }

    private static int count(int[] pages, int limit) {
        if(pages.length == 0) return 0;
        int count = 1;
        int sum = pages[0];

        for(int i = 1; i < pages.length; i++) {
            if(sum + pages[i] > limit) {
                count++;
                sum = 0;
            }
            sum += pages[i];
        }
        return count;
    }

    public static void main(String[] args) {
        int[] pages = {3,2,4};
        System.out.println(copyBooks(pages, 2));
    }
}
