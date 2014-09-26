package com.leetcode.oj;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    public static List<Integer> grayCode(int n) {
    	List<Integer> res = new ArrayList<Integer>();
    	res.add(0);
    	for (int i = 0; i < n; i++) {
    		int inc = 1 << i;
    		for (int j = res.size() - 1; j >= 0; j--) {
    			res.add(res.get(j) + inc);
    		}
    	}
        return res;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> res = grayCode(3);
		for (Integer i : res) {
			System.out.print(i + " ");
		}
	}

}
