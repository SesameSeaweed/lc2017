public class PartitionList86 {

    private static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public static ListNode partition(ListNode head, int x) {
        ListNode it= head;
        ListNode less = new ListNode(0);
        ListNode more = new ListNode(0);
        ListNode lessIt = less;
        ListNode moreIt = more;
        while(it != null) {
            if(it.val <= x) {
                lessIt.next = it;
                lessIt = it;
            }else {
                moreIt.next = it;
                moreIt = it;
            }
            it = it.next;
        }
        lessIt.next = more.next;
        moreIt.next = null;
        return less.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(2);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

        ListNode head = partition(l1, 2);
        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
