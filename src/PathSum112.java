
public class PathSum112 {
    private static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
   }
    public static boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return  false ;
        if(root.left == null && root.right == null) return sum == root.val;

        boolean left = false;
        if(root.left != null) left = hasPathSum(root.left, sum - root.val);
        boolean right = false;
        if(root.right != null) right = hasPathSum(root.right, sum - root.val);
        return left || right;

    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;

        System.out.println(hasPathSum(t1, 10));

    }
}
