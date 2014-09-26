package com.leetcode.oj;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static List<List<Integer>> generate(int numRows) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
        //if (0 == numRows) return null;
        for (int i = 0; i < numRows; i++) {
        	List<Integer> l = new ArrayList<Integer>();
        	for (int j = 0; j < i + 1; j++) {
        		if (0 == i || 0 == j || i == j) {
        			l.add(1);
        		} else {
        			l.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
        		}
        	}
        	res.add(l);
        }
    	return res;
    }
    
    public static List<Integer> getRow(int rowIndex) {
    	List<Integer> res = new ArrayList<Integer>();
    	res.add(1);
    	for (int i = 1; i < rowIndex + 2; i++) {
    		res.add(0);
    	}
    	for (int i = 1; i < rowIndex + 1; i++) {
    		for (int j = i; j >=  0; j--) {
    			if (0 == j || i == j) {
        			res.set(j, 1);
        		} else {
        			res.set(j, res.get(j) + res.get(j - 1));
        		}
    		}
    	}
    	return res.subList(0, rowIndex + 1);
    }
    
    public static void print(List<List<Integer>> res) {
    	for (int i = 0; i < res.size(); i++) {
    		for (int j = 0; j < res.get(i).size(); j++) {
    			System.out.print(res.get(i).get(j) + " ");
    		}
    		System.out.println();
    	}
    }
    
    public static void print1(List<Integer> res) {
    	for (int j = 0; j < res.size(); j++) {
    		System.out.print(res.get(j) + " ");
    	}
    	System.out.println();
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		print(generate(3));
		print1(getRow(2));
	}

}
