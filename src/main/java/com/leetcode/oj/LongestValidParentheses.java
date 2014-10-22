/**
 * Source : http://oj.leetcode.com/problems/longest-valid-parentheses
 * Author : Hexiaoqiao
 * Date   : 2014-09-26
 *
 * 0.Problem:
 * Given a string containing just the characters '(' and ')', find 
 * the length of the longest valid (well-formed) parentheses substring.
 * For "(()", the longest valid parentheses substring is "()", which 
 * has length = 2.
 * Another example is ")()())", where the longest valid parentheses 
 * substring is "()()", which has length = 4.
 * 
 * 1.Refer.:栈
 * 同ValidParentheses 1.1，同时记录当前最大匹配括号对的长度
 */
package com.leetcode.oj;

import java.util.Stack;

public class LongestValidParentheses {
    public static int longestValidParentheses(String s) {
    	int max = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	if ('(' == c) {
        		stack.push(i);
        	} else {
        		if (!stack.isEmpty() && '(' == s.charAt(stack.peek())) {
        			stack.pop();
        			int len = i + 1;
        			if (!stack.isEmpty())
        				len = i - stack.peek();
        			max = max < len ? len : max;
        		} else {
        			stack.push(i);
        		}
        	}
        }
    	return max;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "()())(";
		System.out.println(longestValidParentheses(s));
	}

}
