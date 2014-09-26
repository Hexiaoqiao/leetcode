package com.leetcode.oj;

public class ReverseInteger {
    public static int reverse(int x) {
        int sign = x < 0 ? -1 : 1;
    	int raw = x < 0 ? -1 * x : x;
    	long res = 0;
    	do {
    		res = res * 10L + raw % 10L;
    		raw = raw / 10;
    	} while (raw != 0);
    	if (res > Integer.MAX_VALUE) return 0;
    	else return (int) (sign * res);
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Integer.MAX_VALUE);
		System.out.println(reverse(2147483642));
	}

}
