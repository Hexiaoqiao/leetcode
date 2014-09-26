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
