/**
 * Source : http://oj.leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
 *			http://oj.leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * Author : Hexiaoqiao
 * Date   : 2014-09-26
 *
 * 0.Problem:
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * 
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 * 1.Refer.:
 * inorder+postorder:
 * 0)postorder[size-1] = inorder[x]; -> root
 * 1)
 * (inorder(0,x-1),postorder(0,x-1)) -> left
 * (inorder(x+1,size),postorder(x,size-1)) -> right
 * 
 * preorder+inorder:
 * 0)preorder[0] = inorder[x]; -> root
 * 1)
 * (inorder(0,x-1),preorder(1,x+1)) -> left
 * (inorder(x+1,size),preorder(x+2,size)) -> right
 */
package com.leetcode.oj;

public class ConstructBinaryTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public static TreeNode buildTree(int[] inorder, int istart, int iend, int[] postorder, int pstart, int pend) {
    	if (iend - istart != pend - pstart) return null;
    	if (null == inorder || 0 == iend - istart) return null;
    	TreeNode root = new TreeNode(postorder[pend - 1]);
    	int is = istart;
    	int ps = pstart;
    	int ie = 0;
    	int pe = 0;
    	int step = 0;
    	for (int i = istart; i < iend; i++) {
    		if (inorder[i] == postorder[pend - 1]) {
    			break;
    		}
    		step = step + 1;
    	}
    	ie = is + step;
    	pe = ps + step;
    	TreeNode left = buildTree(inorder, is, ie, postorder, ps, pe);
    	TreeNode right = buildTree(inorder, ie + 1, iend, postorder, pe, pend - 1);
    	root.left = left;
    	root.right = right;
        return root;
    }
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
    	return buildTree(inorder, 0, inorder.length, postorder, 0, postorder.length);
    }
    
    public static TreeNode buildTree1(int[] preorder, int pstart, int pend, int[] inorder, int istart, int iend) {
    	if (pend - pstart != iend - istart) return null;
    	if (null == preorder || 0 == pend - pstart) return null;
    	TreeNode root = new TreeNode(preorder[pstart]);
    	int ps = pstart;
    	int is = istart;
    	int pe = 0;
    	int ie = 0;
    	int step = 0;
    	for (int i = istart; i < iend; i++) {
    		if (inorder[i] == preorder[pstart]) {
    			break;
    		}
    		step = step + 1;
    	}
    	pe = ps + step + 1;
    	ie = is + step;
    	TreeNode left = buildTree1(preorder, ps + 1, pe, inorder, is, ie);
    	TreeNode right = buildTree1(preorder, pe, pend, inorder, ie + 1, iend);
    	root.left = left;
    	root.right = right;
    	return root;
    }
    
    public static TreeNode buildTree1(int[] preorder, int[] inorder) {
    	return buildTree1(preorder, 0, preorder.length, inorder, 0, inorder.length);
    }
    
    public static void print(TreeNode root) {
    	if (null != root) {
    		System.out.println(root.val);
    		print(root.left);
    		print(root.right);
    	}
    }
    
    public static int max(int a, int b) {
    	return a > b ? a : b;
    }
    public static int maxDepth(TreeNode root) {
        if (null == root) return 0;
        return 1 + max(maxDepth(root.left), maxDepth(root.right));
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] preorder = {0,1,3,2,0};
		int[] inorder = {3,1,0,2,0};
		int[] postorder = {3,1,0,2,0};
		print(buildTree(inorder, postorder));
		print(buildTree1(preorder, inorder));
		System.out.println(maxDepth(null));
	}

}
