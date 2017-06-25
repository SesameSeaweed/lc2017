public class Stock121 {
    public static int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) return 0;
        int minSoFar = prices[0];
        int out = 0;

        for(int i = 1; i < prices.length; i++) {
        	minSoFar = Math.min(minSoFar, prices[i-1]);
        	out = Math.max(prices[i]-minSoFar, out);
        }
        return out;
    }

    public static void main(String[] args) {
    	int[] prices = {7,1,5,3,6,4};
    	System.out.println(maxProfit(prices));
    }
}