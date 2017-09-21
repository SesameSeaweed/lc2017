package jiuzhang;

import java.util.*;

public class ConnectedComponentInDirectedGraph {
   static class DirectedGraphNode {
      int label;
      ArrayList<DirectedGraphNode> neighbors;
      DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
   };

    private class UnionFind {
        Map<Integer, Integer> father = new HashMap<>();

        UnionFind(HashSet<Integer> nodes) {
            for(Integer node : nodes) {
                father.put(node, node);
            }
        }

        public int find(int x) {
            int parent = father.get(x);

            while(parent != father.get(parent)) {
                parent = father.get(parent);
            }
            return parent;
        }

        public void compress_path(int x) {
            int parent = father.get(x);

            while (parent != father.get(parent)) {
                parent = father.get(parent);
            }

            int fat = father.get(x);

            int temp = -1;
            while(fat != father.get(fat)) {
                temp = father.get(fat);
                father.put(fat, parent);
                fat = temp;
            }
        }

        public void union(int x, int y) {
            int x_root = find(x);
            int y_root = find(y);
            if(x_root != y_root)
            father.put(x_root, y_root);
        }
    }

    List<List<Integer>> print(HashSet<Integer> hashSet, UnionFind uf) {
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<Integer, List <Integer>> hashMap = new HashMap<>();

        for(int i : hashSet) {
            int fa = uf.find(i);

            if(!hashMap.containsKey(fa)) {
                hashMap.put(fa,  new ArrayList<Integer>());
            }

            List<Integer> now =  hashMap.get(fa);
            now.add(i);
            hashMap.put(fa, now);
        }

        for(List<Integer> now: hashMap.values()) {
            ans.add(now);
        }
        return ans;
    }

    public List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes) {
        HashSet<Integer> nodeVal = new HashSet<>();

        for(DirectedGraphNode node : nodes) {
            nodeVal.add(node.label);
            for(DirectedGraphNode neighbor : node.neighbors) {
                nodeVal.add(neighbor.label);
            }
        }

        UnionFind uf = new UnionFind(nodeVal);
        for(DirectedGraphNode node : nodes) {
            int node_parent = uf.find(node.label);
            for(DirectedGraphNode neighbor : node.neighbors) {
                int neighbor_parent = uf.find(neighbor.label);
                if(neighbor_parent != node_parent) {
                    uf.union(node_parent, neighbor_parent);
                }
            }
        }
        return print(nodeVal, uf);
    }
}
