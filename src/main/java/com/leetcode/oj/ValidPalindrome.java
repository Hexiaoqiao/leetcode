package com.leetcode.oj;

public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
    	StringBuffer str = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	if (c >= 'a' && c <= 'z') {
        		str.append(c);
        	} else if (c >= '0' && c <= '9') {
        		str.append(c);
        	} else if (c >= 'A' && c <= 'Z') {
        		str.append((char) (c - 'A' + 'a'));
        	}
        }
        int len = str.length();
        if (2 > len) return true;
        for (int j = len / 2; j >= 0; j--) {
        	if (str.charAt(j) != str.charAt(len - j - 1)) {
        		return false;
        	}
        }
        return true;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome("0k.;r0.k;"));
	}

}
