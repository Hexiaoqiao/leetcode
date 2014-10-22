/**
 * Source : http://oj.leetcode.com/problems/sqrtx
 * Author : Hexiaoqiao
 * Date   : 2014-09-26
 *
 * 0.Problem:
 * Implement int sqrt(int x).
 * Compute and return the square root of x.
 * 
 * 1.Refer.:
 * 1.0 遍历结果的每一位是否为1；通过相乘判断；抑或
 */
package com.leetcode.oj;

public class Sqrt {
    public static int sqrt(int x) {
    	if (0 == x) return 0;
    	long bit = 1l << 16;
    	long res = 0;
    	while (bit != 0) {
    		res = res | bit;
    		if (res * res > x) res = res ^ bit; 
    		bit = bit >> 1;
    	}
        return (int) res;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(sqrt(256));
		System.out.println(1l<<33);
	}

}
