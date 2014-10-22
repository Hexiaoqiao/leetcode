/**
 * Source : http://oj.leetcode.com/problems/validate-binary-search-tree
 * Author : Hexiaoqiao
 * Date   : 2014-09-26
 *
 * 0.Problem:
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * 
 * 1.Refer.:
 * 分治
 * 给每棵子树一个最大和最小值的限定，然后递归子树进行validBST检查
 */
package com.leetcode.oj;

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
