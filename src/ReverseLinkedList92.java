public class ReverseLinkedList92 {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
  }

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        int i = 1;
        ListNode curr = head;
        ListNode firstTail = new ListNode(0);
        firstTail.next = curr;
        while(i < m) {
            curr = curr.next;
            i++;
        }

        while(i < n) {

        }

        return head;
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
        l4.next = l5;

        ListNode head = reverseBetween(l1, 2, 4);
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
        }

    }

}
