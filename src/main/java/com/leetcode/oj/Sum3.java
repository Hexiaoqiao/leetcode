/*
0.Problem:
Given an array S of n integers, are there elements a, b, c in S such that 
a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
    
1.Refer.: 同@SumClosest
1.0 排序
1.1 取子数组的两端数据然后二分查找，如果符合要求将其加入结果集合里
*/
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
