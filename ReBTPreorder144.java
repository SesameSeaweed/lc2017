import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class ReBTPreorder144 {
	public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

   // this is inorder...
   public static List<Integer> preorderTraversal(TreeNode root) {
   		if(root == null) return new ArrayList<>();

   		Stack<TreeNode> tree = new Stack<>();
   		List<Integer> out = new ArrayList<>();

   		TreeNode node = root;

   		while(node != null || !tree.isEmpty()) {
   			while(node != null) {
   				tree.push(node);
   				node = node.left;
   			}
   			node = tree.pop();
   			out.add(node.val);
   			node = node.right;
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

    	List<Integer> out = preorderTraversal(n1);
    	System.out.println(out);
   }
}