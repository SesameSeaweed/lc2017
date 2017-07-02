public class MergeTwoSortedList21 {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode it = head;

        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                it.next = l1;
                it = it.next;
                l1 = l1.next;
            }else {
                it.next = l2;
                it = it.next;
                l2 = l2.next;
            }
        }

        if(l1 != null) {
            it.next = l1;
        }
        if(l2 != null) {
            it.next = l2;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);
        ListNode l8 = new ListNode(8);

        l1.next = l3;
        l3.next = l5;

        l2.next = l4;
        l4.next = l6;
        l6.next = l7;
        l7.next = l8;

        ListNode head = mergeTwoLists(l1, l2);
        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }

    }
}
