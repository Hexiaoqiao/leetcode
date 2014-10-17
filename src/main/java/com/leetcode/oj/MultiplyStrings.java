/*
0.Problem:
Given two numbers represented as strings, return multiplication 
of the numbers as a string.
Note: The numbers can be arbitrarily large and are non-negative.

1.Refer.:
同两个数相乘的规则逐位相乘对结果进行组合（错位）求和
*/
package com.leetcode.oj;

import java.util.ArrayList;
import java.util.List;

public class MultiplyStrings {
    public static String multiply(String num1, String num2) {
    	int len1 = num1.length();
    	int len2 = num2.length();
    	List<Integer> res = new ArrayList<Integer>();
    	for (int i = len2 - 1; i >= 0; i--) {
    		//if ('0' == num2.charAt(i)) continue; 
    		for (int j = len1 - 1; j >= 0; j--) {
    			int start = len2 - 1 - i +  len1 - 1 - j;
    			Integer a = num2.charAt(i) - '0';
    			Integer b = num1.charAt(j) - '0';
    			Integer first = a * b % 10;
    			Integer secrd = a * b / 10;
    			int inc = 0;
    			int s = res.size();
    			for (int k = 0; k < start - s + 2; k++) res.add(0, 0);
    			first = first + res.get(res.size() - 1 - start);
    			inc = first / 10;
    			first = first % 10;
    			res.set(res.size() - 1 - start, first);
    			secrd = secrd + res.get(res.size() - 2 - start) + inc;
    			inc = secrd / 10;
    			secrd = secrd % 10;
    			res.set(res.size() - 2 - start, secrd);
    			int ii = 1;
    			while (0 != inc) {
    				int index = res.size() - 2 - start - ii;
    				ii = ii + 1;
    				if (index < 0) {
    					res.add(0,0);
    					res.set(0, inc);
    					break;
    				} else {
    					int r = res.get(index) + inc;
    					res.set(index, r % 10);
    					inc = r / 10;
    				}
       			} 
    		}
    	}
    	StringBuffer sb = new StringBuffer();
    	int i = 0;
    	for (i = 0; i < res.size(); i++) if (0 != res.get(i)) break;
    	for (;i < res.size(); i++) sb.append(res.get(i));
    	return 0 == sb.length() ? "0" : sb.toString();
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String num1 = "999";
		String num2 = "91";
		System.out.println(multiply(num1, num2));
	}

}
