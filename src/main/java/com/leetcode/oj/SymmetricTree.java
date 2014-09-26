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
