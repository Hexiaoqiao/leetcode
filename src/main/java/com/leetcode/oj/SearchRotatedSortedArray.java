/**
 * Source : http://oj.leetcode.com/problems/search-in-rotated-sorted-array
 *			http://oj.leetcode.com/problems/search-in-rotated-sorted-array-ii
 * Author : Hexiaoqiao
 * Date   : 2014-09-26
 *
 * 0.Problem:
 * 0.0
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * You are given a target value to search. If found in the array return its 
 * index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 * 
 * 0.1
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed?
 * Would this affect the run-time complexity? How and why?
 * Write a function to determine if a given target is in the array.
 * 
 * 1.Refer.:
 * 1.0 折半查找
 * 0.A[mid] = target return
 * 1.A[mid] >= A[low] (A[mid] > target > A[low] high = mid - 1; else low = mid + 1)
 * 2.A[mid] < A[low] (A[mid] < target < A[high] low = mid + 1; else high = mid - 1)
 * 1.1 折半+顺序查找
 * 当A[mid]!=A[low]同1.0
 * 否则low = low + 1
 */
package com.leetcode.oj;

public class SearchRotatedSortedArray {
    public static int search(int[] A, int target) {
        int len = A.length;
        int low = 0;
        int high = len - 1;
        while (low <= high) {
        	int mid = (high + low) / 2;
        	int val = A[mid];
        	if (val == target) {
        		return mid;
        	}
        	if (A[mid] >= A[low]) {
        		if (A[mid] > target && target >= A[low]) {
        			high = mid - 1;
        		} else {
        			low = mid + 1;
        		}
        	} else {
        		if (A[mid] < target && target <= A[high]) {
        			low = mid + 1;
        		} else {
        			high = mid - 1;
        		}
        	}
        }
    	return -1;
    }
    
    public static boolean search1(int[] A, int target) {
        int len = A.length;
        int low = 0;
        int high = len - 1;
        while (low <= high) {
        	int mid = (high + low) / 2;
        	if (A[mid] == target) {
        		return true;
        	}
        	if (A[mid] > A[low]) {
        		if (A[mid] > target && target >= A[low]) {
        			high = mid - 1;
        		} else {
        			low = mid + 1;
        		}
        	} else if (A[mid] < A[low]) {
        		if (A[mid] < target && target <= A[high]) {
        			low = mid + 1;
        		} else {
        			high = mid - 1;
        		}
        	} else {
        		low = low + 1;
        	}
        	
        }
    	return false;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,3,1,1,1};
		System.out.println(search1(A, 3));
	}
}
