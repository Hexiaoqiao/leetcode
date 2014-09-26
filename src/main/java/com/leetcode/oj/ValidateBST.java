package com.leetcode.oj;

import com.leetcode.oj.SymmetricTree.TreeNode;

public class ValidateBST {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public static boolean isValidBST(TreeNode root, int min, int max) {
		if (null == root) return true;
		if (root.val < min || root.val > max) return false;
		boolean isleft = isValidBST(root.left, min, root.val);
		boolean isright = isValidBST(root.right, root.val, max);
		return isleft && isright;
	}
	
	public static boolean isValidBST(TreeNode root) {
		return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
		
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode t1 = new TreeNode(8);
		TreeNode t2 = new TreeNode(5);
		TreeNode t3 = new TreeNode(Integer.MAX_VALUE);
		TreeNode t4 = new TreeNode(Integer.MIN_VALUE);
		TreeNode t5 = new TreeNode(9);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t3.left = t5;
		System.out.println(isValidBST(t1));
	}

}
