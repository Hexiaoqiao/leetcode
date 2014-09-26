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
