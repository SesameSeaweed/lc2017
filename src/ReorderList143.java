public class ReorderList143 {
    private static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public static void reorderList(ListNode head) {
        int count = 0;

        ListNode curr = head;

        while (curr != null) {
            count++;
            curr = curr.next;
        }
        boolean odd = count%2 == 1 ? true : false;
        curr = head;
        count = odd ? (count-1) : count;
        count /= 2;
        while(count > 0) {
            count--;
            curr = curr.next;
        }

        ListNode reverseHead = reverse(curr);
        curr = head;

        while(reverseHead != null && reverseHead.next != null) {
            ListNode next = curr.next;
            ListNode reverseNext = reverseHead.next;
            curr.next = reverseHead;
            reverseHead.next = next;
            curr = curr.next.next;
            reverseHead = reverseNext;
        }

        if(odd) reverseHead.next = curr;
        else {
            curr.next = reverseHead;
            curr = curr.next;
        }
        curr.next = null;
        return;
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

        reorderList(l1);
        while(l1 != null) {
            System.out.println(l1.val);
            l1 = l1.next;
        }
    }
}
