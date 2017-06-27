public class MaxRectangle85 {
    public static int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;

        int[] left = new int[n];
        int[] right = new int[n];
        int[] height = new int[n];
        int max = 0;

        for(int i = 0; i < n; i++) {
        	right[i] = n;
        }

        for(int i = 0; i < m; i++) {
        	int cur_left = 0;
        	int cur_right = n;
        	for(int j = 0; j < n; j++) {
        		if(matrix[i][j] == '1') {
        			height[j] = height[j]++;
        		}else {
        			height[j] = 0;
        		}
        	}

        	for(int j = n-1; j >= 0; j--) {
        		if(matrix[i][j] == '1') {
        			left[j] = Math.max(cur_left, left[j]);
        		}else {
        			cur_left = i+1;
        			left[j] = 0;
        		}
        	}
        	for(int j = 0; j < n; j++) {
        		if(matrix[i][j] == '1') {
        			right[j] = Math.max(cur_right, right[j]);
        		}else {
        			cur_right = j;
        			right[j] = n;
        		}
        	}

        	for(int j = 0; j < n; j++) {
        		int square = (right[j] - left[j]) * height[j];
        		max = Math.max(max, square);
        	}
        }
        return max;
    }

    public static void main(String[] args) {
    	char[][] matrix = {{'1', '0', '1', '0', '0'}, {'1', '1', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '1', '1', '1', '0'}};
    	System.out.println(maximalRectangle(matrix));
    }
}