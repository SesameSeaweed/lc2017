public class Stock122 {
    public static int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) return 0;
        int out = 0;

        for(int i = 1; i < prices.length; i++) {
        	out += Math.max((prices[i] - prices[i-1]), 0);
        }
        return out;
    }

    public static void main(String[] args) {
    	int[] prices = {7,1,5,3,4,6};
    	System.out.println(maxProfit(prices));
    }
}