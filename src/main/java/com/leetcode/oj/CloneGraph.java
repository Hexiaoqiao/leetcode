/**
 * Source : 
 * Author : Hexiaoqiao
 * Date   : 2014-09-26
 *
 * 0.Problem:
 * Clone an undirected graph. Each node in the graph contains a label and 
 * a list of its neighbors.
 * 
 * OJ's undirected graph serialization:
 * Nodes are labeled uniquely.
 * 
 * We use # as a separator for each node, and , as a separator for node 
 * label and each neighbor of the node.
 * As an example, consider the serialized graph {0,1,2#1,2#2,2}.
 * 
 * The graph has a total of three nodes, and therefore contains three parts 
 * as separated by #.
 * 
 * First node is labeled as 0. Connect node 0 to both nodes 1 and 2.
 * Second node is labeled as 1. Connect node 1 to node 2.
 * Third node is labeled as 2. Connect node 2 to node 2 (itself), thus 
 * forming a self-cycle.
 * Visually, the graph looks like the following:
 * 
 *        1
 *       / \
 *      /   \
 *     0 --- 2
 *          / \
 *          \_/
 *          
 * 1.Refer.:
 * 1.0 图遍历：为每个当前节点增加一个邻居节点是当前节点的副本；
 * 1.1 按照原图关系链接副本节点之间的链接；
 * 1.2 删除原图和副本之间的邻居关系；
 */
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
		
		a.neighbors.add(b);
		a.neighbors.add(c);
		a.neighbors.add(d);
		b.neighbors.add(c);
		b.neighbors.add(e);
		c.neighbors.add(d);
		c.neighbors.add(e);
		c.neighbors.add(f);
		d.neighbors.add(f);
		e.neighbors.add(f);
		
		print(a);
		UndirectedGraphNode r = cloneGraph(null);
		print(r);
	}

}
