package com.leetcode.oj;

import java.util.ArrayList;
import java.util.List;

public class CloneGraph {
	public static class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;

		UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	};
	
    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    	List<UndirectedGraphNode> nodes = new ArrayList<UndirectedGraphNode>();
    	UndirectedGraphNode headnode = null;
    	int index = 0;
    	if (null == node) return null;
    	nodes.add(node);
    	while (index != nodes.size()) {
    		UndirectedGraphNode n = nodes.get(index);
    		UndirectedGraphNode newNode = new UndirectedGraphNode(n.label);
    		if (null == headnode) headnode = newNode; 
    		n.neighbors.add(newNode);
    		int size = n.neighbors.size();
    		for (int i = 0; i < size - 1; i++) {
    			UndirectedGraphNode neighbor = n.neighbors.get(i);
    			if (!(nodes.contains(neighbor))) nodes.add(neighbor);
    		}
    		index = index + 1;
    	}
    	for (UndirectedGraphNode rawnode : nodes) {
    		int size = rawnode.neighbors.size();
    		UndirectedGraphNode newNode = rawnode.neighbors.get(size - 1);
    		for (int i = 0; i < rawnode.neighbors.size() - 1; i++) {
    			UndirectedGraphNode neighbor = rawnode.neighbors.get(i);
    			int neighborlen = neighbor.neighbors.size();
    			newNode.neighbors.add(neighbor.neighbors.get(neighborlen - 1));
    		}
    	}
    	for (UndirectedGraphNode rawnode : nodes) {
    		int size = rawnode.neighbors.size();
    		rawnode.neighbors.remove(size - 1);
    	}
    	return headnode;
    }
    
    public static void print(UndirectedGraphNode node) {
    	if (null == node) return;
    	List<UndirectedGraphNode> nodes = new ArrayList<UndirectedGraphNode>();
    	int index = 0;
    	if (null != node)nodes.add(node);
    	while (index != nodes.size()) {
    		UndirectedGraphNode n = nodes.get(index);
    		System.out.print(n.label + "(");
    		for (UndirectedGraphNode neighbor : n.neighbors) {
    			if (!(nodes.contains(neighbor))) {
    				nodes.add(neighbor);
    			}
    			System.out.print(neighbor.label + ",");
    		}
    		System.out.println(")");
    		index = index + 1;
    	}
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UndirectedGraphNode a = new UndirectedGraphNode(0);
		UndirectedGraphNode b = new UndirectedGraphNode(1);
		UndirectedGraphNode c = new UndirectedGraphNode(2);
		UndirectedGraphNode d = new UndirectedGraphNode(3);
		UndirectedGraphNode e = new UndirectedGraphNode(4);
		UndirectedGraphNode f = new UndirectedGraphNode(5);
		
/*		a.neighbors.add(b);
		a.neighbors.add(c);
		a.neighbors.add(d);
		b.neighbors.add(c);
		b.neighbors.add(e);
		c.neighbors.add(d);
		c.neighbors.add(e);
		c.neighbors.add(f);
		d.neighbors.add(f);
		e.neighbors.add(f);*/
		
		print(a);
		UndirectedGraphNode r = cloneGraph(null);
		print(r);
	}

}
