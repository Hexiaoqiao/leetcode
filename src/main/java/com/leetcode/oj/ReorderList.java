/**
 * Source : http://oj.leetcode.com/problems/reorder-list
 * Author : Hexiaoqiao
 * Date   : 2014-09-26
 *
 * 0.Problem:
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * You must do this in-place without altering the nodes' values.
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * 
 * 1.Refer.:
 * 1.0 将链表从中间分成两边，后边链表逆序，然后将二者合并即可
 */
package com.leetcode.oj;

public class ReorderList {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public static void reorderList(ListNode head) {
		int len = 0;
		ListNode node = head;
		if (null == node) return; 
		while (null != node) {
			len = len + 1;
			node = node.next;
		}
		
		node = head;
		int i = 0;
		while (i < len / 2) {
			node = node.next;
			i = i + 1;
		}
		ListNode tmp = node.next;
		node.next = null;
		ListNode fistpart = head;
		ListNode secondpart = tmp;
		
		tmp = secondpart;
		ListNode p = null;
		while (null != tmp) {
			ListNode q = tmp;
			tmp = tmp.next;
			q.next = p;
			p = q;
		}
		secondpart = p;
		
		ListNode fp = fistpart;
		ListNode sp = secondpart;
		ListNode rp = fp;
		while (null != fp && null != sp) {
			ListNode tfp = fp;
			ListNode tsp = sp;
			fp = fp.next;
			sp = sp.next;
			tfp.next = tsp;
			tsp.next = fp;
		}
		head = rp;
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
		ListNode g = null;
		reorderList(a);
		for (ListNode p = a;null != p; p = p.next) {
			System.out.println(p.val);
		}
	}

}
