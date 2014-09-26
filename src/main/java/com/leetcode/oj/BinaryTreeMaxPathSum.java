package com.leetcode.oj;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeMaxPathSum {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
    public static int maxPathSum(TreeNode root) {
    	if (null == root) return 0;
    	int left = maxPathSum(root.left);
    	int right = maxPathSum(root.right);
    	int r = maxPathSumWithRoot(root);
    	int max = left;
    	max = max < right ? right : max;
    	max = max < r ? r : max;
    	return max;
    }
    
    public static int maxPathSumWithRoot(TreeNode root) {
    	if (null == root) return 0;
    	int left = 0;
    	int right = 0;
    	int res = root.val;
    	if (null != root.left) left = maxSinglePathSumWithRoot(root.left);
    	if (null != root.right) right = maxSinglePathSumWithRoot(root.right);
    	if (left > 0) res = res + left;
    	if (right > 0) res = res + right; 
    	return res;
    }
    
    public static int maxSinglePathSumWithRoot(TreeNode root) {
    	int left = 0;
    	int right = 0;
    	if (null != root.left) left = maxSinglePathSumWithRoot(root.left);
    	if (null != root.right) right = maxSinglePathSumWithRoot(root.right);
    	if (left > right) return root.val + left;
    	else return root.val + right;
    }
    
    public static int maxPathSum1(TreeNode root) {
    	if (null == root) return 0;
    	List<Integer> max = new ArrayList<Integer>();
    	maxSinglePathSum(root, max);
    	int res = root.val;
    	for (Integer i : max) {
    		if (i > res) res = i;
    	}
    	return res;
    }
    
    public static int maxSinglePathSum(TreeNode root, List<Integer> max) {
    	if (null == root) return 0;
    	int left = maxSinglePathSum(root.left, max);
    	int right = maxSinglePathSum(root.right, max);
    	int m = root.val;
    	m = m < left + root.val ? left + root.val : m;
    	m = m < right + root.val ? right + root.val : m;
    	m = m < left + root.val + right ? left + root.val + right : m;
    	max.add(m);
    	int res = root.val;
    	res = res < left + root.val ? left + root.val : res;
    	res = res < right + root.val ? right + root.val : res;
    	return res;
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
		TreeNode t5 = new TreeNode(5);
		t2.left = t3;
		t2.right = t5;
		t3.left = t1;
		t3.right = t4;
		System.out.println(maxPathSum1(t2));
	}

}
