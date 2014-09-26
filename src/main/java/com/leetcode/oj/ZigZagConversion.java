package com.leetcode.oj;

public class ZigZagConversion {
    public static String convert(String s, int nRows) {
    	if (null == s) return null;
    	if (2 >= s.length() || nRows >= s.length()) return s; 
        StringBuffer[] sbs = new StringBuffer[nRows];
        for (int i = 0; i < nRows; i++) {
        	sbs[i] = new StringBuffer();
        }
        int len = s.length();
        int index = 0;
        int i = 0;
        while (index < len) {
	        for (i = 0; i < nRows && index < len; i++) {
	        	sbs[i].append(s.charAt(index));
	        	index = index + 1;
	        }
	        i = i - 2;
	        for (; i > 0 && index < len; i--) {
	        	sbs[i].append(s.charAt(index));
	        	index = index + 1;
	        }
        }
        for (i = 1; i < nRows; i++) {
        	sbs[0].append(sbs[i]);
        }
    	return sbs[0].toString();
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "PAYPALISHIRING";
		System.out.println(convert(s, 2));
	}

}
