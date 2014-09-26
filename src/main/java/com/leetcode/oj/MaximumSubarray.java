package com.leetcode.oj;

public class MaximumSubarray {
    public static int maxSubArray(int[] A, int s, int e) {
    	if (1 >= e - s) {
    		if (s < 0) return A[0];
    		else if (s >= A.length) return A[A.length - 1];
    		else return A[s];
    	}
    	int mid = (s + e)/2;
    	int leftmax = maxSubArray(A, s, mid);
    	int rightmax = maxSubArray(A, mid + 1, e);
    	int midmax = A[mid];
    	int tmp = 0;
    	for (int i = mid; i >= s; i--) {
    		tmp = tmp + A[i];
    		if (tmp > midmax) {midmax = tmp;}
    	}
    	tmp = midmax;
    	for (int i = mid + 1; i < e; i++) {
    		tmp = tmp + A[i];
    		if (tmp > midmax) {midmax = tmp;} 
    	}
    	int max = midmax;
    	if (leftmax > max) max = leftmax;
    	if (rightmax > max)	max = rightmax;
    	return max;
    }
	public static int maxSubArray(int[] A) {
        return maxSubArray(A, 0, A.length);
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {-2,0,-3,-3};
		System.out.println(maxSubArray(A));
	}

}
