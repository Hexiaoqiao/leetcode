package com.leetcode.oj;

import java.util.Arrays;

public class ScrambleString {
    public static boolean isScramble(String s1, String s2) {
        if (null == s1 || null == s2 || s1.length() != s2.length()) {
        	return false;
        }
        if (1 == s1.length() && 1 == s2.length() && s1.charAt(0) == s2.charAt(0)) return true; 
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        if (!Arrays.equals(a, b)) return false;
        for (int i = 1; i < s1.length(); i++) {
        	if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i, s1.length()), s2.substring(i, s2.length()))) return true;
        	if (isScramble(s1.substring(0, i), s2.substring(s2.length() - i, s2.length())) && isScramble(s1.substring(i, s1.length()), s2.substring(0, s1.length() - i))) return true;
        }
    	return false;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isScramble("rgtae", "great"));
	}

}
