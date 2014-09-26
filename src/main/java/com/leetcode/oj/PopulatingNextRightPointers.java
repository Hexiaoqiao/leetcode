package com.leetcode.oj;

public class PopulatingNextRightPointers {
	public static class TreeLinkNode {
		int val;
		TreeLinkNode left, right, next;

		TreeLinkNode(int x) {
			val = x;
		}
	}
	
    public static void connect(TreeLinkNode root) {
        if (null == root) return;
        TreeLinkNode parent = root;
        TreeLinkNode node = null;
        while (null != parent.left) {
        	node = parent;
        	while (null != node) {
	        	node.left.next = node.right;
	        	if (null != node.next) node.right.next = node.next.left;
	        	node = node.next;
        	}
        	parent = parent.left;
        }
    }
	
    public static void connect1(TreeLinkNode root) {
        TreeLinkNode head = null;
        TreeLinkNode prev = null;
        TreeLinkNode cur = root;
        while (cur != null) {
            while (cur != null) {
                if (cur.left != null) {
                    if (prev != null) {
                        prev.next = cur.left;
                    } else {
                        head = cur.left;
                    }
                    prev = cur.left;
                }
                if (cur.right != null) {
                    if (prev != null) {
                        prev.next = cur.right;
                    } else {
                        head = cur.right;
                    }
                    prev = cur.right;
                }
                cur = cur.next;
            }
            cur = head;
            head = null;
            prev = null;
        }
    }
    
    public static void print(TreeLinkNode node) {
    	if (null != node) {
    		System.out.print(node.val);
    		System.out.print("[");
    		if (null == node.left) {
    			System.out.print("null");
    		} else {
    			System.out.print(node.left.val);
    		}
    		System.out.print(",");
    		if (null == node.right) {
    			System.out.print("null");
    		} else {
    			System.out.print(node.right.val);
    		}
    		System.out.print(",");
    		if (null == node.next) {
    			System.out.print("null");
    		} else {
    			System.out.print(node.next.val);
    		}
    		System.out.println("]");
    		print(node.left);
    		print(node.right);
    	}
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeLinkNode n0 = new TreeLinkNode(0);
		TreeLinkNode n1 = new TreeLinkNode(1);
		TreeLinkNode n2 = new TreeLinkNode(2);
		TreeLinkNode n3 = new TreeLinkNode(3);
		TreeLinkNode n4 = new TreeLinkNode(4);
		TreeLinkNode n5 = new TreeLinkNode(5);
		TreeLinkNode n6 = new TreeLinkNode(6);
		n0.left = n1; n0.right = n2;
		n1.left = n3; n2.right = n4;
		n3.left = n5; n3.right = n6;
		print(n0);
		connect1(n0);
		print(n0);
	}

}
