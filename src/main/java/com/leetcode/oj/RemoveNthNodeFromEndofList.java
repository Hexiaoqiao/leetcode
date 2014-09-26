package com.leetcode.oj;

import com.leetcode.oj.RemoveDuplicatesSortedList.ListNode;

public class RemoveNthNodeFromEndofList {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        ListNode q = null;
        int num = 0;
        while (null != p) {
        	p = p.next;
        	num = num + 1;
        }
        if (n > num) return head;
        if (n == num) return head.next;
        p = head; q = head;
        int step = 0;
        while (null != p) {
        	q = p;
        	p = p.next;
        	step = step + 1;
        	if (step == num - n) {
        		break;
        	}
        }
        if (null == p) {q.next = null;}
        else {q.next = p.next;}
        return head;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(2);
		ListNode d = new ListNode(2);
		ListNode e = new ListNode(3);
		ListNode f = new ListNode(4);
		ListNode g = new ListNode(5);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		e.next = f;
		f.next = g;
		a = removeNthFromEnd(a, 5);
		for (ListNode p = a;null != p; p = p.next) {
			System.out.println(p.val);
		}
	}

}
