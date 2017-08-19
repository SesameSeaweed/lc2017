public class RemoveDuplicateList83 {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while(curr != null) {
            while(curr != null && curr.next != null) {
                if(curr.val == curr.next.val) {
                    curr.next = curr.next.next;
                }else break;
            }
            curr = curr.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ListNode head = deleteDuplicates(l1);
        while(head != null) {
            System.out.print(head.val);
            head = head.next;
        }
    }
}
