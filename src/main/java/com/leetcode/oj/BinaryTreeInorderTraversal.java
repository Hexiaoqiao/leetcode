package com.leetcode.oj;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	List<Integer> result = new ArrayList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root) {
    	if (null != root) {
    		inorderTraversal(root.left);
    		result.add(root.val);
    		inorderTraversal(root.right);
    	}
        return result;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
