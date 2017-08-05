package google;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeIterator173 {
    private static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    private List<Integer> list = new ArrayList<>();
    private int index = 0;
    public BinaryTreeIterator173(TreeNode root) {
        Stack<TreeNode> tree = new Stack<>();
        TreeNode node = root;
        while(!tree.isEmpty() || node != null) {
            while(node != null) {
                tree.push(node);
                node = node.left;
            }
            node = tree.pop();
            list.add(node.val);
            node = node.right;
        }
        System.out.print(list);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return index < list.size();
    }

    /** @return the next smallest number */
    public int next() {
        return list.get(index++);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);

//        t5.left = t4;
//        t5.right = t7;
//        t7.left = t6;
//        t4.left = t2;
//        t2.left = t1;
//        t2.right = t3;
        t1.right = t2;

        BinaryTreeIterator173 binaryTreeIterator173 = new BinaryTreeIterator173(t1);

    }
}
