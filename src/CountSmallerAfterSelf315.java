import java.util.ArrayList;
import java.util.List;

public class CountSmallerAfterSelf315 {
    public static List<Integer> countSmaller(int[] nums) {
        List<Integer> sorted = new ArrayList<>();
        List<Integer> out = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            out.add(0);
        }

        for(int i = nums.length-1; i >= 0; i--) {
            int index = findIndex(nums, sorted, i);
            out.set(i, index);
        }

       return out;
    }

    private static int findIndex(int[] nums, List<Integer> sorted, int index) {
        int sortedLength = sorted.size();
        if(sortedLength == 0) {
            sorted.add(index);
            return 0;
        }
        if(nums[sorted.get(sortedLength-1)] < nums[index]) {
            sorted.add(index);
            return sortedLength;
        }
        int start = 0;
        int end = sortedLength-1;
        while(start <= end) {
            int mid = start+(end-start)/2;
            if(nums[sorted.get(mid)] < nums[index]) {
                start=mid+1;
            }else{
                if(nums[sorted.get(mid)] > nums[index]) {
                    end = mid-1;
                }else {
                    sorted.add(mid, index);
                    return mid;
                }
            }
        }
        sorted.add(start,index);
        return start;

    }

    public static void main(String[] args) {
        int[] nums = {5,2,3,6,1};
        List<Integer> out = countSmaller(nums);
        System.out.println(out);
    }
}
