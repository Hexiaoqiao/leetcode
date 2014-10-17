/*
0.Problem: 
Given n non-negative integers representing an elevation 
map where the width of each bar is 1, compute how much 
water it is able to trap after raining.

For example, 
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

The above elevation map is represented by array [0,1,0,2,
1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue 
section) are being trapped. Thanks Marcos for contributing 
this image!

1.Refer.:
1.0 从左到右遍历当前位置左边最大值min
1.1 从右到左遍历当前位置右边最大值max
1.2 比较cur，min，max之间的大小记入结果中

2.link:(https://oj.leetcode.com/problems/trapping-rain-water/)
*/
package com.leetcode.oj;

public class TrappingRainWater {
	public static int trap(int[] A) {
		if (A.length <= 2) return 0;
		int[] lm = new int[A.length];
		int max = A[0];
		for (int i = 1; i < A.length; i++) {
			lm[i] = max;
			if (max < A[i]) max = A[i];
		}
		max = A[A.length - 1];
		int res = 0;
		for (int i = A.length - 2; i > 0; i--) {
			int high = A[i];
			int min = max > lm[i] ? lm[i] : max;
			if (high < min) res = res + min - high;
			if (A[i] > max) max = A[i];
		}
		return res;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1,1,1,1,1};
		System.out.println(trap(num));
	}

}
