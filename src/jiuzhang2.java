public class jiuzhang2 {
    public static double sqrt(double x) {
        // write your code here
        double eps = 1e-8;
        double start = 0    ;
        double end = x;

        if(x < 1.0) {
            end = 1.0;
        }

        while(end - start > eps) {
            double mid = (end - start) / 2 + start;
            if(mid * mid > x) {
                end = mid;
            }else {
                start = mid;
            }
        }

        if(end * end <= x) return end;
        return start;
    }

    public static void main(String[] args) {
        double x = 0.01;
        System.out.println(sqrt(x));
    }
}
