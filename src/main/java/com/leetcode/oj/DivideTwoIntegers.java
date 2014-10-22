/**
 * Source : http://oj.leetcode.com/problems/divide-two-integers
 * Author : Hexiaoqiao
 * Date   : 2014-09-26
 *
 * 0.Problem:
 * Divide two integers without using multiplication, 
 * division and mod operator.
 * 
 * 1.Refer.:
 * 1.0 判断结果正负；
 * 1.1 取除数和被除数的绝对值；
 * 1.2 除数逐位左移与被除数比较大小确定最高非零位；
 * 1.3 被除数减去1.2结果作为新的被除数重复1.2直到除数大于被除数；
 */
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
