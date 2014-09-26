package com.leetcode.oj;

public class ValidNumber {
    public static boolean isNumber(String s) {
        s = s.trim();
        if (0 == s.length()) return false;
        int i = 0;
        if (s.charAt(i) == '+' || s.charAt(i) == '-') i++;
        if (i == s.length()) return false;
        char c = s.charAt(i);
        i++;
        boolean flag = (c >= '0' && c <= '9') || '.' == c;
        while (i < s.length() && c >= '0' && c <= '9') { 
        	c = s.charAt(i);
        	i++;
        }
        if ('.' != c && (c < '0' || c > '9')) return false;
        if ('.' != c && i == s.length()) return true;
        if (c == '.') {
        	
        	if (i != 1 && i == s.length()) return true;
        	if (1 == i && i == s.length()) return false;
        	c = s.charAt(i);
        	i++;
        	flag = flag | (c >= '0' && c <= '9');
        	while (i < s.length() && c >= '0' && c <= '9') {c = s.charAt(i);i++;}
        	if (c < '0' || c > '9') return false;
        	if (i == s.length()) return true;
        }
        if (!flag) return false;
        if (c == 'e' || c == 'E') {
        	if (i == s.length()) return false;
        	c = s.charAt(i);
        	if ('-' == c || '+' == c) i++;
        	if (i == s.length()) return false;
        	c = s.charAt(i);
        	i++;
        	if (c < '0' || c > '9') return false;
        	while (i < s.length() && c >= '0' && c <= '9') {
        		c = s.charAt(i);
        		i++;
        	}
        	if (c < '0' || c > '9') return false;
        	if (i == s.length()) return true;
        	else return false;
        } 
    	return false;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "2e0";
		System.out.println(isNumber(s));
	}

}
