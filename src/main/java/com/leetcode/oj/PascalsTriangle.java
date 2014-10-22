/**
 * Source : http://oj.leetcode.com/problems/pascals-triangle
 *			http://oj.leetcode.com/problems/pascals-triangle-ii
 * Author : Hexiaoqiao
 * Date   : 2014-09-26
 *
 * 0.Problem:
 * 0.0
 * Given numRows, generate the first numRows of Pascal's triangle.
 * For example, given numRows = 5,
 * Return
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 * 
 * 0.1
 * Given an index k, return the kth row of the Pascal's triangle.
 * For example, given k = 3,
 * Return [1,3,3,1].
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 * 
 * 1.Refer.:
 * 1.0 顺序生成就好；
 * 1.1 DP res[j] = rres.get(j) + res.get(j - 1)
 */
package com.leetcode.oj;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static List<List<Integer>> generate(int numRows) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
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
