package com.leetcode.oj;

public class SwapNodesPairs {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
    public static ListNode swapPairs(ListNode head) {
        ListNode h = null;
        ListNode p = head;
        ListNode q = head;
        ListNode l = null;
        while (null != p) {
        	q = p.next;
        	if (null != q) {
        		p.next = q.next;
        		q.next = p;
        		if (null == h) h = q;
        		if (null != l) l.next = q;
        		l = p;
        		p = p.next;
        	} else {
        		if (null == h) h = head;
        		break;
        	}
        }
    	return h;
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
		//l0.next = l1; l1.next = l2; l2.next = l3; l3.next = l4;
		l0 = swapPairs(l0);
		for (ListNode p = l0; null != p; p = p.next) {
			System.out.println(p.val);
		}
	}

}
