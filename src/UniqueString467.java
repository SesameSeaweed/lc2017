public class UniqueString467 {
    public static int findSubstringInWraproundString(String p) {
        int[] count = new int[26];
        int curMax = 0;
        int sum = 0;

        for(int i = 0; i < p.length(); i++) {
        	char c = p.charAt(i);
        	if(i > 0 && (c - p.charAt(i-1) == 1 || p.charAt(i-1) -c == 25)) {
        		curMax++;
        		
        	}else {
        		curMax = 1;
        		
        	}
        	count[c-'a'] = Math.max(count[c-'a'], curMax);
        }
        for(int i = 0; i < 26; i++) {
        	sum += count[i];
        }
        return sum;	
    }

    public static void main(String[] args) {
    	String p = "zab";
    	System.out.println(findSubstringInWraproundString(p));
    }
}