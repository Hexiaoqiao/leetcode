package com.leetcode.oj;

import java.util.HashMap;
import java.util.Map;


public class LRUCache {
	public class Node {
		int key = 0;
		int value = 0;
		Node prevous = null;
		Node next = null;
		
		public Node (int key, int value) {
			this.key = key;
			this.value = value;
		}
	}
	public class DoubleLinkedList {
		Node head = null;
		
		public DoubleLinkedList() {}
		
		public DoubleLinkedList(Node n) {
			this.head = n;
		}
		
		public void add(Node node) {
			if (null == head) {
				node.next = node;
				node.prevous = node;
				head = node;
				return;
			}
			node.next = head;
			node.prevous = head.prevous;
			node.next.prevous = node;
			node.prevous.next = node;
			head = node;
		}
		
		public Node remove(Node node) {
			if (null == node) return node;
			if (head == node && head.next == head) {head = null;}
			else {
				node.prevous.next = node.next;
				node.next.prevous = node.prevous;
				if (head == node) {
					head = node.next;
				}
				node.next = null;
				node.prevous = null;
			}
			return node;
		}
		
		public Node removeEnd() {
			return this.remove(head.prevous);
		}
		
		public void print() {
			Node n = head;
			while (null != n) {
				System.out.print("<key="+n.key+",value="+n.value+"> ");
				n = n.next;
				if (null == n || n == head) break;
			}
			System.out.println();
		}
	}
	
	private Map<Integer, Node> map = null;
	private DoubleLinkedList dlist = null;
	private int capacity = 0;
	
	public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, Node>();
        dlist = new DoubleLinkedList();
    }
    
    public int get(int key) {
    	Node node = this.map.get(key);
    	if (null == node) {return -1;}
    	else {
    		Node n = dlist.remove(node);
    		dlist.add(n);
    	}
    	return node.value;
    }
    
    public void set(int key, int value) {
    	Node node = map.get(key);
    	if (capacity == map.size()) {
    		if (null == node) {
    			Node rmn = dlist.removeEnd();
    			map.remove(rmn.key);
    			Node n = new Node(key, value);
    			dlist.add(n);
    			map.put(key, n);
    		} else {
    			Node n = dlist.remove(node);
    			map.remove(key);
    			n.value = value;
    			dlist.add(n);
    			map.put(key, n);
    		}
    	} else {
    		if (null == node) {
    			Node n = new Node(key, value);
    			dlist.add(n);
    			map.put(key, n);
    		} else {
    			Node n = dlist.remove(node);
    			n.value = value;
    			dlist.add(n);
    		}
    	}
    	print();
    }
    
    public void print() {
    	dlist.print();
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//4 3 4 2 3 1 4 2
		LRUCache lru = new LRUCache(1);
/*		lru.set(4, 4);
		lru.set(3, 3);
		lru.get(4);
		lru.set(4, 4);
		lru.set(2, 2);
		lru.set(3, 3);
		lru.set(1, 1);
		lru.set(4, 4);
		lru.set(2, 2);*/
		lru.set(2, 1);
		System.out.println(lru.get(2));
	}

}
