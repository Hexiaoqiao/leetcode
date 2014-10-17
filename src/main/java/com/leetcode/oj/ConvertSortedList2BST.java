/*
0.Problem:
Given a singly linked list where elements are sorted 
in ascending order, convert it to a height balanced BST.

1.Refer.:思路同ConvertSortedArray2BST，区别在于需要从头开始遍历到中间位置
*/
package com.leetcode.oj;

public class ConvertSortedList2BST {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
    public static TreeNode sortedListToBST(ListNode head) {
    	ListNode l = head;
    	int len = 0;
    	while(null != l) {
    		len = len + 1;
    		l = l.next;
    	}
        return sortedSubListToBST(head, len);
    }
    
    public static TreeNode sortedSubListToBST(ListNode head, int step) {
    	if (step <= 0) return null;
    	int mid = step / 2;
    	TreeNode left = sortedSubListToBST(head, mid);
    	int move = mid;
    	while (move > 0) {
    		head = head.next;
    		move = move - 1; 
    	}
    	TreeNode root = new TreeNode(head.val);
    	TreeNode right = sortedSubListToBST(head.next, step - mid - 1);
    	root.left = left;
    	root.right = right;
		return root;
	}
    
	public static void print(TreeNode root) {
		if (null != root) {
			System.out.println(root.val + "[" + (null == root.left ? "null" : root.left.val) + "," + (null == root.right ? "null" : root.right.val) + "]");
			print(root.left);
			print(root.right);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l0 = new ListNode(0);
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		l0.next = l1; l1.next = l2; l2.next = l3;
		print(sortedListToBST(l0));
	}

}
