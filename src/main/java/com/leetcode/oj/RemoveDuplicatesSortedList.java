/**
 * Source : http://oj.leetcode.com/problems/remove-duplicates-from-sorted-array
 * 			http://oj.leetcode.com/problems/remove-duplicates-from-sorted-array-ii
 * 			http://oj.leetcode.com/problems/remove-duplicates-from-sorted-list
 * 			http://oj.leetcode.com/problems/remove-duplicates-from-sorted-list-ii
 * 			http://oj.leetcode.com/problems/remove-element
 * Author : Hexiaoqiao
 * Date   : 2014-09-26
 *
 * 0.Problem:
 * 0.0
 * Given a sorted linked list, delete all duplicates such that 
 * each element appear only once.
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 * 
 * 0.1
 * Given a sorted linked list, delete all nodes that have duplicate 
 * numbers, leaving only distinct numbers from the original list.
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 * 
 * 0.2
 * Given a sorted array, remove the duplicates in place such that 
 * each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this 
 * in place with constant memory.
 * For example,
 * Given input array A = [1,1,2],
 * Your function should return length = 2, and A is now [1,2].
 * 
 * 0.3
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * For example,
 * Given sorted array A = [1,1,1,2,2,3],
 * Your function should return length = 5, and A is now [1,1,2,2,3].
 * 
 * 0.4
 * Given an array and a value, remove all instances of that value in 
 * place and return the new length.
 * The order of elements can be changed. It doesn't matter what you 
 * leave beyond the new length.
 * (注：将值为value的元素移到数组尾部，返回（删除value后）结果数组长度)
 * 
 * 1.Refer.:
 * 1.0 顺序遍历跳过重复元素生成结果链表
 * 1.1 两个指针分别指向重复元素的起至位置，一次全部删除
 * 1.2 通过累计重复元素个数确认当前不重复元素新位置
 * 1.3 同1.2，区别在于保留重复个数从1到2
 * 1.4 ugly：顺序遍历数组，若遇到elem则与数组尾部第一个非elem元素交换 grace:双指针
 */
package com.leetcode.oj;

public class RemoveDuplicatesSortedList {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public static ListNode deleteDuplicates(ListNode head) {
		if (null == head || null == head.next) return head;
		ListNode p = head.next;
		ListNode q = head;
		while (null != p) {
			if (p.val == q.val) {
				q.next = p.next;
			} else {
				q = q.next;
			}
			p = p.next;
		}
		return head;
	}
	
    public static ListNode deleteDuplicates2(ListNode head) {
    	if (null == head || null == head.next) return head;
    	ListNode p = head.next;
        ListNode q = head, r = head;
        boolean find = false;
        while (null != q && null != p) {
        	find = false;
            while (null != p && p.val == q.val) {
            	p = p.next;
            	find = true;
            }
            if (find) {
	            if (q == head) {
	            	head = p;
	            	q = head;
	            	r = head;
	            	if (null != p) p = p.next;
	            } else {
	            	r.next = p;
	            	q = p;
	            	if (null != p) p = p.next;
	            }
            } else {
            	p = p.next;
            	q = q.next;
            	if (r.next != q) r = r.next; 
            }
        }
        
    	return head;
    }
    
    public static int removeDuplicates(int[] A) {
        int len = A.length;
        int dup = 1;
        int des = 0;
        for (int i = 1; i < len; i++) {
        	if (A[i] == A[i - 1]) {
        		dup = dup + 1;
        	} else {
        		if (dup > 2) {
        			des = des + dup - 2;
        		}
        		dup = 1;
        	}
        	A[i - des] = A[i];
        }
        if (dup > 2) {
        	return len - des - dup + 2;
        } else {
        	return len - des;
        }
    }

    public static int removeDuplicates2(int[] A) {
        int len = A.length;
        int dup = 1;
        int des = 0;
        for (int i = 1; i < len; i++) {
        	if (A[i] == A[i - 1]) {
        		dup = dup + 1;
        	} else {
        		if (dup > 2) {
        			des = des + dup - 1;
        		}
        		dup = 1;
        	}
        	A[i - des] = A[i];
        }
        if (dup > 1) {
        	return len - des - dup + 1;
        } else {
        	return len - des;
        }
    }
    
    public static int removeElement(int[] A, int elem) {
    	int len = A.length;
        for (int i = 0; i < len; i++) {
        	while (len > 0 && elem == A[len - 1]) {
        		len = len - 1;
        	}
        	if (len <= i) return len;
        	if (elem == A[i]) {
        		A[i] = A[len - 1];
        		len = len - 1;
        	}
        }
    	return len;
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
		int[] arr = {2,1,3,1};
		//int len = removeDuplicates2(arr);
		int len = removeElement(arr, 1);
		System.out.println(len);
		for (int i = 0; i < len; i++) {
			System.out.print(arr[i] + " ");
		}
		/*
		for (ListNode p = a;null != p; p = p.next) {
			System.out.println(p.val);
		}*/
	}

}
