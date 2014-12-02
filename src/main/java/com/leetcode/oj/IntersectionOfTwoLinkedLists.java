/**
 * Source : https://oj.leetcode.com/problems/intersection-of-two-linked-lists/
 * Author : Hexiaoqiao
 * Date   : 2014-12-02
 *
 * 0.Problem:
 * Write a program to find the node at which the intersection of two singly 
 * linked lists begins.
 * For example, the following two linked lists:
 * A:          a1 → a2
 *                    ↘
 *                      c1 → c2 → c3
 *                    ↗            
 * B:     b1 → b2 → b3
 * begin to intersect at node c1.
 * 
 * Notes:
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 * 
 * 1.Refer.:
 * 1.0 遍历两个链表计算长度alen/blen；
 * 1.1 让较长链表先走|alen-blen|；
 * 1.2 两个链表同时前进，若相同返回，否则继续；
 * 1.3 返回null
 */
package com.leetcode.oj;

public class IntersectionOfTwoLinkedLists {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (null == headA || null == headB) {return null;}
        ListNode A = headA;
        ListNode B = headB;
        int alen = 0, blen = 0;
        while (null != A) {alen = alen + 1; A = A.next;}
        while (null != B) {blen = blen + 1; B = B.next;}
        A = headA;
        B = headB;
        if (alen > blen) {
        	while (alen > blen) {A = A.next; alen = alen - 1;} 
        } else {
        	while (blen > alen) {B = B.next; blen = blen - 1;}
        }
        while (null != A && null != B) {
        	if (A == B) return A;
        	A = A.next;
        	B = B.next;
        }
    	return null;
    }
    
    public static void print(ListNode node) {
    	if (null != node) System.out.println(node.val);
    	else System.out.println("NULL");
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a0 = new ListNode(0);
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(2);
		ListNode a3 = new ListNode(3);
		ListNode a4 = new ListNode(4);
		
		ListNode b0 = new ListNode(5);
		ListNode b1 = new ListNode(6);
		ListNode b2 = new ListNode(7);
		
		a0.next = a1;
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		
		b0.next = b1;
		b1.next = b2;
		//b2.next = a2;
		
		print(getIntersectionNode(a0, b0));
	}

}
