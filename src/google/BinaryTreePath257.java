package google;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePath257 {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        List<String> out = new ArrayList<>();
        StringBuilder path = new StringBuilder("");
        helper(root, path, out);
        return out;
    }

    private static void helper(TreeNode root, StringBuilder path, List<String> out) {
        if(root == null) {
            if(!out.contains(path.toString())) {
                out.add(path.toString());
            }
            return;
        }

        if(path.length() == 0) {
            path.append(root.val);
        }else {
            path.append("->").append(root.val);
        }

        if(root.left == null && root.right == null) {
            out.add(path.toString());
            return;
        }

        if(root.left != null) {
            int length = path.length();
            helper(root.left, path, out);
            path = new StringBuilder(path.substring(0, length));
        }

        if(root.right != null) {
            helper(root.right, path, out);
        }
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        t1.left = t2;
        t1.right = t3;
        t2.right = t4;
        t3.left = t5;

        List<String> out = binaryTreePaths(t1);
        System.out.print(out);

    }
}
