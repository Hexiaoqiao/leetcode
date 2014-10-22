/**
 * Source : http://oj.leetcode.com/problems/3sum-closest
 * Author : Hexiaoqiao
 * Date   : 2014-09-26
 *
 * 0.Problem:
 * Given an array S of n integers, find three integers in S such that the 
 * sum is closest to a given number, target. Return the sum of the three 
 * integers. You may assume that each input would have exactly one solution.
 * 
 *     For example, given array S = {-1 2 1 -4}, and target = 1.
 * 
 *     The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * 1.Refer.:
 * 1.0 排序
 * 1.1 取子数组的两端数据然后二分查找
 */
package com.leetcode.oj;

import java.util.Arrays;

public class SumClosest {
    public static int threeSumClosest(int[] num, int target) {
        if (null == num || 0 == num.length) {
        	return 0;
        }
    	if (num.length <= 3) {
    		int res = 0;
        	for (int i = 0; i < num.length; i++) res = res + num[i];
        	return res;
        }
    	Arrays.sort(num);
    	int closest = 0;
    	boolean first = true;
    	for (int i = 0; i < num.length - 2; i++) {
    		int low = i + 1;
    		int high = num.length - 1;
    		int sum = 0;
    		while (low < high) {
    			sum = num[i] + num[low] + num[high];
    			if (target == sum) return sum;
    			else if (target > sum) low++;
    			else high--;
    			if (first) {closest = sum;first = false;}
    			else closest = Math.abs(sum - target) > Math.abs(closest - target) ? closest : sum;
    		}
    	}
    	return closest;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1,1,1,1};
		int target = 100;
		System.out.println(threeSumClosest(num, target));
	}

}
