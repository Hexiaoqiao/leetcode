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
        /*Map<TreeNode, TreeNode> parent = new HashMap<TreeNode, TreeNode>();
        if (null != root) parent.put(root, null);
        traversal(root, nodes, parent);*/
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
        /*TreeNode left = r1.left;
        TreeNode right = r1.right;
        r1.left = r2.left;
        r1.right = r2.right;
        r2.left = left;
        r2.right = right;
        TreeNode p1 = parent.get(r1);
        TreeNode p2 = parent.get(r2);*/
        
/*      for (TreeNode tn : nodes) {System.out.println(tn.val);}
        Set<TreeNode> keys = parent.keySet();
        for (TreeNode k : keys) System.out.println(k.val + ":" + ((null == parent.get(k)) ? "" : parent.get(k).val));*/
    }
    
    public static void traversal(TreeNode root, List<TreeNode> nodes/*, Map<TreeNode, TreeNode> parent*/) {
    	if (null == root) return;
    	traversal(root.left, nodes/*, parent*/);
    	//if (null != root.left) parent.put(root.left, root);
    	nodes.add(root);
    	traversal(root.right, nodes/*, parent*/);
    	//if (null != root.right) parent.put(root.right, root);
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
