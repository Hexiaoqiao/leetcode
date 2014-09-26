package com.leetcode.oj;

public class MergeSortedArray {
    public static void merge(int A[], int m, int B[], int n) {
    	int i = 0, j = 0, index = 0;
    	for (i = m - 1, j = n - 1, index = m + n - 1; i >= 0 && j >= 0; index--) {
    		if (A[i] < B[j]) {
    			A[index] = B[j];
    			j--;
    		} else {
    			A[index] = A[i];
    			i--;
    		}
    	}
    	for (; j >= 0; j--) {
    		A[index] = B[j];
    		index--;
    	}
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,8,0,0,0,0,0};
		int[] B = {2,3,9,10};
		int m = 2;
		int n = 0;
		merge(A, m, B, n);
		for (int i = 0; i < m + n; i++) {
			System.out.print(A[i] + " ");
		}
	}

}
