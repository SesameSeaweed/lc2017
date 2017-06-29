public class PathSum437 {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        return helper(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);

    }

    public static int helper(TreeNode node, int sum) {
        if(node == null) return 0;
        if(node.val == sum)  return 1+helper(node.left, sum - node.val) + helper(node.right, sum - node.val);

        return helper(node.left, sum - node.val) + helper(node.right, sum - node.val);
    }

    public static int traverse(TreeNode root, int sum) {
        if(root == null) return 0;
        int count = 0;
        count = helper(root, sum);
        count += traverse(root.left, sum);
        count += traverse(root.right, sum);
        return count;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(10);
        TreeNode t2 = new TreeNode(5);
        TreeNode t3 = new TreeNode(-3);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(2);
        TreeNode t6 = new TreeNode(11);
        TreeNode t7 = new TreeNode(3);
        TreeNode t8 = new TreeNode(-2);
        TreeNode t9 = new TreeNode(1);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.right = t6;
        t4.left = t7;
        t4.right = t8;
        t5.right = t9;

        System.out.println(pathSum(t1, 8));

    }
}
