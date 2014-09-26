package com.leetcode.oj;

public class Atoi {
	public static int atoi(String str) {
		int len = str.length();
		int sign = 1;
		long res = 0;
		int i = 0;
		for (i = 0; i < len && ' ' == str.charAt(i); i++);
		if (i == len) return 0;
		char s = str.charAt(i);
		if ('-' == s || '+' == s) {
			sign = '-' == s ? -1 : 1;
			i = i + 1;
		}
		//for (; i < len && ' ' == str.charAt(i); i++);
		for (; i < len; i++) {
			char c = str.charAt(i);
			if (c > '9' || c < '0') {
				break;
			}
			res = res * 10L + c - '0';
		}
		res = res * sign;
		if (res > Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		} else if (res < Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		} else {
			return (int) res;
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(atoi("    -2147483649  "));
	}

}
