public class DeleteNode237 {
    private static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public static void deleteNode(ListNode node) {
        if(node == null) return;

        if(node.next == null) node = null;

        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {

    }
}
