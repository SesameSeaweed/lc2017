public class SortedListToBST {
    private static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    private static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public static TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return new TreeNode(head.val);
        ListNode fast = head;
        ListNode slow = head;
        ListNode temp = slow;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;

            if(fast == null || fast.next == null) {
                temp = slow;
                slow = slow.next;
                temp.next = null;
            }else {
                slow = slow.next;
            }
        }

        fast = head;

        TreeNode root = new TreeNode(slow.val);
        TreeNode left = sortedListToBST(fast);
        TreeNode right = sortedListToBST(slow.next);

        root.left = left;
        root.right = right;
        return root;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
//        l4.next = l5;

        TreeNode head = sortedListToBST(l1);

        System.out.println();
    }
}
