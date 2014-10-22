/**
 * Source : http://oj.leetcode.com/problems/permutations
 *			http://oj.leetcode.com/problems/permutations-ii
 * Author : Hexiaoqiao
 * Date   : 2014-09-26
 *
 * 0.Problem:
 * 0.0
 * Given a collection of numbers, return all possible permutations.
 * For example,
 * [1,2,3] have the following permutations:
 * [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 * 
 * 0.1
 * Given a collection of numbers that might contain duplicates, 
 * return all possible unique permutations.
 * For example,
 * [1,1,2] have the following unique permutations:
 * [1,1,2], [1,2,1], and [2,1,1].
 * 
 * 1.Refer.:递归
 * 1.0 第一位分别取num[n]中的1..n,然后将剩下的数据作为后n-1位递归生成；
 * 1.1 同1.0区别是需要现对数组排序，之后需要跳过重复的数据
 * 
 */
package com.leetcode.oj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
	
	public static List<List<Integer>> permute(int[] num) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (0 == num.length) return res;
        if (1 == num.length) {
        	List<Integer> t = new ArrayList<Integer>();
        	t.add(num[0]);
        	res.add(t);
        	return res;
        }
        for (int i = 0; i < num.length; i++) {
        	int n = num[i];
        	int[] t = new int[num.length - 1];
        	int delta = 0;
        	for (int j = 0; j < num.length; j++) {
        		if (j == i) {delta = 1;continue;}
        		t[j - delta] = num[j];
        	}
        	List<List<Integer>> ra = permute(t);
        	for (List<Integer> a : ra) {
        		a.add(0, n);
        	}
        	res.addAll(ra);
        }
    	return res;
    }
	
	public static void subpermute(List<List<Integer>> res, List<Integer> l, int[] num) {
		if (0 == num.length) {
			List<Integer> t = new ArrayList<Integer>(l);
			res.add(t); 
			return;
		}
		else {
			for (int i = 0; i < num.length; i++) {
				if (i  > 0 && num[i] == num[i - 1]) continue;
				l.add(num[i]);
				int[] tmp = new int[num.length - 1];
				int delta = 0;
				for (int j = 0; j < num.length; j++) {
					if (j != i) {
						tmp[j - delta] = num[j];
					} else {
						delta = 1;
					}
				}
				subpermute(res, l, tmp);
				l.remove(l.size() - 1);
			}
		}
	}
	
    public static List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        List<Integer> l = new ArrayList<Integer>();
        subpermute(res,l,num);
        return res;
    }

    public static void print(List<List<Integer>> a) {
		for (List<Integer> al : a) {
			for (Integer i : al) {
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
		int[] num = {3,1,1,1,2};
		print(permute(num));
		System.out.println("------------");
		print(permuteUnique(num));
	}
}
