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
