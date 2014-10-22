/**
 * Source : http://oj.leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 * Author : Hexiaoqiao
 * Date   : 2014-09-26
 *
 * 0.Problem:
 * 0.0
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element.
 * You may assume no duplicate exists in the array.
 * 
 * 0.1
 * Follow up for "Find Minimum in Rotated Sorted Array":
 * What if duplicates are allowed?
 * Would this affect the run-time complexity? How and why?
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element.
 * The array may contain duplicates.

 * 1.Refer.:
 * 1.0 二分查找
 * 1.1 二分查找 ＋　两边顺序
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
    
    public static int findMin1(int[] num) {
        if (null == num || 0 == num.length) return -1;
        int low = 0, high = num.length - 1;
        if (1 == num.length) return num[0];
        if (num[low] < num[high]) return num[low];
        while (low <= high) {
        	if (low + 1 == high) 
        		return num[low] > num[high] ? num[high] : num[low];
        	int mid = (low + high) / 2;
        	if (num[mid] > num[high]) {
        		low = mid;
        	} else if (num[mid] < num[high]) {
        		high = mid;
        	} else {
        		if (num[mid] == num[low]) {
        			low = low + 1;
        			high = high - 1;
        		} else {
        			high = mid;
        		}
        	}
        }
        return num[low];
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {10,1,10,10,10};
		System.out.println(findMin1(num));
	}

}
