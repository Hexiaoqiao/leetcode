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
