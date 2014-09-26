package com.leetcode.oj;

public class DivideTwoIntegers {
    public static int divide(int dividend, int divisor) {
    	long divid = Math.abs((long)dividend);
    	long divir = Math.abs((long)divisor);
    	boolean isNg = (dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0);
    	int res = 0;
    	while (divir <= divid) {
    		long count = 1;
    		long sum = divir;
    		while (sum <= divid) {
    			count = count << 1;
    			sum = sum << 1;
    		}
    		count = count >> 1;
    		sum = sum >> 1;
    		res = (int) (res + count);
    		divid = divid - sum;
    	}
        return isNg ? 0 - res : res;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(divide(-1010369383, -2147483648));
	}

}
