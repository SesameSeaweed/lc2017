package jiuzhang;

import java.util.ArrayList;
import java.util.List;

public class NumberOfIslandII {
    private static class Point {
      int x;
      int y;
      Point() { x = 0; y = 0; }
      Point(int a, int b) { x = a; y = b; }
   }

   private static class UnionFind {
        int[] father = null;

        UnionFind(int n, int m) {
            father = new int[m * n + 1];
            for(int i = 0; i < father.length; i++) {
                father[i] = i;
            }
        }

        int find(int x) {
            if(x == father[x]) return x;
            return find(father[x]);
        }

        void union(int x, int y) {
            int node_x = find(x);
            int node_y = find(y);
            if(node_x != node_y) {
                father[node_x] = node_y;
            }
        }

        int compressFind(int x) {
            int parent = find(x);
            while(parent != find(parent)) {
                parent = find(parent);
            }

            int daddy = find(x);
            int temp = -1;

            while(daddy != find(daddy)) {
                temp = find(daddy);
                father[daddy] = find(daddy);
                daddy = temp;
            }
            return parent;
        }
   }

    public static List<Integer> numIslands2(int n, int m, Point[] operators) {
        // write your code here
        int[] flag = new int[n*m];
        int[][] dirs = {{0,1}, {1,0}, {-1,0}, {0,-1}};
        int[][] island = new int[n][m];
        int count = 0;

        List<Integer> out = new ArrayList<>();
        UnionFind uf = new UnionFind(n, m);

        for(Point point : operators) {
            int index = point.x * m + point.y;
            if( flag[index] != 1) {
                flag[index] = 1;
                count++;

                for(int[] dir : dirs) {
                    int x = point.x + dir[0];
                    int y = point.y + dir[1];
                    int newIndex = x * m + y;

                    if(x < 0 || y < 0 || x >= n || y >= m || flag[newIndex] == 0) continue;

                    int father_index = uf.compressFind(index);
                    int father_newIndex = uf.compressFind(newIndex);

                    if(father_index != father_newIndex) {
                        count--;
                        uf.union(index, newIndex);
                    }
                }
            }
            out.add(count);
        }
        return out;
    }

    public static void main(String[] args) {
        int n = 3;
        int m = 3;
        Point p1 = new Point(0,0);
        Point p2 = new Point(0,1);
        Point p3 = new Point(2,2);
        Point p4 = new Point(2,1);

        Point[] operators = {p1, p2, p3, p4};
        List<Integer> out  =numIslands2(n, m, operators);
        System.out.print(out);
    }
}


