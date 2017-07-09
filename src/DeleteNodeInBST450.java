
public class DeleteNodeInBST450 {
    private static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public static TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;
        if(key == root.val) {
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;
            TreeNode minNode = findMin(root.right);
            root.val = minNode.val;
            root.right = deleteNode(root.right, root.val);
        }else {
            if(key > root.val) {
                if(root.right != null) deleteNode(root.right, key);
                else return null;
            }else {
                if(root.left != null) deleteNode( root.left, key);
                else return null;
            }
        }
        return root;
    }

    private static TreeNode findMin(TreeNode root) {
        while (root != null) {
            if(root.left != null) root = root.left;
        }
        return root;
    }

    public static void main(String[] args) {

    }
}
