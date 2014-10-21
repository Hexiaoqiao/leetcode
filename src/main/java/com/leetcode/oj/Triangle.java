/**
 * Source : 
 * Author : Hexiaoqiao
 * Date   : 2014-09-26
 *
 * 0.Problem:
 * Given a triangle, find the minimum path sum from top to bottom. 
 * Each step you may move to adjacent numbers on the row below.
 * For example, given the following triangle
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * Note:
 * Bonus point if you are able to do this using only O(n) extra space, 
 * where n is the total number of rows in the triangle.
 * 
 * 1.Refer.: DP
 * min[i] = triangle[level][i] + min(min[i], min[i+1])
 */
package com.leetcode.oj;

import java.util.ArrayList;
import java.util.List;

public class Triangle {
	
	public static int min(int a, int b) {
		return a > b ? b : a;
	}
	
    public static int minimumTotal(List<List<Integer>> triangle) {
    	if (null == triangle) {
    		return 0;
    	} else if (1 == triangle.size()) {
    		return triangle.get(0).get(0);
    	}
    	int[] minlen = new int[triangle.size()];
    	for (int level = triangle.size() - 1; level >= 0; level--) {
    		for (int i = 0; i < triangle.get(level).size(); i++) {
    			if (level == triangle.size() - 1) {
    				minlen[i] = triangle.get(level).get(i);
    			} else {
    				minlen[i] = triangle.get(level).get(i) + min(minlen[i], minlen[i + 1]);
    			}
    		}
    	}
    	return minlen[0];
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> input = new ArrayList<List<Integer>>();
		List<Integer>l1 = new ArrayList<Integer>();l1.add(2);
		List<Integer>l2 = new ArrayList<Integer>();l2.add(3);l2.add(4);
		List<Integer>l3 = new ArrayList<Integer>();l3.add(6);l3.add(5);l3.add(7);
		List<Integer>l4 = new ArrayList<Integer>();l4.add(4);l4.add(1);l4.add(8);l4.add(3);
		input.add(l1);input.add(l2);input.add(l3);input.add(l4);
		System.out.println(minimumTotal(input));
	}

}
