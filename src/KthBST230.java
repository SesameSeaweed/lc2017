
public class KthBST230 {
    private static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public static int kthSmallest(TreeNode root, int k) {
        int left = 0;
        int right = 0;
        if(root == null) return Integer.MIN_VALUE;

        if(root.left != null) {
            left = countNodes(root.left);
        }

        if(k == left + 1) return root.val;
        if(k > left+1) return kthSmallest(root.right, k - left - 1);
        if(k < left + 1) return kthSmallest(root.left, k);
        return 0;
    }

    private static int countNodes(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        int left = 0;
        int right = 0;
        if(root.left != null) left = countNodes(root.left);
        if(root.right != null) right =  countNodes(root.right);
        return left+right+1;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(9);
        TreeNode t2 = new TreeNode(7);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(8);
        TreeNode t5 = new TreeNode(3);
        TreeNode t6 = new TreeNode(5);
        TreeNode t7 = new TreeNode(12);
        TreeNode t8 = new TreeNode(10);
        TreeNode t9 = new TreeNode(13);
        t1.left = t2;
        t1.right = t7;
        t2.left = t3;
        t2.right = t4;
        t3.left = t5;
        t3.right = t6;
        t7.left = t8;
        t7.right = t9;
        System.out.print(kthSmallest(t1,8));
    }
}
