/*
0.Problem:
Sort a linked list in O(n log n) time using constant space complexity.

1.Refer.: 递归
1.0 第一个元素作为结果的中间元素mid；比mid小的元素作为一个链表，
比mid大的元素作为另一个链表
1.1 递归大小两个链表；
1.2 结果组合；
*/
package com.leetcode.oj;

public class SortList {
	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
    public static ListNode sortList(ListNode head) {
    	if (null == head || null == head.next) return head;
    	boolean asc = true;
    	ListNode ah = head;
    	while (null != ah.next) {
    		if (ah.val > ah.next.val) {
    			asc = false; break;
    		} 
    		ah = ah.next;
    	} 
    	if (asc) return head; 
    	ListNode lh = null, rh = null;
    	ListNode lp = null, rp = null;
    	ListNode p = head.next;
    	ListNode mid = head;
    	mid.next = null;
    	while (null != p) {
    		if (p.val < mid.val) {
    			if (null == lh) lh = lp = p;
    			else {
    				lp.next = p;
    				lp = lp.next;
    			}
    		} else {
    			if (null == rh) rh = rp = p;
    			else {
    				rp.next = p;
    				rp = rp.next;
    			}
    		}
    		p = p.next;
    		if (null != lp)	lp.next = null;
    		if (null != rp) rp.next = null;
    	}
    	lh = sortList(lh);
    	rh = sortList(rh);
    	p = lh;
    	if (null != p) {
    		while (null != p.next) p = p.next;
        	p.next = mid; 
        	mid.next = rh;
    	} else {
    		lh = mid;
    		mid.next = rh;
    	}

    	return lh;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a = new ListNode(3);
		ListNode b = new ListNode(1);
		ListNode c = new ListNode(2);
		ListNode d = new ListNode(3);
		ListNode e = new ListNode(2);
		ListNode f = new ListNode(1);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		a = sortList(a);
		for (ListNode p = a;null != p; p = p.next) {
			System.out.println(p.val);
		}
	}

}
