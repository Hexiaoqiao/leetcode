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
