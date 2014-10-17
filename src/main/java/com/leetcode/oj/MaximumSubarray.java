/*
0.Problem:
Find the contiguous subarray within an array (containing at least 
one number) which has the largest sum.
For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
the contiguous subarray [4,−1,2,1] has the largest sum = 6.

More practice:
If you have figured out the O(n) solution, try coding another solution 
using the divide and conquer approach, which is more subtle.

1.Refer.:Divide and Conquer
1.0 将数组分成等长的两个字串；
1.1 最大连续子串要不在两个字串中或者在中间；
1.2 遍历处理中间数据
*/
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
