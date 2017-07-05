public class AddTwoNumbers2 {
    private static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while(l1 != null && l2 != null) {
            curr.next = new ListNode((l1.val + l2.val + carry) % 10);
            carry = (l1.val + l2.val + carry) / 10;
            curr = curr.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null) {
            curr.next = new ListNode((l1.val + carry) % 10);
            carry = (l1.val + carry) / 10;
            curr = curr.next;
            l1 = l1.next;
        }

        while(l2 != null) {
            curr.next = new ListNode((l2.val + carry) % 10);
            carry = (l2.val + carry) / 10;
            curr = curr.next;
            l2 = l2.next;
        }
        if(carry == 1) curr.next = new ListNode(1);
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(4);
        ListNode l13 = new ListNode(3);
        ListNode l14 = new ListNode(1);

        ListNode l21 = new ListNode(5);
        ListNode l22 = new ListNode(6);
        ListNode l23 = new ListNode(4);

        l11.next = l12;
        l12.next = l13;
        l13.next = l14;

        l21.next = l22;
        l22.next = l23;

        ListNode head = addTwoNumbers(l11, l21);
        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

}
