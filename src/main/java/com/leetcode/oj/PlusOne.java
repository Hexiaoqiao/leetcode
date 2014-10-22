/**
 * Source : http://oj.leetcode.com/problems/plus-one
 * Author : Hexiaoqiao
 * Date   : 2014-09-26
 *
 * 0.Problem:
 * Given a non-negative number represented as an array of digits, 
 * plus one to the number.
 * The digits are stored such that the most significant digit is 
 * at the head of the list.
 * 
 * 1.Refer.: refer code
 */
package com.leetcode.oj;

import java.util.Arrays;

public class PlusOne {
    public static int[] plusOne(int[] digits) {
        int[] res = new int[digits.length + 1];
        boolean isin = false;
        for (int i = digits.length - 1; i >= 0; i--) {
        	int t = 0;
        	if (i == digits.length - 1 || isin) t = digits[i] + 1;
        	else t = digits[i];
        	res[i + 1] = t % 10;
        	if (0 == t / 10) isin = false;
        	else isin = true;
        }
        if (isin) {
        	res[0] = 1;
        	return res;
        } else {
        	return Arrays.copyOfRange(res, 1, digits.length + 1);
        }
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] digits = {1,9,9,9};
		int[] res = plusOne(digits);
		for (int i = 0; i < res.length; i++) {
			System.out.print(res[i]);
		}
		
	}

}
