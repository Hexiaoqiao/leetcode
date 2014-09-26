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
