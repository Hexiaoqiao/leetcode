package com.leetcode.oj;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergekSortedLists {
	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public static ListNode mergeKLists(List<ListNode> lists) {
		if (null == lists || 0 == lists.size()) return null; 
		ListNode h = null;
		ListNode p = null;
		ListNode[] ps = new ListNode[lists.size()];
		for (int i = 0; i < lists.size(); i++) {
			ps[i] = lists.get(i);
		}
		while (true) {
			ListNode min = null;
			int index = 0;
			boolean notallnull = false;
			for (int i = 0; i < ps.length; i++) {
				if (null == ps[i]) continue;
				else {
					notallnull = true;
					if (null == min) {
						min = ps[i];
						index = i;
					} else if (min.val > ps[i].val) {
						min = ps[i];
						index = i;
					}
				}
			}
			if (!notallnull) {
				break;
			}
			ps[index] = ps[index].next;
			if (null == h) {h = min; p = min;}
			else {p.next = min;p = p.next;}
		}
		if (null != p) p.next = null;
        return h;
    }
	
	public static ListNode mergeKLists2(List<ListNode> lists) {
		if (null == lists || 0 == lists.size()) return null;
		PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.size(), new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				// TODO Auto-generated method stub
				if (o1.val > o2.val) return 1;
				else if (o1.val < o2.val) return -1;
				return 0;
			}
		});
		for (ListNode ln : lists) {
			if (null != ln) pq.add(ln); 
		}
		ListNode h = null;
		ListNode p = null;
		while (null != pq && 0 < pq.size()) {
			ListNode elem = pq.poll();
			if (null == h) h = elem;
			if (null == p) p = elem;
			else {
				p.next = elem; p = p.next;
			}
			if (null != elem.next) pq.add(elem.next); 
		}
		return h;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(3);
		ListNode c = new ListNode(7);
		ListNode d = new ListNode(2);
		ListNode e = new ListNode(6);
		ListNode f = new ListNode(4);
		a.next = b;
		b.next = c;
		d.next = e;
		List<ListNode> lists = new ArrayList<ListNode>();
		//lists.add(null);
		lists.add(a); lists.add(d); lists.add(f);
		ListNode res = mergeKLists(lists);
		for (ListNode p = res; null != p; p = p.next) {
			System.out.println(p.val);
		}
	}

}
