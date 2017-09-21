public class SumRootToLeaf129 {
    private static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public static int sumNumbers(TreeNode root) {
        int target = 0;
        helper(root, target);
        return target;
    }

    private static int helper(TreeNode root, int target) {
        if(root == null) return target;
        if (root.right == null && root.left == null) return target*10 + root.val;
        return helper(root.left, target*10 + root.val) + helper(root.right, target*10 + root.val);

    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);


        t1.left = t2;
        t2.left = t4;
        t1.right = t3;
        t3.right = t5;

        System.out.print(sumNumbers(t1));
    }

}
