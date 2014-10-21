/**
 * Source : 
 * Author : Hexiaoqiao
 * Date   : 2014-09-26
 *
 * 0.Problem:
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element.
 * You may assume no duplicate exists in the array.
 * 
 * 1.Refer.:二分查找
 */
package com.leetcode.oj;

public class FindMinimuminRotatedSortedArray {
    public static int findMin(int[] num) {
        if (null == num || 0 == num.length) return -1;
        int low = 0, high = num.length - 1;
        if (1 == num.length) return num[0];
        if (num[low] < num[high]) return num[low];
        while (low <= high) {
        	if (low + 1 == high) 
        		return num[low] > num[high] ? num[high] : num[low];
        	int mid = (low + high) / 2;
        	if (num[mid] > num[low]) low = mid;
        	else high = mid;
        }
    	return num[low];
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1};
		System.out.println(findMin(num));
	}

}
