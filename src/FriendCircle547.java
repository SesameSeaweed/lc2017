import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class FriendCircle547 {
    public static int findCircleNum(int[][] M) {
        if(M == null || M.length == 0) return 0;

        int length = M.length;
        int out = 1;

        Set<Integer> foundSet = new HashSet<>();
        Stack<Integer> currSet = new Stack<>();

        currSet.push(0);
        foundSet.add(0);

        while(foundSet.size() < length) {
            while(!currSet.isEmpty()) {
                int i = currSet.pop();
                for(int j = 1; j < length; j++) {
                    if(i!=j && M[i][j] == 1) {
                        if(foundSet.add(j)) {
                            currSet.push(j);
                        }
                    }
                }
            }
            if(foundSet.size() == length) break;
            for(int i = 1; i < length; i++) {
                if(foundSet.add(i)) {
                    currSet.push(i);
                    out++;
                    break;
                }
            }
        }
        return out;
    }


    public static void main(String[] args) {
        int[][] M = {{1,0,0,1}, {0, 1,1,0}, {0,1,1,1}, {1,0,1,1}};
        System.out.print(findCircleNum(M));
    }
}

