/**
 * Source : http://oj.leetcode.com/problems/decode-ways
 * Author : Hexiaoqiao
 * Date   : 2014-09-26
 *
 * 0.Problem:
 * A message containing letters from A-Z is being encoded to 
 * numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the 
 * total number of ways to decode it.
 * 
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) 
 * or "L" (12).
 * The number of ways decoding "12" is 2.
 * 
 * 1.Refer.:DP
 * 从1..s.len逐个计算解码数量
 * 				  /  0 (s[n] = '0' && s[n]+s[n-1] != {'10','20'})
 * 				  |- numDecodings[n - 2] (s[n] = '0' && s[n]+s[n-1] = {'10','20'})
 * numDecodings[n] = |
 * 				  |- numDecodings[n - 1] (s[n]+s[n-1] not in ['10','26'])
 * 				  \  numDecodings[n - 1] + numDecodings[n - 2] (s[n]+s[n-1] in ['10','26'])
 */
package com.leetcode.oj;

public class DecodeWays {
    public static int numDecodings(String s) {
    	if ((0 == s.length()) || (1 == s.length() && '0' == s.charAt(0))) return 0;
    	if (1 == s.length()) return 1;
    	char a = s.charAt(s.length() - 1);
    	char b = s.charAt(s.length() - 2);
    	int c = (b - '0') * 10 + a - '0';
    	if (2 == s.length()) {
    		if ('0' == a) return 1;
    		else if (c > 10 && c <= 26) {
    			return 2;
    		} else {
    			return 1;
    		}
    	} 
    	if ('0' == a) {
    		if (2 == s.length()) {
    			return 1;
    		} else {
    			return numDecodings(s.substring(0, s.length() - 2));
    		}
    	} else if (c > 26 || c < 10) {
    		return numDecodings(s.substring(0, s.length() - 1));
    	} else {
    		return numDecodings(s.substring(0, s.length() - 1)) + numDecodings(s.substring(0, s.length() - 2));
    	}
    }    
    
    public static int numDecodings3(String s) {
    	if (null == s || 0 == s.length()) return 0;
    	int len = s.length();
    	if (1 == len) {
    		if ('0' == s.charAt(0)) return 0;
    		else return 1;
    	}
    	int[] num = new int[len];
    	if ('0' == s.charAt(0)) {
    		return 0;
    	} else {
    		num[0] = 1;
    	}
    	char a = s.charAt(0);
    	char b = s.charAt(1);
    	int c = (a - '0') * 10 + b - '0';
    	if ('0' == s.charAt(1)) {
    		if (c >= 10 && c < 27) {
    			num[1] = 1;
    		} else {
    			return 0;
      		}
    	} else if (c >= 10 && c < 27) {
    		num[1] = 2;
    	} else {
    		num[1] = 1;
    	}
    	
    	for (int i = 2; i < len; i++) {
        	char d = s.charAt(i - 1);
        	char e = s.charAt(i);
        	int f = (d - '0') * 10 + e - '0';
        	if ('0' == e) {
        		if (f >= 10 && f < 27) {
        			num[i] = num[i - 2];
        		} else {
        			return 0;
        		}
        	} else if (f >= 10 && f < 27) {
        		num[i] = num[i - 1] + num[i - 2];
        	} else {
        		num[i] = num[i - 1];
        	}
    	}
    	return num[len - 1];
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "2201";
		System.out.println(numDecodings3(s));
	}
}
