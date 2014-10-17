/*
0.Problem:
https://oj.leetcode.com/problems/largest-rectangle-in-histogram/

Given n non-negative integers representing the histogram's bar height where 
the width of each bar is 1, find the area of largest rectangle in the histogram.
Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
The largest rectangle is shown in the shaded area, which has area = 10 unit.
For example,
Given height = [2,1,5,6,2,3],
return 10.

1.Refer.:
顺序遍历当前节点:
1)记录当前节点左边高度均大于当前节点高度的最远距离；
2)记录当前节点右边高度均大于当前节点高度的最远距离；
再次遍历计算1)2)差值与距离乘积去最大值
*/                                                       
package com.leetcode.oj;

public class LargestRectangleinHistogram {
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
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] height = {5};
		System.out.println(largestRectangleArea(height));
	}

}
