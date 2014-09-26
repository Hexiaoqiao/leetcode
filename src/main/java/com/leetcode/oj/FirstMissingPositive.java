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
