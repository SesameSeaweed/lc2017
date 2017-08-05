
public class OddEvenList328 {
    private static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public static ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode(0);
        ListNode oddCurr = odd;
        ListNode even = new ListNode(0);
        ListNode evenCurr = even;
        int count = 1;

        while(head != null) {
            if(count % 2 == 0) {
                evenCurr.next = head;
                evenCurr = evenCurr.next;
            } else {
                oddCurr.next = head;
                oddCurr = oddCurr.next;
            }
            count++;
            head = head.next;
        }
        evenCurr.next = null;
        oddCurr.next = even.next;
        return odd.next;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(6);
        ListNode n6 = new ListNode(5);
        ListNode n7 = new ListNode(7);
        ListNode n8 = new ListNode(8);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;

        ListNode returned = oddEvenList(n1);
        while(returned != null) {
            System.out.print(returned.val);
            returned = returned.next;
        }
    }
}
