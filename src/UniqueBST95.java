import java.util.List;
import java.util.ArrayList;

public class UniqueBST95 {
	public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public List<TreeNode> generateTrees(int n) {
        return generateTreesHelper(1, n);
    }

    private List<TreeNode> generateTreesHelper(int start, int end) {
    	List<TreeNode> rst = new ArrayList<>();

    	if(start > end) {
    		rst.add(null);
    		return rst;
    	}

    	for(int i = start; i <= end; i++) {
    		List<TreeNode> left = generateTreesHelper(start, i-1);
    		List<TreeNode> right = generateTreesHelper(i+1, end);
    
    		for(TreeNode lRoot : left) {
    			for(TreeNode rRoot : right) {
    				TreeNode root = new TreeNode(i);
    				root.right = rRoot;
    				root.left = lRoot;
    				rst.add(root);
    		}
    	}
    }
    return rst;
}

    public static void main(String[] args) {

    }
}