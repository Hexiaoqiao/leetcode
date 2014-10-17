/*
0.Problem:
Given a linked list, remove the nth node from the end of 
list and return its head.

For example,
   Given linked list: 1->2->3->4->5, and n = 2.
   After removing the second node from the end, the linked 
   list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.

1.Refer.:
ugly：
1.0 遍历链表得到长度len
1.1 删除len-n的元素
grace：
1.0 两个指针p,q；
1.1 p先走n步；
1.2 p,q同时走直到p.next=null；
1.3 q.next即为要删除的元素；
1.4 控制边界条件；
[n=len-(len-n)]
*/
package com.leetcode.oj;

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
