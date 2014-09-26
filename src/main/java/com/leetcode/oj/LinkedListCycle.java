package com.leetcode.oj;

public class LinkedListCycle {
	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public static ListNode hasCycle(ListNode head) {
		ListNode p = head;
		ListNode q = head;
		while (null != p && null != q) {
			p = p.next;
			q = q.next;
			if (null == p || null == q) return null;
			q = q.next;
			if (p == q) return p;
		}
		return null;
    }
	
	public static ListNode detectCycle(ListNode head) {
		ListNode p = head;
		ListNode q = head;
		while (null != p && null != q) {
			p = p.next;
			q = q.next;
			if (null == p || null == q) return null;
			q = q.next;
			if (null == q) return null; 
			if (p == q) break;
		}
        ListNode r = head;
        while (r != p) {
        	r = r.next;
        	p = p.next;
        }
		return r;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		ListNode e = new ListNode(5);
		ListNode f = new ListNode(6);
		
		a.next = b;
/*		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		f.next = c;*/
		ListNode r = detectCycle(a);
		if (null != r)
			System.out.println(r.val);
	}
}
