/**
 * Source : https://oj.leetcode.com/problems/find-peak-element/
 * Author : Hexiaoqiao
 * Date   : 2014-12-08
 *
 * 0.Problem:
 * A peak element is an element that is greater than its neighbors.
 * Given an input array where num[i] ≠ num[i+1], find a peak element 
 * and return its index.
 * The array may contain multiple peaks, in that case return the index 
 * to any one of the peaks is fine.
 * You may imagine that num[-1] = num[n] = -∞.
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your 
 * function should return the index number 2.
 * 
 * 1.Refer.: 二分查找即可
 */
package com.leetcode.oj;

public class FindPeakElement {
    public static int findPeakElement(int[] num) {
        if (null == num || 0 == num.length) return -1; 
        int len = num.length;
        int low = 0, high = len - 1;
        int mid = 0;
        if (1 == len) return 0; 
        while (low < high) {
        	mid = (low + high) >> 1;
        	if (num[mid] < num[mid + 1]) low = mid + 1;
        	else high = mid;
        }
    	return low;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    int[] num0 = {0};
	    int[] num1 = {0,0};
	    int[] num2 = {1,2,3};
	    int[] num3 = {1,3,2};
	    int[] num4 = {};
	    int[] num5 = {1,2,3,4,5,6,4};
	    System.out.println(findPeakElement(num0));
	    System.out.println(findPeakElement(num1));
	    System.out.println(findPeakElement(num2));
	    System.out.println(findPeakElement(num3));
	    System.out.println(findPeakElement(num4));
	    System.out.println(findPeakElement(num5));
	}
}
