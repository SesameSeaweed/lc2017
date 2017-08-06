public class LinkedListCycle142 {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode detectCycle(ListNode head) {
        if(head == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) {
                ListNode sl = head;
                while (sl != slow) {
                    sl = sl.next;
                    slow = slow.next;
                }
                return sl;
            }
        }
        return null;
    }

    public static ListNode test(ListNode head, ListNode n, ListNode a) {
        ListNode temp = head;
//        System.out.print(temp.next.val);
        head.next = n;
        System.out.print(temp.next.val);
        n.next = a;
        return head;
    }

    public static void main(String[] args) {
//        ListNode n1 = new ListNode(1);
//        ListNode n2 = new ListNode(2);
//        ListNode n3 = new ListNode(0);
//        ListNode n4 = new ListNode(-4);
//        ListNode n5 = new ListNode(6);
//        ListNode n6 = new ListNode(5);
//        ListNode n7 = new ListNode(7);
//        ListNode n8 = new ListNode(8);
//
//        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
//        n4.next = n5;
//        n5.next = n6;
//        n6.next = n7;
//        n7.next = n8;
//        n8.next = n1;
//        n2.next = n1;

//        System.out.print(detectCycle(n1).val);

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;

        ListNode head = test(n1, n3, n2);
        while(head != null) {
            System.out.print(head.val);
            head = head.next;
        }
    }
}
