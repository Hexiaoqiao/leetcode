package com.leetcode.oj;

public class LengthofLastWord {
    public static int lengthOfLastWord(String s) {
        int len = s.length();
        if (0 == len) {return 0;}
        int i = 0, j = 0;
        for (i = len - 1; i >= 0; i--) {
        	if (' ' != s.charAt(i)) break; 
        }
        if (0 > i) return 0;
        for (j = i; j >= 0; j--) {
        	if (' ' == s.charAt(j)) break;
        }
        return i - j;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "a wo";
		System.out.println(lengthOfLastWord(s));
	}

}