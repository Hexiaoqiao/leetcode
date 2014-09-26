package com.leetcode.oj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    public static List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(num, 0, num.length);
        res.add(new ArrayList<Integer>());
        if (null == num || 0 == num.length) {
        	return res;
        }
        int j = 0;
        int last = 0;
        for (int i = 0; i < num.length; i++) {
        	if (i != 0 && num[i] == num[i - 1]) {
        		j = last;
        	} else {
        		j = 0;
        	}
        	last = res.size();
        	for (; j < last; j++) {
        		ArrayList<Integer> t = (ArrayList<Integer>) res.get(j);
        		t = (ArrayList<Integer>) t.clone();
        		t.add(num[i]);
        		res.add(t);
        	}
        }
    	return res;
    }
    
    public static List<List<Integer>> subsets(int[] S) {
    	Arrays.sort(S, 0, S.length);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> n = new ArrayList<Integer>();
        res.add(n);
        for (int i : S) {
        	int len = res.size();
        	for (int j = 0; j < len; j++) {
        		ArrayList<Integer> t = (ArrayList<Integer>) res.get(j);
        		ArrayList<Integer> c = (ArrayList<Integer>) t.clone();
        		c.add(i);
        		if (!res.contains(c)) {
        			res.add(c);
        		}
        	}
        }
    	return res;
    }
    
    public static void print(List<List<Integer>> a) {
    	for (List<Integer> l : a) {
    		for (Integer i : l) {
    			System.out.print(i + " ");
    		}
    		System.out.println();
    	}
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {4,1,0};
		print(subsets(num));
	}

}
