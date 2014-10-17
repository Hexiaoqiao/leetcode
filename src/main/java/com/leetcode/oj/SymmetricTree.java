/*
0.Problem:
0.0
Given a binary tree, check whether it is a mirror of itself 
(ie, symmetric around its center).
For example, this binary tree is symmetric:
    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.

0.1
Given two binary trees, write a function to check if they are equal or not.
Two binary trees are considered equal if they are structurally identical 
and the nodes have the same value.

1.Refer.:
1.0 递归
1.1 递归
*/
package com.leetcode.oj;

public class SymmetricTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public static boolean isSymmetric(TreeNode root1, TreeNode root2) {
		if (null == root1 && null == root2) return true;
		if (null == root1 || null == root2) return false;
		return root1.val == root2.val && isSymmetric(root1.left, root2.right) && isSymmetric(root1.right, root2.left);
	}
	
    public static boolean isSymmetric(TreeNode root) {
        if (null == root) return true;
        if (null == root.left && null == root.right) return true;
        return isSymmetric(root.left, root.right);
    }
    
    public static boolean isSameTree(TreeNode p, TreeNode q) {
    	if (null == p && null == q) return true;
    	if (p == q) return true;
    	if (null == p || null == q) return false;
    	return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode t1 = new TreeNode(0);
		TreeNode t2 = new TreeNode(1);
		TreeNode t3 = new TreeNode(1);
		TreeNode t4 = new TreeNode(2);
		TreeNode t5 = new TreeNode(2);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t3.left = t5;
		System.out.println(isSameTree(t4, null));
	}

}
