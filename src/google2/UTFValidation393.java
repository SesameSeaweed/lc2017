package google2;

public class UTFValidation393 {
    public static boolean validUtf8(int[] data) {
        String[] dataSet = new String[data.length];

        for(int i = 0; i < dataSet.length; i++) {
            dataSet[i] = Integer.toBinaryString(data[i]);
            int zero = 8 - dataSet[i].length();
            StringBuilder sb = new StringBuilder("");
            while(zero-- > 0) {
                sb.append("0");
            }
            dataSet[i] = sb.append(dataSet[i]).toString();
        }

        int count = 0;

        for(int i = 0; i < dataSet[0].length(); i++) {
            if(dataSet[0].charAt(i) == '1') count++;
            else break;
        }

        if(data.length == 1) {
            if(dataSet[0].charAt(0) == '0') return true;
            else  return false;
        }

        int i = 1;
        while(i < dataSet.length) {
            if(dataSet[i].startsWith("10")) i++;
            else break;
        }

        if(i < count) return false;
        return true;
    }

    public static void main(String[] args) {
        int[] data = {240,162,138,147,145};
        System.out.print(validUtf8(data));
    }
}
