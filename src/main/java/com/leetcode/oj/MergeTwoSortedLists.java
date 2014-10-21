/**
 * Source : 
 * Author : Hexiaoqiao
 * Date   : 2014-09-26
 *
 * 0.Problem:
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes 
 * of the first two lists.
 * 
 * 1.Refer.:
 * 两个链表顺序遍历进行合并
 */
package com.leetcode.oj;

public class MergeTwoSortedLists {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (null == l2) return l1;
		if (null == l1) return l2;
        ListNode ah = l1;
        ListNode bh = l2;
        ListNode rh = null;
        ListNode p = null;
		while (null != ah && null != bh) {
        	if (ah.val < bh.val) {
        		if (null == rh) {rh = ah; p = ah;}
        		else {p.next = ah;p = p.next;}
        		ah = ah.next;
        	} else {
        		if (null == rh) {rh = bh; p = bh;}
        		else {p.next = bh;p = p.next;}
        		bh = bh.next;
        	}
        }
		if (null != ah) p.next = ah;
		if (null != bh) p.next = bh;
		return rh;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a = new ListNode(3);
		ListNode b = new ListNode(4);
		ListNode c = new ListNode(7);
		ListNode d = new ListNode(2);
		ListNode e = new ListNode(5);
		ListNode f = new ListNode(8);
		a.next = b;
		b.next = c;
		//c.next = d;
		d.next = e;
		e.next = f;
		
		ListNode r = mergeTwoLists(a, null);
		while (null != r) {
			System.out.print(r.val); r = r.next;
		}
	}

}
