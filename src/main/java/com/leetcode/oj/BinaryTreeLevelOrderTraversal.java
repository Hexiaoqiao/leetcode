package com.leetcode.oj;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<TreeNode> stack = new ArrayList<TreeNode>();
        int start = 0;
        int end = 0;
        if (null != root) {stack.add(root);end = 1;}
        while (end > start) {
        	List<Integer> level = new ArrayList<Integer>();
        	for (int i = start; i < end; i++) {
        		TreeNode node = stack.get(i);
        		level.add(node.val);
        		if (null != node.left) {
        			stack.add(node.left);
        		}
        		if (null != node.right) {
        			stack.add(node.right);
        		}
        	}
        	res.add(0, level);
        	start = end;
        	end = stack.size();
        }
    	return res;
    }
    
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<TreeNode> stack = new ArrayList<TreeNode>();
        int start = 0;
        int end = 0;
        if (null != root) {stack.add(root);end = 1;}
        boolean l2r = true;
        while (end > start) {
        	List<Integer> level = new ArrayList<Integer>();
        	for (int i = start; i < end; i++) {
        		TreeNode node = stack.get(i);
        		if (l2r) {
        			level.add(node.val);
        		} else {
        			level.add(0, node.val);
				}
        		if (null != node.left) {
        			stack.add(node.left);
        		}
        		if (null != node.right) {
        			stack.add(node.right);
        		}
        	}
        	res.add(level);
        	start = end;
        	end = stack.size();
        	l2r = l2r ? false : true;
        }
    	return res;
    }
    
    public static List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<TreeNode> stack = new ArrayList<TreeNode>();
        int start = 0;
        int end = 0;
        if (null != root) {stack.add(root);end = 1;}
        while (end > start) {
        	List<Integer> level = new ArrayList<Integer>();
        	for (int i = start; i < end; i++) {
        		TreeNode node = stack.get(i);
        		level.add(node.val);
        		if (null != node.left) {
        			stack.add(node.left);
        		}
        		if (null != node.right) {
        			stack.add(node.right);
        		}
        	}
        	res.add(level);
        	start = end;
        	end = stack.size();
        }
    	return res;
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
		TreeNode t4 = new TreeNode(3);
		TreeNode t5 = new TreeNode(4);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		print(levelOrder(t1));
	}

}
