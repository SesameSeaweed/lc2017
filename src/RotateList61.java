public class RotateList61 {
    private static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        int count = 0;
        ListNode curr = head;
        ListNode tail = curr;
        while(curr != null) {
            count++;
            curr = curr.next;
            if(curr != null && curr.next == null) tail = curr;
        }

        k = k % count;
        curr = head;
        while (count - k >= 0) {
            if(count == k+1) {
                ListNode temp = curr;
                curr = curr.next;
                temp.next = null;
                break;
            } else {
                curr = curr.next;
            }
            count--;
        }
        ListNode newHead = curr;
        tail.next = head;
        return newHead;
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

        ListNode head = rotateRight(l1,2);
        while(head != null) {
            System.out.print(head.val);
            head = head.next;
        }
    }
}
