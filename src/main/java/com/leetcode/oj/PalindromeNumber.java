/**
 * Source : http://oj.leetcode.com/problems/palindrome-number
 * Author : Hexiaoqiao
 * Date   : 2014-09-26
 *
 * 0.Problem:
 * Determine whether an integer is a palindrome. Do this without extra space.
 * Some hints:
 * Could negative integers be palindromes? (ie, -1)
 * If you are thinking of converting the integer to string, 
 * note the restriction of using extra space.
 * You could also try reversing an integer. However, if you have 
 * solved the problem "Reverse Integer", you know that the reversed 
 * integer might overflow. How would you handle such case?
 * There is a more generic way of solving this problem.
 * 
 * 1.Refer.:
 * 1.0 数字两头匹配；
 * 1.1 若相等，摘掉两头继续；否则返回false；
 */
package com.leetcode.oj;

public class PalindromeNumber {
    public static boolean isPalindrome(int x) {
    	if (x < 0) return false;
    	if (0 == x) return true;
        int n = x;
        int len = 0;
        while (0 != n) {
        	len = len + 1;
        	n = n / 10;
        }
        int devide = 10;
        int qrt = 1;
        for (int i = 1; i < len; i++) {
        	qrt = qrt * 10;
        }
        for (int i = 0; i < len / 2; i++) {
        	if (x % devide != x / qrt) return false;
        	x = x % qrt;
        	x = x / devide;
        	qrt = qrt / 100;
        }
    	return true;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome(11));
	}

}
