/*
0.Problem:
Reverse digits of an integer.
Example1: x = 123, return 321
Example2: x = -123, return -321

Have you thought about this?
Here are some good questions to ask before coding. 
Bonus points for you if you have already thought through this!
If the integer's last digit is 0, what should the output be? 
ie, cases such as 10, 100.
Did you notice that the reversed integer might overflow? 
Assume the input is a 32-bit integer, then the reverse of 
1000000003 overflows. How should you handle such cases?
Throw an exception? Good, but what if throwing an exception is 
not an option? You would then have to re-design the function 
(ie, add an extra parameter).

1.Refer.:
1.0 符号判断；
1.1 通过long存储中间结果，超出int范围结果返回0；
*/
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
