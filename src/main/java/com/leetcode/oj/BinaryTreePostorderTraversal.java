package com.leetcode.oj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryTreePostorderTraversal {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public static List<Integer> postorderTraversal(TreeNode root) {
		List<TreeNode> stack = new ArrayList<TreeNode>();
		List<Integer> res = new ArrayList<Integer>();
		Map<TreeNode, Boolean> isFirstTraversal = new HashMap<TreeNode, Boolean>();
		TreeNode node = root;
		while (null != node || 0 != stack.size()) {
			while (null != node) {
				stack.add(node);
				isFirstTraversal.put(node, Boolean.TRUE);
				node = node.left;
			}
			if (0 != stack.size()) {
				int size = stack.size();
				TreeNode cn = stack.remove(size - 1);
				if (isFirstTraversal.get(cn) == Boolean.TRUE) {
					isFirstTraversal.put(cn, Boolean.FALSE);
					stack.add(cn);
					node = cn.right;
				} else {
					res.add(cn.val);
					node = null;
				}
			}
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
		t1.right = t2;
		t2.left = t3;
		t3.right = t4;
		List<Integer> res = postorderTraversal(t1);
		for(Integer i : res) {
			System.out.println(i);
		}
	}

}
