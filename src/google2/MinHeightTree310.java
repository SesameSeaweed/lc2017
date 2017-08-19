package google2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MinHeightTree310 {
    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
       List<Set<Integer>> adj = new ArrayList<>();
        List<Integer> leave = new ArrayList<>();
       for(int i = 0; i < n; i++) {
           adj.add(new HashSet<>());
       }

       for(int[] edge : edges) {
           int u = edge[0];
           int v = edge[1];
           adj.get(u).add(v);
           adj.get(v).add(u);
       }

       for(int i = 0; i < n; i++) {
           if(adj.get(i).size() == 1) {
               leave.add(i);
           }
       }

       while(n > 2) {
           n -= leave.size();
           List<Integer> newLeave = new ArrayList<>();
           for(int u : leave) {
               int v = adj.get(u).iterator().next();
               adj.get(v).remove(u);
               if(adj.get(v).size() == 1) newLeave.add(v);
           }
           leave = newLeave;
       }
       return leave;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] edges = {{1, 0}, {1, 2}, {1, 3}};
        List<Integer> leaves = findMinHeightTrees(n, edges);
        System.out.print(leaves);
    }
}
