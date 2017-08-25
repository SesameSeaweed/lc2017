public class ConvertNumberToHex405 {
    public static String toHex(int num) {
        long n = num & 0x00000000ffffffffL;
        char[] map = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.insert(0, map[(int) (n % 16)]);
            n = n / 16;
        }
        return num == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        int num = 26;
        System.out.print(toHex(num));
    }
}
