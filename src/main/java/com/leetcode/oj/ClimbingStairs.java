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
