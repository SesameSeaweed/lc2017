package amazon;

import java.util.ArrayList;
import java.util.List;

public class Serial297 {
    private static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder("{");

        List<TreeNode> node = new ArrayList<>();
        node.add(root);
        List<TreeNode> child = new ArrayList<>();
        boolean isLeaf = false;
        while (!isLeaf) {
            isLeaf = true;
            for(int i = 0; i < node.size(); i++) {
                TreeNode curr = node.get(i);
                if(curr.val == Integer.MIN_VALUE) {
                    sb.append("#,");
                }else{
                    sb.append(curr.val).append(",");
                }

                if(curr.left != null) {
                    child.add(curr.left);
                    isLeaf = false;
                }else{
                    child.add(new TreeNode(Integer.MIN_VALUE));
                }
                if(curr.right != null) {
                    child.add(curr.right);
                    isLeaf = false;
                }else {
                    child.add(new TreeNode(Integer.MIN_VALUE));
                }
            }
            node = child;
            child = new ArrayList<>();
            if(isLeaf) isLeaf = true;
        }
        int length = sb.length() - 1;
        while(sb.length() > 0 && sb.charAt(length-1) == '#') {
            length -= 2;
        }
        return sb.substring(0, length) +"}";
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if(data.equals("{}")) return null;
        data = data.substring(1, data.length()-1);
        String[] values = data.split(",");
        int level = 0;
        List<List<TreeNode>> tree = new ArrayList<>();

        int len = data.length() - 2;
        int i = 0;

        while(i <= (len+1)/2) {
            List<TreeNode> layer = new ArrayList<>();
            int j = 0;
            while(j < Math.min(Math.pow(2, level), values.length-i)) {
                String s = values[i+j];
                if(s.equals("#")) {
                    TreeNode node = new TreeNode(Integer.MIN_VALUE);
                    layer.add(node);
                }
                else {
                    TreeNode node = new TreeNode(Integer.parseInt(s));
                    layer.add(node);
                }
                j++;
            }
            i += j;
            if(layer == null || layer.isEmpty()) break;
            level++;
            tree.add(layer);
        }

        for(int t = 0; t < level - 1; t++) {
            List<TreeNode> lefa = tree.get(t);
            List<TreeNode> leaves = tree.get(t+1);
            for(int m = 0; m < lefa.size(); m++) {
                TreeNode cu = lefa.get(m);
                if(2*m < leaves.size() && leaves.get(2 * m).val != Integer.MIN_VALUE) {
                    cu.left = leaves.get(2*m);
                }
                if(2*m+1 < leaves.size() && leaves.get(2*m + 1).val != Integer.MIN_VALUE) {
                    cu.right = leaves.get(2*m+1);
                }
            }
        }
        return tree.get(0).get(0);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(-1);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(-2);
        TreeNode t5 = new TreeNode(5);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;

        String se = serialize(t1);
        System.out.println(se);

        TreeNode head = deserialize(se);
        System.out.print(head.val);
    }
}
