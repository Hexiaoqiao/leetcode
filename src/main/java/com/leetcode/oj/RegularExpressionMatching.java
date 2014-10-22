/**
 * Source : http://oj.leetcode.com/problems/regular-expression-matching
 * Author : Hexiaoqiao
 * Date   : 2014-09-26
 *
 * 0.Problem:
 * Implement regular expression matching with support for '.' and '*'.
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "a*") → true
 * isMatch("aa", ".*") → true
 * isMatch("ab", ".*") → true
 * isMatch("aab", "c*a*b") → true
 * 
 * 1.Refer.:递归
 * 1.0 普通字符或.正常匹配；
 * 1.1 遇到*时递归两种情况
 * isMatch(s, i, p, j + 2) return true;
 * 或
 * for (i++ && s[i]=p[j]) isMatch(s, i + 1, p, j + 2) return true; 
 * 
 */
package com.leetcode.oj;

public class RegularExpressionMatching {
    public static boolean isMatch(String s, int i, String p, int j) {
    	int slen = s.length();
    	int plen = p.length();
    	if (i >= slen && j >= plen) return true;
    	else if (j >= plen) {
    		return false;
    	} else if (i >= slen) {
    		if ('*' == p.charAt(j)) return isMatch(s, i, p, j + 1);
    		else if (j < plen - 1 && '*' == p.charAt(j + 1)) return isMatch(s, i, p, j + 2); 
    		else return false;
    	}
    	if (j == plen - 1 ) {
    		if (i == slen - 1 && ('.' == p.charAt(j) || p.charAt(j) == s.charAt(i))) return true;
    		else return false;
    	} else if ('*' != p.charAt(j + 1)) {
    		if ((s.charAt(i) == p.charAt(j)) || ('.' == p.charAt(j) && i < slen)) {
    			return isMatch(s, i+1, p, j+1);
    		} else {
    			return false;
    		}
    	} else {
    		if (isMatch(s, i, p, j + 2)) return true;
    		while ((s.charAt(i) == p.charAt(j)) || ('.' == p.charAt(j) && i < slen)) {
    			if (isMatch(s, i + 1, p, j + 2)) return true;
    			i++;
    			if (i >= slen) return false;
    		}
    		if (i >= slen && j >= slen) return true;
    		else return false;
    	}
    }
    
    public static boolean isMatch(String s, String p) {
    	if (null == s && null == p) return true;
    	else if (null == s || null == p) return false;
    	int slen = s.length();
    	int plen = p.length();
    	if (0 == slen && 0 == plen) return true;
    	return isMatch(s, 0, p, 0);
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] test = { { "a", "ab*" }, { "a", "." }, { "aa", "a" },
				{ "aa", "aa" }, { "aaa", "aa" }, { "aa", "a*" },
				{ "aab", "dc*a*b" }, { "a", "a*" } };
		//String[][] test = {{"ab",".*c"}, {"a", ".*..a*"},{"abcd", "d*"}};
		for (int i = 0; i < test.length; i++) {
			System.out.println(isMatch(test[i][0], test[i][1]));
		}
	}

}
