/*
0.Problem:
Given a linked list, determine if it has a cycle in it.
Follow up:
Can you solve it without using extra space?

Given a linked list, return the node where the cycle begins. 
If there is no cycle, return null.
Follow up:
Can you solve it without using extra space?

1.Refer.:
1.0 两个指针，其中一个每次走一步，另一个每次走两步，如果相遇则有cycle;
1.1 设从头节点开始到环的开始点的长度为a,环的开始点到相遇点的长度为b，
相遇点到环的开始点的长度为c，则：
	2a+2b=a+2b+c => a = c
从相遇点开始一个指针，头开始一个指针，两者相遇即为环开始点
*/
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
