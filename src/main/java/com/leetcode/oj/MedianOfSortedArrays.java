package com.leetcode.oj;

public class MedianOfSortedArrays {
	public static int min(int a, int b) {
		return a > b ? b : a;
	}
	public static double findNthSortedArrays(int A[], int B[], int nth) {
		int alen = A.length;
		int blen = B.length;
		int i = 0, j = 0;
		while (i < alen && j < blen) {
			if (1 == nth) {
				return min(A[i], B[j]);
			}
			int nth1 = nth / 2;
			int nth2 = nth - nth1;
			nth1 = min(nth1, alen - i);
			nth2 = min(nth2, blen - j);
			if (A[i + nth1 - 1] > B[j + nth2 - 1] ) {
				nth = nth - nth2;
				j = j + nth2;
			} else {
				nth = nth - nth1;
				i = i + nth1;
			}
		}
		if (i == alen) {
			return B[j + nth - 1];
		} else {
			return A[i + nth - 1];
		}
	}
    public static double findMedianSortedArrays(int A[], int B[]) {
    	int alen = A.length;
    	int blen = B.length;
    	int len = alen + blen;
    	if (0 == len % 2) {
    		return 0.5 * (findNthSortedArrays(A, B, len / 2) + findNthSortedArrays(A, B, len / 2 + 1));
    	} else {
    		return findNthSortedArrays(A, B, len / 2 + 1);
    	}
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {7};
		int[] B = {2,3,4,5,6};
		System.out.println(findMedianSortedArrays(A, B));
	}

}
