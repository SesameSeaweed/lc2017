import java.util.ArrayList;
import java.util.List;

public class PathSum113 {
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {

        List<List<Integer>> out = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        pathSumHelper(root, sum, path, out);
        return out;

    }

    public static void pathSumHelper(TreeNode root, int sum, List<Integer> path, List<List<Integer>> out) {
        if(root == null) return;
        if(root.left == null && root.right == null && root.val == sum) {
            path.add(root.val);
            out.add(new ArrayList<>(path));
            path.remove(path.size()-1);
            return;
        }

        path.add(root.val);
        if(root.left != null) {
            pathSumHelper(root.left, sum - root.val, path, out);
        }

        if(root.right != null) {
            pathSumHelper(root.right, sum - root.val, path, out);
        }
        path.remove(path.size()-1);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(3);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;

        List<List<Integer>> out = pathSum(t1, 7);
        System.out.println(out);
    }
}
