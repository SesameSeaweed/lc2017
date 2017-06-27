import java.util.List;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Arrays;

public class BTPostorder145 {
	public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

   public static List<Integer> postorderTraversal(TreeNode root) {
   		if(root == null) return new LinkedList<Integer>();

   		Stack<TreeNode> tree = new Stack<>();
   		LinkedList<Integer> out = new LinkedList<>();

   		TreeNode node = root;
   		tree.add(node);
   		while(!tree.isEmpty()) {
   			node = tree.pop();
   			out.addFirst(node.val);	
   			if(node.left != null) {
   				tree.add(node.left);
   				
   			}
   			if(node.right != null) {
   				tree.add(node.right);
   				
   			}

   		}
   		return out;
   }

   public static void main(String[] args) {
   	    TreeNode n1 = new TreeNode(1);
    	TreeNode n2 = new TreeNode(2);
    	TreeNode n3 = new TreeNode(3);
    	TreeNode n4 = new TreeNode(4);
    	TreeNode n5 = new TreeNode(5);
    	TreeNode n6 = new TreeNode(6);
    	TreeNode n7 = new TreeNode(7);

    	n1.left = n2;
    	n1.right = n3;
    	n2.left = n4;
    	n2.right = n5;
    	n3.left = n6;
    	n3.right = n7;

    	List<Integer> out = postorderTraversal(n1);
    	System.out.println(out);
   }

}