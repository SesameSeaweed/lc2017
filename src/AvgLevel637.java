import java.util.ArrayList;
import java.util.List;

public class AvgLevel637 {

    private static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> out = new ArrayList<>();

        List<TreeNode> leaves = new ArrayList<>();
        leaves.add(root);

        while(!leaves.isEmpty()) {
            long sum = 0;
            List<TreeNode> children = new ArrayList<>();
            for(TreeNode node : leaves) {
               if(node.left != null) children.add(node.left);
                if(node.right != null) children.add(node.right);
                sum += node.val;
            }
            out.add((double)sum / (double) leaves.size());
            leaves = children;
        }
        return out;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(20);
        TreeNode t4 = new TreeNode(15);
        TreeNode t5 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;

        List<Double> out = averageOfLevels(t1);
        System.out.println(out);
    }
}
