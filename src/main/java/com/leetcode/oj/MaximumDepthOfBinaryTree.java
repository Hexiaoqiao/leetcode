/**
 * Source : https://oj.leetcode.com/problems/maximum-depth-of-binary-tree/
 * Author : Hexiaoqiao
 * Date   : 2014-09-26
 *
 * 0.Problem:
 * Given a binary tree, find its maximum depth.
 * The maximum depth is the number of nodes along the longest path 
 * from the root node down to the farthest leaf node.
 * 
 * 1.Refer.:
 * 递归计算左右子树的最深+1即为结果
 */
package com.leetcode.oj;

public class MaximumDepthOfBinaryTree {
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
    public static int maxDepth(TreeNode root) {
        if (null == root) return 0;
        return 1 + max(maxDepth(root.left), maxDepth(root.right));
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
