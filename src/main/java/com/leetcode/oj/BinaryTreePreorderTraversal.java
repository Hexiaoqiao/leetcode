/*
0.Problem:
Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?

1.Refer.: 栈
1.0 若当前节点非空，访问并入栈；
1.1 沿左子树向下到头访问并入栈；
1.2 出栈一个节点，当前节点移至其有子树；
1.3 重复上述步骤；
*/
package com.leetcode.oj;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public static List<Integer> preorderTraversal(TreeNode root) {
		List<TreeNode> stack = new ArrayList<TreeNode>();
		List<Integer> res = new ArrayList<Integer>();
		TreeNode node = root;
		while (null != node || 0 != stack.size()) {
			while (null != node) {
				res.add(node.val);
				stack.add(node);
				node = node.left;
			}
			int size = stack.size();
			node = stack.remove(size - 1);
			node = node.right;
		}
		return res;
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
		//t1.left = t2;
		t2.left = t3;
		t3.left = t4;
		t4.left = t5;
		List<Integer> res = preorderTraversal(t1);
		for(Integer i : res) {
			System.out.println(i);
		}
	}
}
