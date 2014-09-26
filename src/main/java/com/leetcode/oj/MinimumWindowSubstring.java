package com.leetcode.oj;

public class MinimumWindowSubstring {
    public static String minWindow(String S, String T) {
    	if (null == S || 0 == S.length()) return "";
    	if (null == T || S.length() < T.length()) return ""; 
    	int[] index = new int[256];
    	boolean[] c = new boolean[256];
    	int slen = S.length();
    	int tlen = T.length();
    	for (int i = 0; i < tlen; i++) {
    		int k = T.charAt(i);
    		index[k] = index[k] + 1;
    		c[k] = true;
    	}
    	int min = S.length() + 1;
    	int count = tlen;
    	int low = -1;
    	int high = -1;
    	String ret = "";
    	for (int i = 0; i < slen; i++) {
    		int k = S.charAt(i);
    		if (!c[k]) {high = i;}
    		else {
    			if (-1 == low) low = i;
    			high = i;
    			index[k] = index[k] - 1;
    			if (index[k] >= 0) count = count - 1;
    		}
    		while (0 == count && low <= high) {
    			if (min > high - low + 1) {
    				min = high - low + 1;
    				ret = S.substring(low, high + 1);
    			}
    			char a = S.charAt(low);
    	    	index[a] += 1;
    	    	if (index[a] > 0) count = count + 1;
    	    	low = low + 1;
        	    while(low < slen && !c[S.charAt(low)]) low = low + 1;
    	    	if (count == 0 && min > high - low + 1) {
    	    		min = high - low + 1;
    	    		ret = S.substring(low, high + 1);
    	    	} 
    		}
    	}
        return ret;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S = "cbcacb";
		String T = "abc";
		System.out.println(minWindow(S, T));
	}

}
