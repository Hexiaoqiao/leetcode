/*
0.Problem:
There are two sorted arrays A and B of size m and n respectively. 
Find the median of the two sorted arrays. 
The overall run time complexity should be O(log (m+n)).

1.Refer.: 找两个数组的中位数
1.0 设数组为A[m],B[n] 找两者之间的第k位，则：
	第k位一定在A[k/2]和B[k-k/2]之后；
1.1 比较A[k/2]和B[k-k/2]大小，
	如果A[k/2]>B[k-k/2]则在A[0..m]和B[k-k/2..n]之间找第k-k/2位；
	如果A[k/2]<=B[k-k/2]则在A[k/2,m]和B[0..n]之间找第k-k/2位；
1.2 判断m+n的奇偶后求中位
*/
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
			return 0.5 * (findNthSortedArrays(A, B, len / 2) 
					+ findNthSortedArrays(A, B, len / 2 + 1));
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
