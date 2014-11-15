/**
 * Source : https://oj.leetcode.com/problems/min-stack/
 * Author : Hexiaoqiao
 * Date   : 2014-11-15
 *
 * 0.Problem:
 * Design a stack that supports push, pop, top, and retrieving the 
 * minimum element in constant time.
 * - push(x) -- Push element x onto stack.
 * - pop() -- Removes the element on top of the stack.
 * - top() -- Get the top element.
 * - getMin() -- Retrieve the minimum element in the stack.
 * 
 * 1.Refer.:链表节点中增加当前节点之前的最小值
 */
package com.leetcode.oj;

class Node {
	private int value;
	private int min;
	private Node next;
	
	public Node(int val, int m) {
		this.value = val;
		this.min = m;
		this.next = null;
	}
	
	public Node(int val) {
		this.value = val;
		this.min = 0;
		this.next = null;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public int getMin() {
		return this.min;
	}
	
	public void setMin(int m) {
		this.min = m;
	}
	
	public Node getNext() {
		return this.next;
	}
	
	public void setNext(Node n) {
		this.next = n;
	}
}

public class MinStack {
	Node head = null;
	
    public void push(int x) {
        if (null == head) {
        	head = new Node(x);
        	head.setMin(x);
        } else {
        	Node node = new Node(x);
        	int min = head.getMin();
        	min = min > x ? x : min;
        	node.setMin(min);
        	node.setNext(head);
        	head = node;
        }
    }

    public void pop() {
    	if (null != head) {
            head = head.getNext();
    	}
    }

    public int top() {
    	if (null != head) {
    		return head.getValue();
    	}
        return 0;
    }

    public int getMin() {
    	if (null != head) {
    		return head.getMin();
    	}
        return 0;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinStack ms = new MinStack();
		System.out.println(ms.top());
		System.out.println(ms.getMin());
		ms.pop();
		ms.push(1);
		ms.push(2);
		System.out.println(ms.top());
		System.out.println(ms.getMin());
		ms.pop();
		System.out.println(ms.top());
		ms.pop();
		ms.push(6);
		System.out.println(ms.top());
		System.out.println(ms.getMin());
		ms.push(5);
		ms.push(4);
		System.out.println(ms.top());
		System.out.println(ms.getMin());
	}

}
