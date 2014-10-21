/**
 * Source : 
 * Author : Hexiaoqiao
 * Date   : 2014-09-26
 *
 * 0.Problem:
 * 0.0
 * Given a matrix of m x n elements (m rows, n columns), return all 
 * elements of the matrix in spiral order.
 * For example,
 * Given the following matrix:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * You should return [1,2,3,6,9,8,7,4,5].
 * 
 * 0.1
 * Given an integer n, generate a square matrix filled with elements 
 * from 1 to n2 in spiral order.
 * For example,
 * Given n = 3,
 * You should return the following matrix:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 * 
 * 1.Refer.:
 * 1.0
 * 0.设置遍历范围；
 * 1.顺时针遍历四个方向；
 * 2.重复step0&1直到所有元素遍历；
 * 
 * 1.1
 * 同1.0
 */
package com.leetcode.oj;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static int[][] generateMatrix(int n) {
    	int[][] res = new int[n][n];
    	int start = 1;
    	int istart = 0, iend = n;
    	int jstart = 0, jend = n;
    	while (start <= (n * n)) {
    		for (int j = jstart; j < jend; j++) {
    			res[istart][j] = start;
    			start = start + 1;
    		}
    		for (int i = istart + 1; i < iend; i++) {
    			res[i][jend - 1] = start;
    			start = start + 1;
    		}
    		for (int j = jend - 2; j >= jstart; j--) {
    			res[iend - 1][j] = start;
    			start = start + 1;
    		}
    		for (int i = iend - 2; i >= istart + 1; i--) {
    			res[i][jstart] = start;
    			start = start + 1;
    		}
    		istart = istart + 1;
    		iend = iend - 1;
    		jstart = jstart + 1;
    		jend = jend - 1;
    	}
        return res;
    }
    
    public static List<Integer> spiralOrder(int[][] matrix) {
    	List<Integer> res = new ArrayList<Integer>();
    	int start = 0;
    	if (null == matrix || 0 == matrix.length) return res; 
    	int m = matrix.length;
    	int n = matrix[0].length;
    	int istart = 0, iend = matrix.length;
    	int jstart = 0, jend = matrix[0].length;
    	while (start < m * n) {
    		for (int j = jstart; j < jend && start < m * n; j++) {
    			res.add(matrix[istart][j]);
    			start = start + 1;
    		}
    		for (int i = istart + 1; i < iend && start < m * n; i++) {
    			res.add(matrix[i][jend - 1]);
    			start = start + 1;
    		}
    		for (int j = jend - 2; j >= jstart && start < m * n; j--) {
    			res.add(matrix[iend - 1][j]);
    			start = start + 1;
    		}
    		for (int i = iend - 2; i >= istart + 1 && start < m * n; i--) {
    			res.add(matrix[i][jstart]);
    			start = start + 1;
    		}
    		istart = istart + 1;
    		iend = iend - 1;
    		jstart = jstart + 1;
    		jend = jend - 1;
    	}
    	return res;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] res = generateMatrix(0);
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < res[i].length; j++) {
				System.out.print(res[i][j] + " ");
			}
			System.out.println();
		}
		
		int[][] matrix = {{1},{2},{3},{4},{5},{6}};
		List<Integer> r = spiralOrder(matrix);
		for (Integer i : r) {
			System.out.print(i + " ");
		}
	}

}
