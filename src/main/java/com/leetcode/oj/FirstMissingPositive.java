/**
 * Source : 
 * Author : Hexiaoqiao
 * Date   : 2014-09-26
 *
 * 0.Problem:
 * Given an unsorted integer array, find the first missing positive integer.
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * 
 * Your algorithm should run in O(n) time and uses constant space.
 * 
 * 1.Refer.:
 * 1.0 重排不在对应顺序上的数据；
 * 1.1 顺序遍历数组找到第一个与顺序号不匹配数据；
 */
package com.leetcode.oj;

public class FirstMissingPositive {
    public static int firstMissingPositive(int[] A) {
    	if (null == A || 0 == A.length) return 1; 
    	int n = A.length;
        for (int i = 0; i < n; i++) {
        	int elem = A[i];
        	while (elem > 0 && elem < n + 1 && elem != A[elem - 1]) {
        		A[i] = A[elem - 1];
        		A[elem - 1] = elem;
        		elem = A[i];
        	}
        }
        for (int i = 0; i < n; i++) {
        	if (i + 1 != A[i]) return i + 1; 
        }
    	return n + 1;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,1};
		System.out.println(firstMissingPositive(A));
	}

}
