package google;

import java.util.*;

public class FindMinTree310 {
    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1) return Collections.singletonList(0);
        List<Integer> leaves = new ArrayList<>();
        List<Set<Integer>> adj = new ArrayList<>();
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
                leaves.add(i);
            }
        }

        while(n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for(Integer u : leaves) {
                int v = adj.get(u).iterator().next();
                adj.get(v).remove(u);
                if(adj.get(v).size() == 1) newLeaves.add(v);
            }
            leaves = newLeaves;
        }
        return leaves;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] edge = {{1,0}, {1,2}, {1,3}};
        List<Integer> head = findMinHeightTrees(n, edge);
        System.out.print(head);
    }
}
