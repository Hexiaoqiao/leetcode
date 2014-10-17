/*
0.Problem:
Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?

1.Refer.:
1.0 Implementation it iteratively later.
*/
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
