package com.leetcode.oj;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
    	if (null == strs || 0 == strs.length) return "";
    	String prefix = strs[0];
    	for (int i = 0; i < strs.length; i++) {
    		String str = strs[i];
    		int j = 0;
    		for(j = 0; j < prefix.length(); j++) {
    			if (j >= str.length() || prefix.charAt(j) != str.charAt(j)) break; 
    		}
    		prefix = prefix.substring(0, j);
    	}
    	return prefix;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = {"aa","a"};
		System.out.println(longestCommonPrefix(strs));
	}

}
