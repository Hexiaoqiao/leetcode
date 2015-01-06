/**
 * Source : https://oj.leetcode.com/problems/binary-search-tree-iterator/
 * Author : Hexiaoqiao
 * Date   : 2015-01-06
 *
 * 0.Problem:
 * Implement an iterator over a binary search tree (BST). Your iterator 
 * will be initialized with the root node of a BST.Calling next() will 
 * return the next smallest number in the BST.
 * Note: next() and hasNext() should run in average O(1) time and uses 
 * O(h) memory, where h is the height of the tree.
 * 
 * 1.Refer.:
 * 通过栈做缓存进行中序遍历
 */
package com.leetcode.oj;

import java.util.Stack;

public class BSTIterator {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    
    private Stack<TreeNode> stack = new Stack<TreeNode>();
    
    public BSTIterator(TreeNode root) {
        pushstack(root);
    }
    
    private void pushstack(TreeNode node) {
        TreeNode tnode = node;
        while (null != tnode) {
            stack.push(tnode);
            tnode = tnode.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !(stack.isEmpty());
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode res = stack.pop();
        if (null != res) {
            pushstack(res.right);
            return res.val;
        }
        return -1;
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeNode n0 = new TreeNode(0);
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        n4.left = n2;n4.right = n6;
        n2.left = n1;n2.right = n3;
        n6.left = n5; n6.right = n7;
        n1.left = n0;
        BSTIterator iter = new BSTIterator(n4);
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

}
