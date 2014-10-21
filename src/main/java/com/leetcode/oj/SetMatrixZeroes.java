/**
 * Source : 
 * Author : Hexiaoqiao
 * Date   : 2014-09-26
 *
 * 0.Problem:
 * Given a m x n matrix, if an element is 0, set its entire 
 * row and column to 0. Do it in place.
 * Follow up:
 * Did you use extra space?
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 * 
 * 1.Refer.:
 * 1.0 判断首行首列的零值情况；
 * 1.1 将矩阵的零值均映射到首行首列；
 * 1.2 行置位；
 * 1.3 列置位；
 */
package com.leetcode.oj;

public class SetMatrixZeroes {
    public static void setZeroes(int[][] matrix) {
        if (null == matrix) return;
    	int m = matrix.length;
        int n = matrix[0].length;
        if (0 == m || 0 == n) return;
    	boolean row = false;
    	boolean col = false;
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (0 == matrix[i][j]) {
        			matrix[i][0] = 0;
        			matrix[0][j] = 0;
        			if (0 == i) row = true;
        			if (0 == j) col = true;
        		}
        	}
        }
        for (int j = 1; j < n; j++) {
        	if (0 == matrix[0][j]) {
        		for (int i = 0; i < m; i++) {
        			matrix[i][j] = 0;
        		}
        	}
        }
        for (int i = 1; i < m; i++) {
        	if (0 == matrix[i][0]) {
        		for (int j = 0; j < n; j++) {
        			matrix[i][j] = 0;
        		}
        	}
        }
        if (row) {
        	for (int i = 0; i < n; i++) {
        		matrix[0][i] = 0;
        	}
        }
        if (col) {
        	for (int i = 0; i < m; i++) {
        		matrix[i][0] = 0;
        	}
        }  	
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {
				  {1, 0},
				  {2, 1}
		};
		setZeroes(matrix);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print( matrix[i][j] + " " );
			}
			System.out.println();
		}
	}

}
