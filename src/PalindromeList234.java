
public class PalindromeList234 {
    private static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public static boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        slow = reverse(slow);
        fast = head;

        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null ) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(2);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
//        l4.next = l5;
//        ListNode head = reverse(l1);
//        while(head != null) {
//            System.out.print(head.val);
//            head = head.next;
//        }
        System.out.print(isPalindrome(l1));
    }
}
