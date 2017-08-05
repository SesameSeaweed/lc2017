package google;

public class MergeKSortedList23 {

    private static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public static ListNode mergeKLists(ListNode[] lists) {
        return partition(lists, 0, lists.length-1);
    }

    public static ListNode partition(ListNode[] lists, int start, int end) {
        if(start < end) {
            int mid = (end - start) / 2 + start;
            ListNode left = partition(lists, start, mid);
            ListNode right = partition(lists, mid + 1, end);
            return helper(left, right);
        } else {
            return lists[start];
        }
    }


    public static ListNode helper(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        dummy.next = l1;
        ListNode curr = dummy;

        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else  {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if(l1 != null) {
            curr.next = l1;
        }
        if(l2  != null) {
            curr.next = l2;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l11 = new ListNode(1);
        ListNode l12 = new ListNode(3);
        ListNode l13 = new ListNode(5);
        l11.next = l12;
        l12.next = l13;

        ListNode l21 = new ListNode(2);
        ListNode l22 = new ListNode(4);
        ListNode l23 = new ListNode(6);
        l21.next = l22;
        l22.next = l23;

        ListNode l31 = new ListNode(7);
        ListNode l32 = new ListNode(9);
        l31.next = l32;

        ListNode l41 = new ListNode(8);
        ListNode l42 = new ListNode(10);
        l41.next = l42;

        ListNode[] lists = {l11, l21, l31, l41};
        ListNode head = mergeKLists(lists);
//        ListNode head = helper(l21, l31);
        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}
