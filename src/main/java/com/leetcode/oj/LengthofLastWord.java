/*
0.Problem:
Given a string s consists of upper/lower-case alphabets and empty 
space characters ' ', return the length of last word in the string.
If the last word does not exist, return 0.
Note: A word is defined as a character sequence consists of non-space 
characters only.
For example, 
Given s = "Hello World",
return 5.

1.Refer.:边界条件
从字符串倒序遍历，遇到空格等退出，记录遍历长度；
*/
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
