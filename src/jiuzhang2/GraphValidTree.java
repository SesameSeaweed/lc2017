package jiuzhang2;

public class GraphValidTree {
    public static boolean validTree(int n, int[][] edges) {

        if (n - 1 != edges.length) {
            return false;
        }
        Union u = new Union(n);

        for(int i = 0; i < edges.length; i++) {
            if(u.compress_find(edges[i][0]) == u.compress_find(edges[i][1])) return false;
            u.union_nodes(edges[i][0], edges[i][1]);
        }

        return true;
    }

    private static class Union {
        int[] father = null;

        Union(int n) {
            father = new int[n];
            for(int i = 0; i < n; i++) {
                father[i] = i;
            }
        }

        public int compress_find(int x) {
            int parent = father[x];
            while(parent != father[parent]) {
                parent = father[parent];
            }

            int fa = father[x];
            int temp = fa;
            while(fa != father[fa]) {
                temp = father[fa];
                father[fa] = parent;
                fa = temp;
            }
            return parent;
        }

        public void union_nodes(int x, int y) {
            int node_x = compress_find(x);
            int node_y = compress_find(y);
            if(node_x != node_y) {
                father[node_x] = node_y;
            }
        }
    }


    public static void main(String[] args) {
        int n = 2;
        int[][] edges = {};
//        int[][] edges = {{1,0}, {0,2}, {0,3}, {1,4}};
//        int[][] edges = {{0,1}, {1,2}, {2,3}, {1,3}, {1,4}};
        System.out.println(validTree(n, edges));
    }
}
