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
