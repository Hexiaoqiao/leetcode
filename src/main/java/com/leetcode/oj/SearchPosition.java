/**
 * Source : 
 * Author : Hexiaoqiao
 * Date   : 2014-09-26
 *
 * 0.Problem:
 * 0.0
 * Given a sorted array and a target value, return the index 
 * if the target is found. If not, return the index where it 
 * would be if it were inserted in order.
 * You may assume no duplicates in the array.
 * Here are few examples.
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 * 
 * 0.1
 * Given a sorted array of integers, find the starting and 
 * ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order 
 * of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 * 
 * 1.Refer.:
 * 1.0 折半查找
 * 1.1 折半查找+两边顺序查找
 */
package com.leetcode.oj;

public class SearchPosition {
    public static int searchInsert(int[] A, int target) {
    	if (null == A || 0 == A.length) return 0;
        int low = 0;
        int high = A.length - 1;
        while (low < high) {
        	int mid = (low + high)/2;
        	if (A[mid] == target) return mid;
        	else if (A[mid] < target) low = mid + 1;
        	else if (A[mid] > target) high = mid - 1; 
        }
    	return A[low] < target ? low + 1 : low;
    }
    
    public static int[] searchRange(int[] A, int target) {
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        
    	if (null == A || 0 == A.length) return res;
    	int index = 0;
        int low = 0;
        int high = A.length - 1;
        while (low <= high) {
        	int mid = (low + high)/2;
        	if (A[mid] == target) {
        		index = mid;
        		while(index >= 0 && A[index] == target) {index = index - 1;}
        		res[0] = index + 1;
        		index = mid;
        		while(index < A.length && A[index] == target) {index = index + 1;}
        		res[1] = index - 1;
        		return res;
        	}
        	else if (A[mid] < target) low = mid + 1;
        	else if (A[mid] > target) high = mid - 1; 
        }
    	return res;
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {5, 7, 7, 8, 8, 10};
		int target = 10;
		int[] res = searchRange(A, target);
		System.out.println(res[0] + "," + res[1]);
	}

}
