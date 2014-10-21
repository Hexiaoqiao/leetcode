/**
 * Source : 
 * Author : Hexiaoqiao
 * Date   : 2014-09-26
 *
 * 0.Problem:
 * Implement wildcard pattern matching with support for '?' and '*'.
 * '?' Matches any single character.
 * '*' Matches any sequence of characters (including the empty sequence).
 * The matching should cover the entire input string (not partial).
 * The function prototype should be:
 * bool isMatch(const char *s, const char *p)
 * Some examples:
 * isMatch("aa","a") → false
 * isMatch("aa","aa") → true
 * isMatch("aaa","aa") → false
 * isMatch("aa", "*") → true
 * isMatch("aa", "a*") → true
 * isMatch("ab", "?*") → true
 * isMatch("aab", "c*a*b") → false
 * 
 * 1.Refer.: Greedy
 * 从字符串s & p头部开始每次都选择当前的局部最优策略，当出现不匹配时回退到上次'*'
 * 下一位继续搜索
 * 
 */
package com.leetcode.oj;

public class WildcardMatching {
    public static boolean isMatch_DP(String s, String p) {
    	if (null == p && null == s) return true;
    	if (null == s || 0 == s.length() 
    			|| null == p || 0 == p.length()) return false;
    	int slen = s.length();
    	int plen = p.length();
    	boolean[][] dp = new boolean[slen + 1][plen + 1];
    	dp[0][0] = true;
    	for (int i = 1; i <= plen; i++) {
    		if (dp[0][i - 1] && '*' == p.charAt(i - 1)) dp[0][i] = true;
    		for (int j = 1; j <= slen; j++) {
    			if ('?' == p.charAt(i - 1)) {dp[j][i] = dp[j - 1][i - 1];}
    			else if ('*' == p.charAt(i - 1)) {dp[j][i] = dp[j][i - 1] || dp[j - 1][i];}
    			else if (s.charAt(j - 1) == p.charAt(i - 1)) {dp[j][i] = dp[j - 1][i - 1];}
    			else dp[j][i] = false;
    		}
    	}
    	return dp[slen][plen];
    }
    
    public static boolean isMatch_Greedy(String s, String p) {
    	if ((null == p && null == s) || (0 == p.length() && 0 == s.length())) return true;
    	if (null == s || null == p) return false;
    	int slen = s.length();
    	int plen = p.length();
    	int sstar = -1;
    	int pstar = -1;
    	int i = 0;
    	int j = 0;
    	while (i < slen) {
    		if (-1 == i || -1 == j) return false; 
    		char sc = s.charAt(i);
    		char pc = 0;
    		if (j < plen) pc = p.charAt(j);
    		if ('?' == pc || sc == pc) {
    			i++;j++;
    		} else if ('*' == pc) {
    			while (j < plen && '*' == p.charAt(j)) j++;
    			if (j == plen) return true;
    			sstar = i;
    			pstar = j;
    		} else if ((j == plen || sc != pc) && (pstar < plen)) {
    			sstar = sstar + 1;
    			i = sstar;
    			j = pstar;
    		} else {
    			return false;
    		}
    	}
    	if (i == slen && j == plen) return true;
    	else if (i == slen)
    		while (j < plen) {
    			if ('*' != p.charAt(j)) return false;
    			j++;
    		}
    	else if (i != slen) return false;
    	return true;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] test = { { "hi", "*?" }, { "aa", "a" }, { "aa", "aa" },
				{ "aaa", "aa" }, { "aa", "*" }, { "aa", "a*" }, { "ab", "?*" },
				{ "aab", "c*a*b" }, { "a", "a*" }, { "", "*" } };
		for (int i = 0; i < test.length; i++) {
			System.out.println(isMatch_DP(test[i][0], test[i][1]));
		}
		System.out.println();
		for (int i = 0; i < test.length; i++) {
			System.out.println(isMatch_Greedy(test[i][0], test[i][1]));
		}
	}

}
