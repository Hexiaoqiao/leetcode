package com.leetcode.oj;

public class ConvertSortedArray2BST {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public static TreeNode sortedArrayToBST(int[] num) {
        return sortedSubArrayToBST(num, 0, num.length);
    }
	
	public static TreeNode sortedSubArrayToBST(int[] num, int start, int end) {
		TreeNode root = null;
		if (end - start > 0) {
			int index = start + (end - start) / 2;
			root = new TreeNode(num[index]);
			TreeNode left = sortedSubArrayToBST(num, start, index);
			TreeNode right = sortedSubArrayToBST(num, index + 1, end);
			root.left = left;
			root.right = right;
			return root;
		}
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
		int[] num = {0,1,2};
		print(sortedArrayToBST(num));
	}

}