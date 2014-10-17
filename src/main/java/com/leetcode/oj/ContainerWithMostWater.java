/*
0.Problem:
Given n non-negative integers a1, a2, ..., an, where each represents 
a point at coordinate (i, ai). n vertical lines are drawn such that 
the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, 
which together with x-axis forms a container, such that the container 
contains the most water.

Note: You may not slant the container.

1.Refer.:
1.0 从两边向中间逐个搜索；
*/
package com.leetcode.oj;

public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int low = 0, high = height.length - 1;
        int maxarea = 0;
        while (low < high) {
        	int w = height[high] > height[low] ? height[low] : height[high];
        	int area = w * (high - low);
        	maxarea = maxarea > area ? maxarea : area;
        	if (height[high] > height[low]) low = low + 1;
        	else high = high - 1;
        }
    	return maxarea;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] height = {1,1};
		System.out.println(maxArea(height));
	}

}
