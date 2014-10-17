/*
0.Problem:
Given a list, rotate the list to the right by k places, 
where k is non-negative.
For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.

1.Refer.:
1.0 顺序遍历
1.1 边界条件

*/
package com.leetcode.oj;

public class RotateList {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
    public static ListNode rotateRight(ListNode head, int n) {
    	ListNode p = head;
    	ListNode q = null;
    	int len = 0;
    	while (null != p) {
    		len = len + 1;
    		p = p.next;
    	}
    	if (0 == len) return head;
    	n = n % len;
    	if (0 == n) return head;
    	int i = 0;
    	p = head;
    	while (null != p && i < len - n - 1) {
    		p = p.next;
    		i = i + 1;
    	}
    	q = p;
    	p = p.next;
    	q.next = null;
    	q = p;
    	while (null != q.next) {
    		q = q.next;
    	}
    	q.next = head;
    	head = p;
        return p;
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
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		a = rotateRight(a, 0);
		while (null != a) {
			System.out.print(a.val);
			a = a.next;
		}
	}

}
