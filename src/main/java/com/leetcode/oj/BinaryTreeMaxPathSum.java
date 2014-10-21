/**
 * Source : 
 * Author : Hexiaoqiao
 * Date   : 2014-09-26
 *
 * 0.Problem:
 * Given a binary tree, find the maximum path sum.
 * 
 * The path may start and end at any node in the tree.
 * 
 * For example:
 * Given the below binary tree,
 * 
 *        1
 *       / \
 *      2   3
 * Return 6.
 * 
 * 1.Refer.:递归
 * 1.0.递归计算左子树maxPathSum:leftmax,rightmax
 * 1.1.步骤1.0分别返回左右子树到达其根的maxPathSum:childmax
 * 1.2.比较root.val,root.val+leftmax,root.val+rightmax,root.val+leftmax+rightmax
 * 为经过root的maxPathSum
 * 1.3.上述计算过程中产生的所有路径最大值即为结果
 * 
 */
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
		System.out.println(maxPathSum(t2));
	}

}
