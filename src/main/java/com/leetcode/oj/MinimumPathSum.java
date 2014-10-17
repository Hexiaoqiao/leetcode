/*
0.Problem:
Given a m x n grid filled with non-negative numbers, find a path 
from top left to bottom right which minimizes the sum of all numbers 
along its path.
Note: You can only move either down or right at any point in time.

1.Refer.:DP
 pathsum[i][j] = min(pathsum[i][j + 1] + grid[i][j],pathsum[i + 1][j] + grid[i][j])
*/
package com.leetcode.oj;

public class MinimumPathSum {
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] pathsum = new int[m][n];
    	for (int i = m - 1; i >= 0; i--) {
        	for (int j = n - 1; j >= 0; j--) {
        		if (i == m - 1 && j == n - 1) pathsum[i][j] = grid[i][j];
        		else if (i == m - 1) pathsum[i][j] = pathsum[i][j + 1] + grid[i][j];
        		else if (j == n - 1) pathsum[i][j] = pathsum[i + 1][j] + grid[i][j];
        		else {
        			int right = pathsum[i][j + 1];
        			int down = pathsum[i + 1][j];
        			pathsum[i][j] = right > down ? down + grid[i][j] : right + grid[i][j];
        		}
        	}
        }
    	return pathsum[0][0];
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = {
/*				{4,3,1,6,5},
				{9,3,8,6,4},
				{7,2,5,3,6},
				{1,3,5,7,9},
				{2,4,6,8,0}*/
				{1},
				{2}
		};
		System.out.println(minPathSum(grid));
	}

}
