/**
 * Source : 
 * Author : Hexiaoqiao
 * Date   : 2014-09-26
 *
 * 0.Problem:
 * Given a binary tree, flatten it to a linked list in-place.
 * 
 * For example,
 * Given
 * 
 *          1
 *         / \
 *        2   5
 *       / \   \
 *      3   4   6
 * The flattened tree should look like:
 *    1
 *     \
 *      2
 *       \
 *        3
 *         \
 *          4
 *           \
 *            5
 *             \
 *              6
 * 
 * 1.Refer.:
 * 二叉树先序遍历
 */
package com.leetcode.oj;

public class FlattenBinaryTree2LinkedList {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
    public static void flatten(TreeNode root) {
    	preorder(root);
    }
    
    public static TreeNode preorder(TreeNode root) {
    	if (null != root) {
    		if (null == root.left && null == root.right) return root; 
    		TreeNode right = root.right;
    		TreeNode leftend = null;
    		if (null != root.left) {
    			leftend = preorder(root.left);
    			root.right = root.left;
    			root.left = null;
    		}
    		TreeNode rightend = preorder(right);
    		if (null != leftend) {
    			leftend.right = right;
    		} 
    		if (null != rightend) {
    			return rightend;
    		} else if (null != leftend) {
    			return leftend;
    		} else {
    			return rightend;
    		}
    	}
    	return null;
    }
    
    public static void print(TreeNode root) {
    	if (null != root) {
    		System.out.println(root.val);
    		print(root.left);
    		print(root.right);
    	}
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
		t2.right = t5;
		print(t1);
		flatten(t1);
		print(t1);
	}

}
