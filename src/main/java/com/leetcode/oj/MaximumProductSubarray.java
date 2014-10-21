/**
 * Source : 
 * Author : Hexiaoqiao
 * Date   : 2014-09-26
 *
 * 0.Problem:
 * Find the contiguous subarray within an array (containing at least 
 * one number) which has the largest product.
 * 
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 * 
 * 1.Refer.: DP
 * max[i] = max(A[i], A[i] * max[i-1], A[i] * min[i-1])
 * min[i] = min(A[i], A[i] * max[i-1], A[i] * min[i-1])
 */
package com.leetcode.oj;

public class MaximumProductSubarray {
    public static int maxProduct(int[] A) {
        if (null == A || 0 == A.length) return 0;
        int len = A.length;
        int[] min = new int[len];
        int[] max = new int[len];
        min[0] = A[0]; max[0] = A[0];
        int ret = A[0];
        for (int i = 1; i < A.length; i++) {
        	int a = min[i - 1] * A[i];
        	int b = max[i - 1] * A[i];
        	min[i] = a > b ? (b > A[i] ? A[i] : b) : (a > A[i] ? A[i] : a);
        	max[i] = a < b ? (b < A[i] ? A[i] : b) : (a < A[i] ? A[i] : a);
        	ret = ret < max[i] ? max[i] : ret;
        }
    	return ret;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {2,-3,3,-9,-2,4};
		System.out.println(maxProduct(A));
	}

}
