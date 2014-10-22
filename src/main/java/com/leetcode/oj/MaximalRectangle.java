/**
 * Source : http://oj.leetcode.com/problems/maximal-rectangle
 * Author : Hexiaoqiao
 * Date   : 2014-09-26
 *
 * 0.Problem:
 * Given a 2D binary matrix filled with 0's and 1's, find the largest 
 * rectangle containing all ones and return its area.
 * 
 * 1.Refer.:
 * 1.0 逐行遍历：如果当前节点值为1，累计列上连续1的个数；
 * 1.1 参考：LargestRectangleinHistogram计算结果；
 */
package com.leetcode.oj;

public class MaximalRectangle {
    public static int largestRectangleArea(int[] height) {
    	int len = height.length;
    	if (len ==0) return 0;
    	else if (1 == len) return height[0];
    	int[] left = new int[len];
    	int[] right = new int[len];
    	for (int i = 0; i < len; i++) {
    		left[i] = i;
    		while ( left[i] > 0 && height[left[i] - 1] >= height[i]) {
    			left[i] = left[left[i] - 1];
    		}
    	}
    	for (int i = len - 1; i >= 0; i--) {
    		right[i] = i;
    		while (right[i] < len - 1 && height[right[i] + 1] >= height[i]) {
    			right[i] = right[right[i] + 1];
    		}
    	}
    	int ret = 0;
    	for (int i = 0; i < len; i++) {
    		int area = (right[i] - left[i] + 1) * height[i];
    		if (area > ret) ret = area;
    	}
    	return ret;
    }
    
    public static int maximalRectangle(char[][] matrix) {
    	if (null == matrix || 0 == matrix.length) return 0; 
    	for (int i = 1; i < matrix.length; i++) {
    		for (int j = 0; j < matrix[i].length; j++) {
    			if ('1' == matrix[i][j]) {
    				matrix[i][j] = (char) (matrix[i][j] + matrix[i - 1][j] - '0');
    			}
    		}
    	}
    	int max = 0;
    	int[] height = new int[matrix[0].length];
    	for (int i = 0; i < matrix.length; i++) {
    		for (int j = 0; j < matrix[i].length; j++) {
    			height[j] = matrix[i][j] - '0';
    		}
    		int ret = largestRectangleArea(height);
    		if (ret > max) max = ret; 
    	}
        return max;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] matrix = {{'0','0','1','0'},{'0','0','0','1'},{'0','1','1','1'},{'0','0','1','1'}};
		System.out.println(maximalRectangle(matrix));
	}

}
