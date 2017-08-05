package google;

public class MagicalString481 {
    public static int magicalString(int n) {
        StringBuilder sb = new StringBuilder("122");

        int index = 2;
        while(sb.length() <= n) {
            int length = sb.length() - 1;
            if(sb.charAt(index++) == '2') {
                if(sb.charAt(length) == '2') {
                    sb.append("11");
                }else {
                    sb.append("22");
                }
            }else {
                if(sb.charAt(length) == '2') {
                    sb.append("1");
                }else {
                    sb.append('2');
                }
            }
        }
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(sb.charAt(i) == '1') count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.print(magicalString(15));
    }
}
