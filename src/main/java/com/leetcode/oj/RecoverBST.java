/**
 * Source : 
 * Author : Hexiaoqiao
 * Date   : 2014-09-26
 *
 * 0.Problem:
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * Recover the tree without changing its structure.
 * Note:
 * A solution using O(n) space is pretty straight forward. Could you 
 * devise a constant space solution?
 * confused what "{1,#,2,3}" means? 
 * 
 * 1.Refer.:
 * 1.0 中序遍历二叉树；
 * 1.1 找到遍历的结果中不符合大小顺序的两个Node
 * 1.2 交换1.1中的两个Node
 */
package com.leetcode.oj;

import java.util.ArrayList;
import java.util.List;

public class RecoverBST {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
    public static void recoverTree(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<TreeNode>();
        traversal(root, nodes);
        for (TreeNode tn : nodes) {System.out.print(tn.val + " ");}
        int i = 0;
        int index1 = -1;
        int index2 = -1;
        for (i = 0; i < nodes.size() - 1; i++) {
        	if (nodes.get(i).val > nodes.get(i + 1).val) {
        		index1 = i; i++; break;
        	}
        }
        for (; i < nodes.size() - 1; i++) {
        	if (nodes.get(i).val > nodes.get(i + 1).val) {
        		index2 = i + 1; break;
        	}
        }
        if (-1 == index1) return;
        if (-1 == index2) index2 = index1 + 1;   
        TreeNode r1 = nodes.get(index1);
        TreeNode r2 = nodes.get(index2);
        int val = r1.val;
        r1.val = r2.val;
        r2.val = val;
        nodes.clear();
        traversal(root, nodes);
        System.out.println();
        for (TreeNode tn : nodes) {System.out.print(tn.val + " ");}
    }
    
    public static void traversal(TreeNode root, List<TreeNode> nodes) {
    	if (null == root) return;
    	traversal(root.left, nodes);
    	nodes.add(root);
    	traversal(root.right, nodes);
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		t2.left = t3;
		//t3.right = t5;
		t2.right = t1;
		//t2.right = t4;
		recoverTree(t2);
	}

}
