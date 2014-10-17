/*
0.Problem:
Implement pow(x, n).

1.Refer.：refer代码
*/
package com.leetcode.oj;

public class PowXN {
    public static double pow(double x, int n) {
        if (0 == n) return 1;
        else {
        	double tmp = pow(x, n/2);
        	if (0 == n % 2) {
        		return tmp * tmp;
        	} else {
        		if (n > 0) {
        			return tmp * tmp * x;
        		} else {
        			return tmp * tmp / x;
        		}
        	}
        }
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
