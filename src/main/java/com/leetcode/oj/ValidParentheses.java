package com.leetcode.oj;

import java.util.ArrayList;
import java.util.List;

import com.leetcode.oj.PartitionList.ListNode;

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
