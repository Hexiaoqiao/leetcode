/**
 * Source : http://oj.leetcode.com/problems/binary-tree-postorder-traversal
 * Author : Hexiaoqiao
 * Date   : 2014-09-26
 *
 * 0.Problem:
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * 
 * For example:
 * Given binary tree {1,#,2,3},
 *    1
 *     \
 *      2
 *     /
 *    3
 * return [3,2,1].
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 * 
 * 1.Refer.: 栈+遍历记录
 * 1.0 若当前节点非空沿着左子树到头并压栈，记录初次访问；
 * 1.1 出栈一个元素:
 * 	0)如果当前节点仅经过初次访问，重新压栈并标记其非初次访问，并指向其右子树；
 * 	1)如果当前节点非初次访问，进入结果队列中；标记当期那节点为空；
 * 1.2 重复上述步骤；
 */
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
