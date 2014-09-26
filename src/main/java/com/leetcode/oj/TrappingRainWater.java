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
