/**
 * Source : 
 * Author : Hexiaoqiao
 * Date   : 2014-09-26
 *
 * 0.Problem:
 * 0.0
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' 
 * in the diagram below).
 * The robot can only move either down or right at any point in time. The 
 * robot is trying to reach the bottom-right corner of the grid (marked 
 * 'Finish' in the diagram below).
 * How many possible unique paths are there?
 * Note: m and n will be at most 100.
 * 
 * 0.1
 * Follow up for "Unique Paths":
 * Now consider if some obstacles are added to the grids. How many unique paths 
 * would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * The total number of unique paths is 2.
 * Note: m and n will be at most 100.
 * 
 * 1.Refer.:
 * 1.0 DP
 * path[i][j] = path[i][j-1] + path[i-1][j]
 * 
 * 1.1 DP
 * 			 /	0				case obstacleGrid[i][j] != 0
 * 			 |	1				case i = m-1 && j = n-1
 * path[i][j] =-|	path[i+1][j]	case j = n - 1
 * 			 |	path[i][j+1]	case i = m - 1
 * 			 \	path[i][j+1]+path[i+1][j]	other
 * 
 */
package com.leetcode.oj;

public class UniquePaths {
    public static int uniquePaths(int m, int n) {
    	int[][] path = new int[m][n];
    	for (int i = 0; i < m; i++) {
    		for (int j = 0; j < n; j++) {
    			if (0 == i && 0 == j) path[i][j] = 1;
    			else if (0 == i) path[i][j] = path[0][j - 1];
    			else if (0 == j) path[i][j] = path[i - 1][0];
    			else path[i][j] = path[i][j - 1] + path[i - 1][j];
    		}
    	}
        return path[m - 1][n - 1];
    }
    
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	int m = obstacleGrid.length;
    	int n = obstacleGrid[0].length;
    	int[][] path = new int[m][n];
    	for (int i = m - 1; i >= 0; i--) {
    		for (int j = n - 1; j >= 0; j--) {
    			if (0 != obstacleGrid[i][j])
    				path[i][j] = 0;
    			else if (m - 1 == i && n - 1 == j) {
    				if (obstacleGrid[m - 1][n - 1] == 0) {path[i][j] = 1;}
    				else path[i][j] = 0;
    			}
    			else if (m - 1 == i) {
    				if (0 == obstacleGrid[m - 1][j + 1]) path[i][j] = path[m - 1][j + 1];
    				else path[i][j] = 0;
    			}
    			else if (n - 1 == j) {
    				if (0 == obstacleGrid[i + 1][n - 1]) path[i][j] = path[i + 1][n - 1];
    				else path[i][j] = 0;
    			}
    			else {
    				if (0 == obstacleGrid[i][j + 1] && 0 == obstacleGrid[i + 1][j])
    					path[i][j] = path[i][j + 1] + path[i + 1][j];
    				else if (0 == obstacleGrid[i][j + 1])
    					path[i][j] = path[i][j + 1];
    				else if (0 == obstacleGrid[i + 1][j])
    					path[i][j] = path[i + 1][j];
    				else {
    					path[i][j] = 0;
					}
    			}
    		}
    	}
        return path[0][0];
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(uniquePaths(3, 2));
		int[][]obstacleGrid = {
				  {0,0,0},
				  {0,1,0},
				  {0,0,0}
		};
		System.out.println(uniquePathsWithObstacles(obstacleGrid));
	}

}
