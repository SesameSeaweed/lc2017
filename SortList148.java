public class SortList148 {
	public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public static ListNode sortList(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		if(head == null || head.next == null) return head;

		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			if(fast == null || fast.next == null) {
				ListNode temp = slow;
				slow = slow.next;
				temp.next = null;
				break;
			}
			slow = slow.next;
		}
		fast = head;
        ListNode temp1 = slow;
        ListNode temp2 = fast;

		slow = sortList(slow);
		fast = sortList(fast);
		return merge(slow, fast);
	}

    public static ListNode merge(ListNode l1, ListNode l2) {
    	ListNode l = new ListNode(0), p = l;
    
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        p.next = l1;
        l1 = l1.next;
      } else {
        p.next = l2;
        l2 = l2.next;
      }
      p = p.next;
    }
    
    if (l1 != null)
      p.next = l1;
    
    if (l2 != null)
      p.next = l2;
    
    return l.next;
    }

    public static void main(String[] args) {
    	ListNode l11 = new ListNode(1);
    	ListNode l12 = new ListNode(3);
    	ListNode l13 = new ListNode(5);
        ListNode l14 = new ListNode(7);

    	ListNode l21 = new ListNode(2);
    	ListNode l22 = new ListNode(4);
    	ListNode l23 = new ListNode(6);
    	ListNode l24 = new ListNode(8);

    	// l11.next = l12;
    	// l12.next = l13;
    	// l21.next = l22;
    	// l22.next = l23;
    	// l23.next = l24;
    	// ListNode head = merge(l21, l11);
    	l11.next = l12;
    	l12.next = l13;
    	l13.next = l14;
        l14.next = l21;
    	l21.next = l22;
    	l22.next = l23;
    	l23.next = l24;

    	ListNode head = sortList(l11);
    	while(head != null) {
    		System.out.println(head.val);
    		head = head.next;
    	}
    }
}