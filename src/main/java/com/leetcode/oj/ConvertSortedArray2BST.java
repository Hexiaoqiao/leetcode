/**
 * Source : http://oj.leetcode.com/problems/convert-sorted-array-to-binary-search-tree
 * Author : Hexiaoqiao
 * Date   : 2014-09-26
 *
 * 0.Problem:
 * Given an array where elements are sorted in ascending order, 
 * convert it to a height balanced BST.
 * 
 * 1.Refer.:
 * 1.0 取数组中间数字为root；
 * 1.1 root左边递归BST，root右边递归BST
 * 1.2 root-left，root-right组合
 */
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
