package com.leetcode.oj;

public class ReverseNodesInkGroup {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
    public static ListNode reverseKGroup(ListNode head, int k) {
    	ListNode h = null;
    	ListNode t = null;
    	ListNode lt = null;
    	ListNode p = head;
    	ListNode q = null;
    	ListNode hres = null;
    	int n = k;
    	while (null != p) {
    		t = p;
    		h = null;
	    	while (null != p && n > 0) {
	    		q = p;
	    		p = p.next;
	    		q.next = h;
	    		h = q;
	    		n--;
	    	}
	    	if (0 == n) {
		    	if (null == hres) hres = h; 
		    	if (null != lt) lt.next = h;
		    	lt = t;
		    	t.next = p;
		    	n = k;
	    	} else {
	    		p = h;
	    		q = null;
	    		h = null;
	    		while (null != p) {
	    			q = p.next;
	    			p.next = h;
	    			h = p;
	    			p = q;
	    		}
	    		if (null != lt) lt.next = h;
	    		if (null == hres) hres = h;
	    	}
    	}
        return hres;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l0 = new ListNode(0);
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		l0.next = l1; l1.next = l2; l2.next = l3;l3.next = l4;
		l0 = reverseKGroup(l0,6);
		for (ListNode p = l0; null != p; p = p.next) {
			System.out.println(p.val);
		}
	}

}