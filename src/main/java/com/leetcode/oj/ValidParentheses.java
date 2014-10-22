/**
 * Source : http://oj.leetcode.com/problems/valid-parentheses
 * 			http://oj.leetcode.com/problems/generate-parentheses
 * Author : Hexiaoqiao
 * Date   : 2014-09-26
 *
 * 0.Problem:
 * 0.0
 * Given n pairs of parentheses, write a function to generate all 
 * combinations of well-formed parentheses.
 * For example, given n = 3, a solution set is:
 * "((()))", "(()())", "(())()", "()(())", "()()()"
 * 
 * 0.1
 * Given a string containing just the characters '(', ')', '{', '}', 
 * '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" 
 * are all valid but "(]" and "([)]" are not.
 * 
 * 1.Refer.:
 * 1.0 递归
 * generateParentheses(int left, int right, String s, List<String> res)
 * 其中：left和right分别表示左括号右括号剩余的个数，当lefr=right=0时，res.add(s)
 * 
 * 1.1 栈
 * 左括号入栈，右括号出栈，最后栈空为true
 * 其他情况均false
 * 
 */
package com.leetcode.oj;

import java.util.ArrayList;
import java.util.List;

public class ValidParentheses {
    public static boolean isValid(String s) {
        List<Character> stack = new ArrayList<Character>();
    	for (int i = 0; i < s.length(); i++) {
    		Character c = s.charAt(i);
    		char cv = c.charValue();
    		if (cv == '(' || cv == '[' || cv == '{') {
        		stack.add(c);
        	} else if (cv == ')') {
        		if (stack.size() == 0 || stack.remove(stack.size() - 1).charValue() != '(') return false;
        	} else if (cv == ']') {
        		if (stack.size() == 0 || stack.remove(stack.size() - 1).charValue() != '[') return false;
        	} else if (cv == '}') {
        		if (stack.size() == 0 || stack.remove(stack.size() - 1).charValue() != '{') return false;
        	}
        }
    	if (stack.size() != 0) return false;
    	return true;
    }
    
    public static void generateParentheses(int left, int right, String s, List<String> res) {
    	if (left == 0 && right == 0) {res.add(s); return;}
    	if (left > right) return;
    	if (left > 0) generateParentheses(left - 1, right, s + "(", res);
    	if (right > 0) generateParentheses(left, right - 1, s + ")", res);
    }
    
    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        generateParentheses(n, n, "", res);
        return res;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> res = generateParenthesis(4);
		for (String s : res) {
			System.out.println(s);
		}
	}

}
