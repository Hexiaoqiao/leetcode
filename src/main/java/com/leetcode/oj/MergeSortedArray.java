/**
 * Source : 
 * Author : Hexiaoqiao
 * Date   : 2014-09-26
 *
 * 0.Problem:
 * Given two sorted integer arrays A and B, merge B into A as 
 * one sorted array.
 * Note:
 * You may assume that A has enough space (size that is greater
 * or equal to m + n) to hold additional elements from B. The 
 * number of elements initialized in A and B are m and n respectively.
 * 
 * 1.Refer.:
 * 倒序遍历两个数组进行合并
 */
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
