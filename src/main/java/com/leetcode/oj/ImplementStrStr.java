/*
0.Problem:
Implement strStr().
Returns a pointer to the first occurrence of needle in haystack, 
or null if needle is not part of haystack.

1.Refer.:
两重循环
*/
package com.leetcode.oj;

public class ImplementStrStr {
    public static String strStr(String haystack, String needle) {
        if (null == haystack || null == needle) return null;
        if ("".equals(needle)) return haystack;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
        	int t = i;
        	int j = 0;
        	for (j = 0; t < haystack.length() && j < needle.length(); j++, t++) {
        		if (haystack.charAt(t) != needle.charAt(j)) break;
        	}
        	if (j == needle.length()) return haystack.substring(i); 
        }
    	return null;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String haystack = "a";
		String needle = "a";
		System.out.println(strStr(haystack, needle));
	}

}
