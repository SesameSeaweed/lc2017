package jiuzhang;

public class MaxTree {
    private static class TreeNode {
      public int val;
      public TreeNode left, right;
      public TreeNode(int val) {
          this.val = val;
          this.left = this.right = null;
      }
    }

    public TreeNode maxTree(int[] A) {
        // write your code here
        int len = A.length;
        TreeNode[] stk = new TreeNode[len];

        for(int i = 0; i < len; i++) {
            stk[i] = new TreeNode(0);
        }

        int count = 0;
        for(int i = 0; i < len; i++) {
            TreeNode temp = new TreeNode(A[i]);
            while (count > 0 && A[i] >stk[count-1].val) {
                temp.left = stk[count-1];
                count--;
            }
            if(count > 0) {
                stk[count - 1].right = temp;
            }
            stk[count++] = temp;
        }
        return stk[0];
    }
}
