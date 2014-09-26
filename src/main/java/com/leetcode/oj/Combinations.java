package com.leetcode.oj;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static void print(List<List<Integer>> a) {
    	for (List<Integer> l : a) {
    		for (Integer i : l) {
    			System.out.print(i + " ");
    		}
    		System.out.println();
    	}
    }
    
    public static List<List<Integer>> combine(int n, int k) {
    	if (0 == k || k > n) return null;
    	if (k == n) {
    		 List<List<Integer>> res = new ArrayList<List<Integer>>();
    		 List<Integer> l = new ArrayList<Integer>();
    		 for (int i = 1; i <= n; i++) {
    			 l.add(i);
    		 }
    		 res.add(l);
    		 return res;
    	} 
        List<List<Integer>> stack = new ArrayList<List<Integer>>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for (int i = 1; i <= n; i++ ) {
        	List<Integer> l = new ArrayList<Integer>();
        	l.add(i);
        	stack.add(l);
        }
        while (0 != stack.size()) {
        	List<Integer> f = stack.remove(0);
        	if (k == f.size()) res.add(f);
        	else {
        		for (int i = f.get(f.size() - 1) + 1; i <= n; i++) {
        			List<Integer> next = new ArrayList<Integer>();
        			next.addAll(f);
        			next.add(i);
        			stack.add(next);
        		}
        	}
        }
    	return res;
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		print(combine(5,5));
	}

}
