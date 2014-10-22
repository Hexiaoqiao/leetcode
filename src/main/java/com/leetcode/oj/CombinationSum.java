/**
 * Source : http://oj.leetcode.com/problems/combination-sum
 *			http://oj.leetcode.com/problems/combination-sum-ii
 * Author : Hexiaoqiao
 * Date   : 2014-09-26
 *
 * 0.Problem:
 * 0.0
 * Given a set of candidate numbers (C) and a target number (T), find all 
 * unique combinations in C where the candidate numbers sums to T.
 * 
 * The same repeated number may be chosen from C unlimited number of times.
 * 
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. 
 * (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 2,3,6,7 and target 7, 
 * A solution set is: 
 * [7] 
 * [2, 2, 3] 
 * 
 * 0.1
 * Given a collection of candidate numbers (C) and a target number (T), 
 * find all unique combinations in C where the candidate numbers sums to T.
 * 
 * Each number in C may only be used once in the combination.
 * 
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending 
 * order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
 * A solution set is: 
 * [1, 7] 
 * [1, 2, 5] 
 * [2, 6] 
 * [1, 1, 6] 
 * 
 * 1.Refer.:
 * 1.0 递归
 * 0) 排序；
 * 1）从后往前找到第一个小于target的数num；
 * 2）应用递归在集合里查询结果是target-num的集合
 * 3）步骤2）结果与1）中的元素合并即为结果的一个元素
 * 
 * 1.1 递归童1.0
 * 0）方法同1.0，区别仅在步骤2）中增加集合元素去重
 */
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
