/**
 * Source : http://oj.leetcode.com/problems/insertion-sort-list
 * Author : Hexiaoqiao
 * Date   : 2014-09-26
 *
 * 0.Problem:
 * Sort a linked list using insertion sort.
 * 
 * 1.Refer.:
 * 链表插入排序：同数组插入排序，不同之处在于查找过程是顺序非二分
 */
package com.leetcode.oj;

public class InsertSortList {
	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public static ListNode insertionSortList(ListNode head) {
		if (null == head || null == head.next) return head;
		ListNode p = head.next; 
		head.next = null;
		ListNode r = head, rp = r, fp = null;
		while (null != p) {
			rp = r;
			fp = null;
			while (null != rp) {
				if (p.val < rp.val) {
					break;
				}
				fp = rp;
				rp = rp.next;
			}
			ListNode q = p;
			p = p.next;
			q.next = rp;
			if (null != fp) fp.next = q;
			else {r = q;}
		}
        return r;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a = new ListNode(3);
		ListNode b = new ListNode(4);
		ListNode c = new ListNode(1);
		ListNode d = new ListNode(3);
		ListNode e = new ListNode(3);
		ListNode f = new ListNode(3);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		a = insertionSortList(a);
		for (ListNode p = a;null != p; p = p.next) {
			System.out.println(p.val);
		}
	}

}
