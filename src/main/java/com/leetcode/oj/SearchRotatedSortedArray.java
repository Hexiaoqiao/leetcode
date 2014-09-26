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
