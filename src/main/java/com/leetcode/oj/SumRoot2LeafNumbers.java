package com.leetcode.oj;

public class SumRoot2LeafNumbers {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	public static int traversal(TreeNode node, int prefix) {
		if (null != node) {
			if (null == node.left && null == node.right) {
				return prefix * 10 + node.val;
			} else if (null == node.left) {
				return traversal(node.right, prefix * 10 + node.val);
			} else if (null == node.right) {
				return traversal(node.left, prefix * 10 + node.val);
			} else {
				return traversal(node.left, prefix * 10 + node.val) + traversal(node.right, prefix * 10 + node.val);
			}
		} 
		return prefix;
	}
    public static int sumNumbers(TreeNode root) {
    	return traversal(root, 0);
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		t1.left = t2;
		t2.left = t3;
		t3.right = t4;
		System.out.println(sumNumbers(t1));
	}

}
