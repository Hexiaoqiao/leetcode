/**
 * Source : 
 * Author : Hexiaoqiao
 * Date   : 2014-09-26
 *
 * 0.Problem:
 * The string "PAYPALISHIRING" is written in a zigzag pattern on 
 * a given number of rows like this: (you may want to display this 
 * pattern in a fixed font for better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion 
 * given a number of rows:
 * 
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * 
 * 1.Refer.:
 * 1.0 新建字符串数组StringBuffer[nrows];
 * 1.1 按照规则逐个往数组里添加字符；
 * 1.2 合并字符串数组即为结果。
 */
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
