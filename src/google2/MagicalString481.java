package google2;

public class MagicalString481 {
    public static int magicalString(int n) {
        StringBuilder sb = new StringBuilder("122");
        int index = 2;
        int count = 0;
        while(sb.length() <= n) {
            int len = sb.length() - 1;

            if(sb.charAt(index) == '2') {
                if(sb.charAt(len) == '1') {
                    sb.append("22");
                }else {
                    sb.append("11");
                }
            }else {
                if(sb.charAt(len) == '1') {
                    sb.append("2");
                }else {
                    sb.append("1");
                }
            }
            index++;
        }

        for(int i = 0; i < n; i++) {
            if(sb.charAt(i) == '1') count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 6;
        System.out.print(magicalString(n));
    }

}
