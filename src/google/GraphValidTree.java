package google;

import java.util.HashMap;
import java.util.Map;

public class GraphValidTree {
    private static class UnionFind {
        Map<Integer, Integer> father = new HashMap<>();

        UnionFind(int n) {
            for(int i = 0; i < n; i++) {
                father.put(i, i);
            }
        }

        public int compressed_find(int x) {
            int parent = father.get(x);
            while(parent != father.get(parent)) {
                parent = father.get(parent);
            }

            int pa = father.get(x);
            int temp = pa;
            // update all the parent of pa to have parent as father
            while(pa != father.get(pa)) {
                temp = father.get(pa);
                father.put(pa, parent);
                pa = temp;
            }
            return parent;
        }

        public void union(int x, int y) {
            int fa_x = compressed_find(x);
            int fa_y = compressed_find(y);
            if(fa_x != fa_y) {
                father.put(fa_x, fa_y);
            }
        }
    }

    public static boolean validTree(int n, int[][] edges) {
        if(n - 1 != edges.length) return false;
         UnionFind uf = new UnionFind(n);

        for(int i = 0; i < n; i++) {
            if(uf.compressed_find(edges[i][0]) == uf.compressed_find(edges[i][1])) {
                return false;
            }
            uf.union(edges[i][0], edges[i][1]);
        }
        return true;
    }
}
