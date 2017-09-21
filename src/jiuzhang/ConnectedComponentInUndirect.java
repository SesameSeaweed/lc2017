package jiuzhang;

import java.util.*;

public class ConnectedComponentInUndirect {
    static class UndirectedGraphNode {
      int label;
      ArrayList<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
    };

    private class UnionFind {
        Map<Integer, Integer> father = new HashMap<>();

        public UnionFind(HashSet<Integer> set) {
            for(Integer i : set) {
                father.put(i,i);
            }
        }

        public int find(int x) {
            int parent = father.get(x);
            if(x == father.get(x)) return x;

            while(parent != father.get(parent)) {
                parent = father.get(parent);
            }
            return parent;
        }

        public void compressPath(int x) {
            int parent = father.get(x);
            while(parent != father.get(parent)) {
                parent = father.get(parent);
            }

            int littleParent = father.get(x);
            int temp = -1;
            while(littleParent != father.get(littleParent)) {
                temp = father.get(littleParent);
                father.put(littleParent, parent);
                littleParent = temp;
            }
        }

        public void union(int x, int y) {
            int node_x = find(x);
            int node_y = find(y);
            if(node_x != node_y) {
                father.put(node_x, node_y);
            }
        }
    }

    public List<List<Integer>> print (HashSet<Integer> values, UnionFind uf) {
        List<List<Integer>> out = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int value : values) {
            int daddy = uf.find(value);
            if(!map.containsKey(daddy)) {
                List<Integer> temp = new ArrayList<>();
                map.put(daddy, temp);
            }
            List<Integer> temp = map.get(value);
            temp.add(value);
        }

        for(Map.Entry<Integer,List<Integer>> entry : map.entrySet()) {
           List<Integer> now = entry.getValue();
            Collections.sort(now);
            out.add(now);
        }
        return out;
    }

    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        // Write your code here
        HashSet<Integer> values = new HashSet<>();

        for(UndirectedGraphNode node : nodes) {
            values.add(node.label);
            for(UndirectedGraphNode neighbor : node.neighbors) {
                values.add(neighbor.label);
            }
        }

        UnionFind uf = new UnionFind(values);
        for(UndirectedGraphNode node : nodes) {
            int node_parent = uf.find(node.label);

            for(UndirectedGraphNode neighbor : node.neighbors) {
                int neighbor_parent = uf.find(neighbor.label);
                if(node_parent != neighbor_parent) {
                    uf.union(node_parent, neighbor_parent);
                }
            }
        }
        return print(values, uf);
    }


}
