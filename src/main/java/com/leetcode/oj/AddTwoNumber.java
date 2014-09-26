package com.leetcode.oj;

public class AddTwoNumber {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode p1 = l1;
		ListNode p2 = l2;
		int incr = 0;
		ListNode ln = null;
		ListNode p = null;;
		while (p1 != null || p2 != null || incr != 0) {
			int sum = 0;
			if (null != p1) sum = sum + p1.val;
			if (null != p2) sum = sum + p2.val;
			sum = sum + incr;
			int val = sum % 10;
			incr = sum / 10; 
			ListNode tmp = new ListNode(val);
			if (null == ln) ln = tmp;
			if (null != p) { 
				p.next = tmp;
				p = tmp;
			} else {
				p = tmp;
			}
			if (null != p1) p1 = p1.next;
			if (null != p2) p2 = p2.next;
		}
		return ln;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a1 = new ListNode(5);
		ListNode b1 = new ListNode(6);
		ListNode c1 = new ListNode(7);
		a1.next = b1;
		b1.next = c1;
		ListNode a2 = new ListNode(8);
		ListNode b2 = new ListNode(9);
		ListNode c2 = new ListNode(7);
		a2.next = b2;
		b2.next = c2;
		ListNode a3 = null;
		ListNode a4 = null;
		ListNode rtn = addTwoNumbers(a4, a3);
		for (ListNode p = rtn;null != p; p = p.next) {
			System.out.println(p.val);
		}
	}

}
