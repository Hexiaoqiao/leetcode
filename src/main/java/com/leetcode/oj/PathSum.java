package com.leetcode.oj;

import java.util.ArrayList;
import java.util.List;

public class PathSum {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public static List<List<Integer>> res = new ArrayList<List<Integer>>();
	public static List<Integer> stack = new ArrayList<Integer>();
		
    public static void traversal(TreeNode root, int sum) {
    	if (null == root) return;
    	if (null == root.left && null == root.right && sum == root.val) {
    		stack.add(root.val);
    		List<Integer> items = new ArrayList<Integer>();
    		for (Integer i : stack) {
    			items.add(i);
    		}
    		res.add(items);
    	} else {
    		stack.add(root.val);
    		traversal(root.left, sum - root.val);
    		traversal(root.right, sum - root.val);
    	}
    	stack.remove(stack.size() - 1);
        return;
    }
    
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
    	traversal(root, sum);
    	return res;
    }
    
	public static boolean hasPathSum(TreeNode root, int sum) {
		if (null != root && null == root.left && null == root.right && sum == root.val) {
			return true;
		} else if (null != root) {
			if (null != root.left && hasPathSum(root.left, sum - root.val)) {
				return true;
			} else if (null != root.right && hasPathSum(root.right, sum - root.val)) {
				return true;
			}
		}
		return false;
    }

    public static void print(TreeNode root) {
    	if (null != root) {
    		System.out.println(root.val);
    		print(root.left);
    		print(root.right);
    	}
    }
    public static void print(List<List<Integer>> res) {
		for (List<Integer> l : res) {
			System.out.print("[");
			for (Integer i : l) {
				System.out.print(i + ",");
			}
			System.out.println("]");
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
		TreeNode t4 = new TreeNode(7);
		TreeNode t5 = new TreeNode(8);
		TreeNode t6 = new TreeNode(7);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		t3.left = t6;
		print(t1);
		print(pathSum(t1, 9));
	}

}
