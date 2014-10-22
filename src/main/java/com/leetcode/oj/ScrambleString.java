/**
 * Source : http://oj.leetcode.com/problems/scramble-string
 * Author : Hexiaoqiao
 * Date   : 2014-09-26
 *
 * 0.Problem:
 * Given a string s1, we may represent it as a binary tree by 
 * partitioning it to two non-empty substrings recursively.
 * Below is one possible representation of s1 = "great":
 *     great
 *    /    \
 *   gr    eat
 *  / \    /  \
 * g   r  e   at
 *            / \
 *           a   t
 * To scramble the string, we may choose any non-leaf node and 
 * swap its two children.
 * For example, if we choose the node "gr" and swap its two 
 * children, it produces a scrambled string "rgeat".
 *     rgeat
 *    /    \
 *   rg    eat
 *  / \    /  \
 * r   g  e   at
 *            / \
 *           a   t
 * We say that "rgeat" is a scrambled string of "great".
 * Similarly, if we continue to swap the children of nodes "eat" 
 * and "at", it produces a scrambled string "rgtae".
 *     rgtae
 *    /    \
 *   rg    tae
 *  / \    /  \
 * r   g  ta  e
 *        / \
 *       t   a
 * We say that "rgtae" is a scrambled string of "great".
 * Given two strings s1 and s2 of the same length, determine 
 * if s2 is a scrambled string of s1.
 * 
 * 
 * 1.Refer.: 递归
 * 1.0 排序两个字符串确认其中包含的字符相同
 * 1.1 
 * 递归
 * S1.substr(0,i)与S2.substr(0,i) 和 S1.substr(i+1,len)与S2.substr(i+1,len)
 * 是否互为scrambled string
 * 或者
 * S1.substr(0,i)与S2.substr(len-i,len) 和 S1.substr(i+1,len)与S2.substr(0,len-i)
 * 是否互为scrambled string
 */
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
			if (isScramble(s1.substring(0, i), s2.substring(0, i))
					&& isScramble(s1.substring(i, s1.length()),s2.substring(i, s2.length())))
				return true;
			if (isScramble(s1.substring(0, i),s2.substring(s2.length() - i, s2.length()))
					&& isScramble(s1.substring(i, s1.length()),s2.substring(0, s1.length() - i)))
				return true;
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
