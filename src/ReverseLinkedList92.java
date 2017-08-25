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
        ListNode curr = new ListNode(0);
        curr.next = head;
        ListNode firstTail = new ListNode(0);
        ListNode secondHead = new ListNode(0);
        ListNode secondTail = new ListNode(0);
        ListNode thirdHead = new ListNode(0);
        firstTail.next = curr;
        while(i < m) {
            curr = curr.next;
            i++;
        }
        firstTail = curr;
        secondHead = curr.next;
        while(i <= n) {
            curr = curr.next;
            i++;
        }
        secondTail = curr;
        thirdHead = curr.next;
        secondTail.next = null;

        ListNode newHead = reverse(secondHead);
        firstTail.next = newHead;
        while(newHead != null && newHead.next != null) {
            newHead = newHead.next;
        }
        newHead.next = thirdHead;

        return firstTail.val == 0 ? firstTail.next : head;
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
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

        ListNode head = reverseBetween(l1, 1,2);
        while (head != null) {
            System.out.print(head.val);
            head = head.next;
        }

    }

}
