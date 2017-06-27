public class Stock123 {
    public static int maxProfit(int[] prices) {
    	int globalMax = 0;
    	if(prices == null || prices.length < 2) return 0;
    	int m = prices.length;

    	for(int i = 2; i < prices.length; i++) {
    		int temp = helper(prices, 0, i) + helper(prices, i, m);
    		globalMax = Math.max(globalMax, temp);
    	}

    	return Math.max(globalMax, helper(prices, 0, m));
    }

    public static int helper(int[] prices, int start, int end) {
    	int curMax = 0;
    	int curMin = prices[start];
    	int[][] dp = new int[10][10];

    	for(int i = start; i < end; i++) {
    		curMax = Math.max(curMax, prices[i] - curMin);
    		curMin = Math.min(curMin, prices[i]);
    	}
    	return curMax;
    }

    public static void main(String[] args) {
    	 int[] prices = {1,2,4};

    	System.out.println(maxProfit(prices));
    }
}