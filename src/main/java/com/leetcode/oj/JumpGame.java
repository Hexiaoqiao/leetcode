/**
 * Source : http://oj.leetcode.com/problems/jump-game
 *			http://oj.leetcode.com/problems/jump-game-ii
 * Author : Hexiaoqiao
 * Date   : 2014-09-26
 *
 * 0.Problem:
 * 0.0
 * Given an array of non-negative integers, you are initially positioned 
 * at the first index of the array.
 * Each element in the array represents your maximum jump length at that 
 * position.
 * Determine if you are able to reach the last index.
 * For example:
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 * 
 * 0.1
 * Given an array of non-negative integers, you are initially positioned 
 * at the first index of the array.
 * Each element in the array represents your maximum jump length at that 
 * position.
 * Your goal is to reach the last index in the minimum number of jumps.
 * For example:
 * Given array A = [2,3,1,1,4]
 * The minimum number of jumps to reach the last index is 2. (Jump 1 step 
 * from index 0 to 1, then 3 steps to the last index.)
 * 
 * 1.Refer.:
 * 1.0 DP
 * max = max{i + A[i]}
 * true when max >= A.len
 * 
 * 1.1
 * 1.1.0 一步能到的最近和最远距离
 * 1.1.1 遍历最近和最远之间的所有情况
 */
package com.leetcode.oj;

public class JumpGame {
    public static boolean canJump(int[] A) {
    	int max = 0;
    	for (int i = 0; i < A.length; i++) {
    		if (max < i) return false;
    		if (max >= A.length - 1) return true;
    		if (i + A[i] > max) max = i + A[i];
    	}
    	return false;
    }
    
    public static int jump(int[] A) {
    	if (null == A || 0 == A.length) return -1; 
    	int len = A.length;
    	int[] step = new int[len];
    	step[len - 1] = 0;
    	for (int i = len - 2; i >= 0; i--) {
    		int min = len + 1;
    		for (int j = i + 1; j <= i + A[i] && j < len; j++) {
    			if (min > 1 + step[j]) {
    				min = 1 + step[j];
    			}
    		}
    		step[i] = min;
    	}
        return step[0];
    }
    
    public static int jump2(int[] A) {
    	if (null == A || 0 == A.length) return -1;
    	int len = A.length;
        int step = 0;
        int low = 0;
        int high = 0;
        if (1 == len) return 0;
        while(low <= high) {
            ++step;
            int last = high;
            for(int i = low; i <= last; ++i) {
                int ld = i + A[i];
                if (ld >= len-1)
                    return step;
                if (ld > high) {
                    high = ld;
                }
            }
            low = last + 1;
        }
        return step;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {2,3,1,1,2};
		System.out.println(jump2(A));
	}

}
