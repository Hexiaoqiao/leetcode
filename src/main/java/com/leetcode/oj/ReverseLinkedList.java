package com.leetcode.oj;

public class ReverseLinkedList {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
    public static ListNode reverseBetween(ListNode head, int m, int n) {
    	ListNode qe = null;
    	int i = 0;
    	ListNode p = head;
    	while (i < m - 2) {
    		p = p.next;
    		i++;
    	}
    	if (m > 1) {
    		qe = p;
    	}
    	i = m;
    	ListNode q = null;
    	ListNode s = null;
    	if (m > 1) s = p.next;
    	else s = p;
    	ListNode r = null;
    	ListNode re = null;
    	while (i <= n) {
    		r = s.next;
    		s.next = q;
    		if (null == re) {
    			re = s;
    		}
    		q = s;
    		s = r;
    		i++;
    	}
    	re.next = s;
    	if (null == qe) {
    		head = q;
    	} else {
    		qe.next = q;
    	}
    	return head;
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
		l0.next = l1; l1.next = l2; l2.next = l3;
		l0 = reverseBetween(l0,1,4);
		for (ListNode p = l0; null != p; p = p.next) {
			System.out.println(p.val);
		}
	}
}
