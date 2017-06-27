public class ValidPerfectSquare367 {
    public static boolean isPerfectSquare(int num) {
        if(num < 0) return false;
        if(num == 0 || num == 1) return true;
        int i = 1;
        while((long) i * i < (long) num) {
        	i++;
        }
        if((long) i * i == (long) num) return true;
        return false;
    }

    public static void main(String[] args) {
    	int num = 2147483647;
    	System.out.println(isPerfectSquare(num));
    }
}