/*
0.Problem:
Given a binary tree, find its minimum depth.
The minimum depth is the number of nodes along the shortest path 
from the root node down to the nearest leaf node.

1.Refer.:
递归计算左右子树的最少节点数+1即为结果
*/
package com.leetcode.oj;

public class MinimumDepthofBinaryTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
    public static int minDepth(TreeNode root) {
        if (null == root) return 0;
        else if (null == root.left && null == root.right) return 1;
        else if (null == root.left) return minDepth(root.right) + 1;
        else if (null == root.right) return minDepth(root.left) + 1;
        else {
        	int l = minDepth(root.left);
        	int r = minDepth(root.right);
        	return l > r ? r + 1 : l + 1;
        }
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
