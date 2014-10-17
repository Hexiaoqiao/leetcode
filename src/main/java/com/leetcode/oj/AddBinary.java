/*
0.Problem:
Given two binary strings, return their sum (also a binary string).
For example,
    a = "11"
    b = "1"
    Return "100".
1.Refer.:
1.0从后往前逐位、进位相加；
*/
package com.leetcode.oj;

public class AddBinary {
    public static String addBinary(String a, String b) {
        StringBuffer sb = new StringBuffer();
        int alen = a.length();
        int blen = b.length();
        int isin = 0;
        int i = 0, j = 0;
        for (i = alen - 1, j = blen - 1; i >= 0 && j >= 0; i--, j--) {
        	int ac = a.charAt(i) - '0';
        	int bc = b.charAt(j) - '0';
        	int sum = isin + ac + bc;
        	sb.insert(0, sum % 2);
        	isin = sum / 2;
        }
        for (; i >= 0; i--) {
        	int sum = a.charAt(i) - '0' + isin;
        	sb.insert(0, sum % 2);
        	isin = sum / 2;
        }
        for (; j >= 0; j--) {
        	int sum = b.charAt(j) - '0' + isin;
        	sb.insert(0, sum % 2);
        	isin = sum / 2;
        }
        if (1 == isin) sb.insert(0, "1");
    	return sb.toString();
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a = "111";
		String b = "1110";
		System.out.println(addBinary(a, b));
	}

}
