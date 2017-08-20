public class LowestCA236 {
    private static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(!(nodeInTree(root, p) && nodeInTree(root,q))) return null;
        if(root.val == p.val || root.val == q.val) return root;
        if(nodeInTree(root.left, p) && nodeInTree(root.left, q)) return lowestCommonAncestor(root.left, p, q);
        if(nodeInTree(root.right, p) && nodeInTree(root.right, q)) return lowestCommonAncestor(root.right, p, q);
        return root;
    }

    private static boolean nodeInTree(TreeNode root, TreeNode p) {
        if(root == null) return false;
        if(root==p) return true;
        return nodeInTree(root.left, p) || nodeInTree(root.right, p);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(5);
        TreeNode t3 = new TreeNode(1);
        TreeNode t4 = new TreeNode(6);
        TreeNode t5 = new TreeNode(2);
        TreeNode t6 = new TreeNode(0);
        TreeNode t7 = new TreeNode(8);
        TreeNode t8 = new TreeNode(7);
        TreeNode t9 = new TreeNode(4);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        t5.left = t8;
        t6.right = t9;

        TreeNode out = lowestCommonAncestor(t1, t2, t8);
        System.out.print(out.val);
    }
}
