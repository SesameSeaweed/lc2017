public class AddStrings415 {
    public static String addStrings(String num1, String num2) {
    
    	if(num2.length() > num1.length()) return helper(num2, num1);
    	return helper(num1, num2);
        
    }

    public static String helper(String num1, String num2) {
    	int m = num1.length() - 1;
        int n = num2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();

        while(m >= 0 && n >= 0) {
        	int temp = num2.charAt(n--) - '0' + num1.charAt(m--) - '0' + carry;
        	sb.append(temp % 10);
        	carry = temp / 10;
        }

        while(m >= 0) {
        	int temp = num1.charAt(m--) - '0' + carry;
        	sb.append(temp % 10);
        	carry = temp / 10;
        }
        if(carry == 1) return sb.append(1).reverse().toString();
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
    	String num1 = "1111";
    	String num2 = "999";
    	System.out.println(addStrings(num1, num2));
    }
}