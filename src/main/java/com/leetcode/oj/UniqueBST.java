/*
0.Problem:
0.0
Given n, how many structurally unique BST's (binary search trees) that 
store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

0.1
Given n, generate all structurally unique BST's (binary search trees) that 
store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3

1.Refer.:
1.0 DP
numTrees[i] = sum(numTrees[i-j] * numTrees[j]) - j=0..i

1.1 分治（start,end）
1.1.0 取i[start,end)为当前根节点
1.1.1 分别就[start,i)，[i,end)构造左右子树
1.1.2 左右子树的笛卡尔集合
*/
package com.leetcode.oj;

import java.util.ArrayList;
import java.util.List;

public class UniqueBST {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
			left = null;
			right = null;
		}
	}
	
    public static List<TreeNode> generateTrees(int n) {
    	return generateTrees(0, n);
    }
    
    public static List<TreeNode> generateTrees(int start, int end) {
    	if (start >= end) {
    		List<TreeNode> res = new ArrayList<TreeNode>();
    		res.add(null);
    		return res;
    	}
    	if (1 == end - start) {
    		List<TreeNode> res = new ArrayList<TreeNode>();
    		res.add(new TreeNode(start + 1));
    		return res;
    	}
    	List<TreeNode> res = new ArrayList<TreeNode>();
    	for (int i = start; i < end; i++) {
    		List<TreeNode> left = generateTrees(start, i);
    		List<TreeNode> right = generateTrees(i + 1, end);
    		if (null == right && null == left) {
    			TreeNode root = new TreeNode(start + 1);
    			res.add(root);
    		} else if (null == left) {
    			for (TreeNode r : right) {
    				TreeNode root = new TreeNode(i + 1);
    				root.right = r;
    				res.add(root);
    			}
    		} else if (null == right) {
    			for (TreeNode l : left) {
    				TreeNode root = new TreeNode(i + 1);
    				root.left = l;
    				res.add(root);
    			}
    		} else {
	    		for (TreeNode l : left) {
	    			for (TreeNode r : right) {
	    				TreeNode root = new TreeNode(i + 1);
	    				root.left = l;
	    				root.right = r;
	    				res.add(root);
	    			}
	    		}
    		}
    	}
        return res;
    }
	
    public static int numTrees(int n) {
    	if (n < 0) return 0;
    	if (0 == n || 1 == n) return 1;
    	int[] result = new int[n + 1];
    	result[0] = 1; result[1] = 1;
    	for (int i = 2; i < n + 1; i++) {
        	for (int j = 0; j < i; j++) {
        		result[i] = result[i] + result[j] * result[i - j - 1];
        	}
    	}
        return result[n];
    }
    
	public static void print(TreeNode root) {
		if (null != root) {
			System.out.println(root.val + "["
					+ (null == root.left ? "null" : root.left.val) + ","
					+ (null == root.right ? "null" : root.right.val) + "]");
			print(root.left);
			print(root.right);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(numTrees(19));
		List<TreeNode> trees = generateTrees(4);
		for(TreeNode root : trees) {
			print(root);
			System.out.println("---------");
		}
	}

}
