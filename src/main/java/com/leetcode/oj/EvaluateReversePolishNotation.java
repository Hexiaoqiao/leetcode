package com.leetcode.oj;

import java.util.ArrayList;
import java.util.List;

public class EvaluateReversePolishNotation {
	public static boolean isOperator(String token) {
		if ("+".equals(token) || "-".equals(token) 
				|| "*".equals(token) || "/".equals(token)) 
			return true;
		return false;
	}
    public static int evalRPN(String[] tokens) {
        List<String> signs = new ArrayList<String>();
        for (int i = 0; i < tokens.length; i++) {
        	if (isOperator(tokens[i])) {
        		int len = signs.size();
        		if (len < 2) {
        			return 0;
        		}
        		Integer oprand1 = Integer.parseInt(signs.remove(len - 1));
        		Integer oprand2 = Integer.parseInt(signs.remove(len - 2));
        		Integer res = 0;
        		if ("+".equals(tokens[i])) {
        			res = oprand2 + oprand1;
        		} else if ("-".equals(tokens[i])) {
        			res = oprand2 - oprand1;
        		} else if ("*".equals(tokens[i])) {
        			res = oprand2 * oprand1;
        		} else if ("/".equals(tokens[i])) {
        			res = oprand2 / oprand1;
        		} else;
        		signs.add(res.toString());
        	} else {
        		signs.add(tokens[i]);
        	}
        }
    	return Integer.parseInt(signs.get(0));
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] examples = {"4", "13", "5", "/", "+"};
		System.out.println(evalRPN(examples));
	}

}
