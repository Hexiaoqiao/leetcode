package com.leetcode.oj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sum3 {
    public static List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int n = num.length;
        if (3 > n) return res;
        Arrays.sort(num);
        for (int i = 0; i < n - 2; i++) {
        	int low = i + 1;
        	int high = n - 1;
	        int target = 0 - num[i];
	        if (low >= n - 1 || low >= high) continue; 
	        while (low < high) {
	        	if (target < num[low] + num[high]) {
	        		high = high - 1;
	        	} else if (target > num[low] + num[high]) {
	        		low = low + 1;
	        	} else {
	        		List<Integer> l = new ArrayList<Integer>();
	        		l.add(num[i]);
        			l.add(num[low]);
        			l.add(num[high]);
        			if (!res.contains(l)) res.add(l);
        			low = low + 1;
        			high = high - 1;
        			while (low < n && num[low] == num[low - 1]) low++;
        			while (high > i && num[high] == num[high + 1]) high--;
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
		int[] num = {0,0,0,0};
		List<List<Integer>> res = threeSum(num);
		for (List<Integer> l : res) {
			for (Integer i : l) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

}
