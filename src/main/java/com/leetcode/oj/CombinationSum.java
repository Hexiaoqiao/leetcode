package com.leetcode.oj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	public static List<List<Integer>> combinationSum(int[] candidates, int start, int end, int target) {
		int i = 0;
		for (i = end - 1; i >= start; i--) {
			if (candidates[i] <= target) break; 
		}
		if (i < start) return new ArrayList<List<Integer>>();
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		for (; i >= start; i--) {
			if (0 == target - candidates[i]) {
				List<Integer> l = new ArrayList<Integer>();
				l.add(candidates[i]);
				res.add(l);
			} else {
				List<List<Integer>> tmp = combinationSum(candidates, start, i + 1, target - candidates[i]);
				if (null == tmp || 0 == tmp.size()) continue;
				for (List<Integer> l : tmp) {
					l.add(candidates[i]);
				}
				res.addAll(tmp);
			}
		}
		return res;
	}
	
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
    	Arrays.sort(candidates);
        return combinationSum(candidates, 0, candidates.length, target);
    }
    
    public static List<List<Integer>> combinationSum2D(int[] num, int target) {
    	int i = 0;
    	for (i = num.length - 1; i >= 0; i--) {
    		if (num[i] <= target) break;
    	}
    	if (i < 0) return new ArrayList<List<Integer>>();
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	for (; i >= 0; i--) {
			if (0 == target - num[i]) {
				List<Integer> l = new ArrayList<Integer>();
				l.add(num[i]);
				if (!res.contains(l)) res.add(l);
			} else if (0 < target - num[i]) {
				int[] tnum = new int[i];
				for (int j = 0; j < i; j++) {
					tnum[j] = num[j];
				}
				List<List<Integer>> tmp = combinationSum2D(tnum, target - num[i]);
				if (null == tmp || 0 == tmp.size()) continue;
				for (List<Integer> l : tmp) {
					l.add(num[i]);
					if (!res.contains(l)) res.add(l);
				}
			}
    	}
    	return res;
    }
    public static List<List<Integer>> combinationSum2(int[] num, int target) {
    	Arrays.sort(num);
    	return combinationSum2D(num, target);
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] candidates = {2,2,2};
		int target = 4;
		List<List<Integer>> res = combinationSum2(candidates, target);
		for (List<Integer> l : res) {
			for (Integer i : l) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

}
