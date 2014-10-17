/*
0.Problem:
Given a linked list and a value x, partition it such that all nodes 
less than x come before nodes greater than or equal to x.
You should preserve the original relative order of the nodes in each 
of the two partitions.
For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.

1.Refer.:refer code 两段链表拼接
*/
package com.leetcode.oj;

public class PartitionList {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	public static ListNode partition(ListNode head, int x) {
		ListNode f = null;
		ListNode s = null;
		ListNode p = null, q = null;
		ListNode h = head;
		ListNode e = h;
		while (null != h) {
			if (h.val < x) {
				if (null == f) f = h;
				if (null == p) p = h;
				else {
					p.next = h;
					p = p.next;
				}
			} else {
				if (null == s) s = h;
				if (null == q) q = h;
				else {
					q.next = h;
					q = q.next;
				}
			}
			e = h;
			h = h.next;
			e.next = null;
		}
		if (null != p) p.next = s;
		return null == f ? s : f;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a = new ListNode(8);
		ListNode b = new ListNode(1);
		ListNode c = new ListNode(5);
		ListNode d = new ListNode(7);
		ListNode e = new ListNode(2);
		ListNode f = new ListNode(4);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		a = partition(a, 4);
		for (ListNode p = a;null != p; p = p.next) {
			System.out.println(p.val);
		}
	}

}
