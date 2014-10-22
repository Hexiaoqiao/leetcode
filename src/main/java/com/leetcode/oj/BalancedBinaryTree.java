/**
 * Source : http://oj.leetcode.com/problems/balanced-binary-tree
 * Author : Hexiaoqiao
 * Date   : 2014-09-26
 *
 * 0.Problem:
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined 
 * as a binary tree in which the depth of the two subtrees of 
 * every node never differ by more than 1.
 * 
 * 1.Refer.:
 * 1.0递归左右子树
 * 1.1左右子树高度差值小于2；
 */
package com.leetcode.oj;

public class BalancedBinaryTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public static int max(int a, int b) {
		return a > b ? a : b;
	}
	
    public static boolean isBalanced(TreeNode root) {
    	if (null == root) {
    		return true;
    	}
    	if (isBalanced(root.left) && isBalanced(root.right)) {
    		int diff = getHeight(root.left) - getHeight(root.right);
    		if (diff < 2 && diff > -2) {
    			return true;
    		} else {
    			return false;
    		}
    	}
    	return false;
    }
    
    public static int getHeight(TreeNode root) {
    	if (null == root) return 0; 
    	return max(getHeight(root.left), getHeight(root.right)) + 1;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode t1 = new TreeNode(0);
		TreeNode t2 = new TreeNode(1);
		TreeNode t3 = new TreeNode(2);
		TreeNode t4 = new TreeNode(3);
		TreeNode t5 = new TreeNode(4);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t4.left = t5;
		System.out.println(isBalanced(t1));
	}

}
