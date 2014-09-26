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
