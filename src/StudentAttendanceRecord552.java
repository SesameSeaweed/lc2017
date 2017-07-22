import java.util.ArrayList;
import java.util.List;

public class StudentAttendanceRecord552 {
    public static int checkRecord1(int n) {
        char[] set = {'A', 'L', 'P'};
        List<List<StringBuilder>> out = new ArrayList<>();
        List<StringBuilder> path = new ArrayList<>();
        path.add(new StringBuilder());
        out.add(0, path);
        for(int i = 1; i <= n; i++) {
            List<StringBuilder> prev = out.get(i-1);
            List<StringBuilder> curr = new ArrayList<>();
            for(StringBuilder str : prev) {
                for(char c : set) {
                    StringBuilder tmp = new StringBuilder();
                    tmp.append(str).append(c);
                    if(tmp.indexOf("A") != tmp.lastIndexOf("A") || tmp.indexOf("LLL") >= 0) {
                        tmp.deleteCharAt(tmp.length()-1);
                        continue;
                    }
                    curr.add(tmp);
                }
            }
            out.add(i, curr);
        }
        return out.get(n).size();
    }

    public static int checkRecord(int n) {
        if(n == 1) return 3;
        if(n == 2) return 8;
        int[] p = new int[n+1];
        int[] l = new int[n+1];
        int[] a = new int[n+1];
        long modVal = 1000000007;

        p[0] = l[0] = a[0] = 0;
        p[1] = l[1] = a[1] = 1;
        p[2] = 3;
        l[2] = 3;
        a[2] = 2;


        for(int i = 3; i <= n; i++) {
            a[i] = a[i-1]+a[i-2]+a[i-3];
            p[i] = a[i-1]+l[i-1]+p[i-1];
            l[i] = a[i-2]+p[i-2]+a[i-1]+p[i-2];
            a[i] %= modVal;
            p[i] %= modVal;
            l[i] %= modVal;
        }
        return (int) ((a[n]+p[n]+l[n])% (long) modVal);
    }
    public static void main(String[] args) {
        System.out.println(checkRecord(3));
    }

}
