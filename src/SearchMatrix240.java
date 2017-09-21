public class SearchMatrix240 {

    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;

        if(target < matrix[0][0]) return false;

        int m = matrix.length;
        int n = matrix[0].length;

        for(int[] row : matrix) {
            if(row[0] > target) return false;
            if(row[n - 1] < target) continue;

            int start = 0;
            int end = n-1;
            while(start <= end) {
                int mid = (end - start) / 2 + start;
                if(row[mid] == target) return true;
                else {
                    if(row[mid] < target) {
                        start = mid+1;
                    }else {
                        end = mid-1;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,4,7,11,15}, {2,5,8,12,19}, {3,6,9,16,22}, {10,13,14,17,24}, {18,21,23,26,30}};
        System.out.print(searchMatrix(matrix, 20));
    }
}
