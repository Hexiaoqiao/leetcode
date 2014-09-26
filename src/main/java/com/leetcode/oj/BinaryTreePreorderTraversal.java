package com.leetcode.oj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
