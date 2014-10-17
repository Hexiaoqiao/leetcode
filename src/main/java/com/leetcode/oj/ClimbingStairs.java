/*
0.Problem:
You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct 
ways can you climb to the top?

1.Refer.:DP
1.0 
 		  /dp[i - 1] + dp[i - 2]; when i >= 2
dp[i] = -| 
		  \1; when i < 2;
说明：最后一步只有两种可能：climb 1 step or Climb 2 steps
*/
package com.leetcode.oj;

public class ClimbingStairs {
    public static int climbStairs(int n) {
    	if (n < 2) return n;
    	int[] ways = new int[n + 1];
        for (int i = 0; i <= n; i++) {
        	if (i < 2) {
        		ways[i] = 1;
        	} else {
        		ways[i] = ways[i - 1] + ways[i - 2];
        	}
        }
    	return ways[n];
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(climbStairs(20));
	}

}
