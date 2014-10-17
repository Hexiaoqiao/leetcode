/*
0.Problem:
Given a string S, find the longest palindromic substring in S. 
You may assume that the maximum length of S is 1000, and there 
exists one unique longest palindromic substring.

1.Refer.:
1.0 从头开始循环测试：符合palindromic的子字符串包含两种情况：以当前字符为
中心字符和从当前字符开始就对称；所以调用longestPalindromeByMid(s,i,j)时
i=j或i+1=j
*/
package com.leetcode.oj;

public class LongestPalindromicSubstring {
	public static String longestPalindromeByMid(String s, int i, int j) {
		if (i != j && i != j - 1) {
			return null;
		}
		int l = i, r = j;
		while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
			l--;r++;
		}
		return s.substring(l+1, r);
	}
	public static String longestPalindrome(String s) {
		String ret = null;
		int len = s.length();
		if (len < 2) {
			return len == 1 ? s : "";
		}
		for (int i = 0; i < len - 1; i++) {
			String r1 = longestPalindromeByMid(s, i, i);
			String r2 = longestPalindromeByMid(s, i, i + 1);
			String tmp = null;
			if (null != r1 && null != r2)
				tmp = r1.length() > r2.length() ? r1 : r2;
			if (null != tmp) {
				if (null == ret) ret = tmp;
				else ret = ret.length() > tmp.length() ? ret : tmp;
			}
		}
        return null == ret ? "" : ret;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aa";
		System.out.println(longestPalindrome(s));
	}

}
