public class Excel168 {
    public static String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder("");
        while(n >= 1) {
            int temp = n % 26;
            if(temp == 0) temp = 26;
            sb.append((char) (temp - 1 +'A'));
            n = n / 26;
            if(temp == 26) {
                n = n -1;
            }
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        int n = 27;
        System.out.print(convertToTitle(n));
    }
}
