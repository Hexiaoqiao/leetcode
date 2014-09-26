package com.leetcode.oj;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
	public static boolean isValid(List<Integer> index, int n) {
		int len = index.size();
		for (int i = 0; i < index.size(); i++) {
			if (index.get(i) == n || Math.abs(n - index.get(i)) == Math.abs(len - i)) return false;
		}
		return true;
	}
    public static List<String[]> solveNQueens(int n) {
    	List<String[]> res = new ArrayList<String[]>();
    	List<Integer> index = new ArrayList<Integer>();
    	index.add(0);
    	while (0 != index.size()) {
    		while (index.size() < n) {
    			boolean add = false;
    			for (int i = 0; i < n; i++) {
    				if (isValid(index, i)) {add = true; index.add(i); break;}
    			}
    			if (!add) break;
    		}
    		if (n == index.size()) {
    			String[] r = new String[n];
    			for (int i = 0; i < n; i++) {
    				StringBuffer sb = new StringBuffer();
    				for (int j = 0; j < n; j++) sb.append('.');
    				sb.setCharAt(index.get(i), 'Q');
    				r[i] = sb.toString();
    			}
    			res.add(r);
    		}
    		
    		while (true) {
    			if (0 == index.size()) break;
    			int next = index.remove(index.size() - 1) + 1;
    			while (next < n && !isValid(index, next)) {
    				next = next + 1;
    			}
    			if (next < n) {index.add(next); break;}
    		}
    		
    	}
        return res;
    }
    
    public static int totalNQueens(int n) {
    	int res = 0;
    	List<Integer> index = new ArrayList<Integer>();
    	index.add(0);
    	while (0 != index.size()) {
    		while (index.size() < n) {
    			boolean add = false;
    			for (int i = 0; i < n; i++) {
    				if (isValid(index, i)) {add = true; index.add(i); break;}
    			}
    			if (!add) break;
    		}
    		if (n == index.size()) {
    			res = res + 1;
    		}
    		
    		while (true) {
    			if (0 == index.size()) break;
    			int next = index.remove(index.size() - 1) + 1;
    			while (next < n && !isValid(index, next)) {
    				next = next + 1;
    			}
    			if (next < n) {index.add(next); break;}
    		}
    		
    	}
        return res;
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String[]> res = solveNQueens(5);
		for (String[] strs : res) {
			for (String s : strs) {
				System.out.println(s);
			}
			System.out.println("----------------");
		}
		System.out.println(totalNQueens(5));
	}

}
