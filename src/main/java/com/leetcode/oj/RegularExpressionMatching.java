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
		String[][] test = {{"a", "ab*"},{"a","."},{"aa","a"},{"aa","aa"},{"aaa","aa"},{"aa", "a*"},{"aab", "dc*a*b"},{"a", "a*"}};
		//String[][] test = {{"ab",".*c"}, {"a", ".*..a*"},{"abcd", "d*"}};
		for (int i = 0; i < test.length; i++) {
			System.out.println(isMatch(test[i][0], test[i][1]));
		}
	}

}
