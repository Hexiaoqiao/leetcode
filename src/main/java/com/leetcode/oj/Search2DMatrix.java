/**
 * Source : http://oj.leetcode.com/problems/search-a-2d-matrix
 * Author : Hexiaoqiao
 * Date   : 2014-09-26
 *
 * 0.Problem:
 * Write an efficient algorithm that searches for a value in 
 * an m x n matrix. This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last 
 * integer of the previous row.
 * For example,
 * Consider the following matrix:
 * [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * Given target = 3, return true.
 * 
 * 1.Refer.:
 * 折半查找[0,m*n] A[x/m][A%m]
 */
package com.leetcode.oj;

public class Search2DMatrix {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[m - 1][n - 1]) return false;
        int low = 0;
        int high = m * n;
        int mid = 0;
        while (low <= high) {
        	mid = (low + high) / 2;
        	int val = matrix[mid / n][mid % n];
        	if (target == val) {
        		return true;
        	} else if (target < val) {
        		high = mid - 1;
        	} else {
        		low = mid + 1;
        	}
        	
        }
    	return false;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {
				  {1,1}
		};
		System.out.println(searchMatrix(matrix, 1));
	}

}
