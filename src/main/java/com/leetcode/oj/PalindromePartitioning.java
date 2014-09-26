package com.leetcode.oj;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static List<List<String>> partition(String s) {
    	List<List<String>> r = new ArrayList<List<String>>();
    	r = partition(s, r);
    	return r;
    }
    
    public static boolean isPalindrome(String s) {
    	int len = s.length();
    	for (int i = len / 2 - 1; i >= 0; i--) {
    		if (s.charAt(i) != s.charAt(len - i - 1)) return false;
    	}
    	return true;
    }
    public static List<List<String>> partition(String s, List<List<String>> res) {
    	List<String> r = new ArrayList<String>();
    	if (null == s || "".equals(s)) return res;
    	if (s.length() == 1) {
    		r.add(s);
    		res.add(r);
    		return res;
    	} else if (s.length() == 2) {
    		String s1 = s.substring(0, 1);
    		String s2 = s.substring(1, 2);
    		r.add(s1);
    		r.add(s2);
    		res.add(r);
    		if (s1.equals(s2)) {
    			List<String> rr = new ArrayList<String>();
        		rr.add(s);
        		res.add(rr);
    		}
    		return res;
    	}
    	List<List<String>> rs = new ArrayList<List<String>>();
    	for (int i = 0; i < s.length(); i++) {
    		String st = s.substring(0, i + 1);
    		if (isPalindrome(st)) {
    			List<List<String>> tmp = new ArrayList<List<String>>();
        		tmp = partition(s.substring(i + 1, s.length()), tmp);
        		if (0 != tmp.size()) {
        			for (List<String> l : tmp) {
        				l.add(0, st);
        			}
        		} else {
        			List<String> l = new ArrayList<String>();
        			l.add(st);
        			tmp.add(l);
        		}
        		rs.addAll(tmp);
    		}
    	}
    	res.addAll(rs);
    	return res;
    }
    
    public static int minCut(String s) {
    	if (null == s || 0 == s.length()) return 0;
    	int len = s.length();
    	int[] result = new int[len];
    	boolean[][] palindrome =new boolean[len][len];
    	for (int start = len - 1; start >= 0; start--) {
    		result[start] = len - start - 1;
    		for (int end = start; end < len; end++) {
				if (s.charAt(start) == s.charAt(end)) {
					if (end - start < 2) palindrome[start][end] = true;
					else palindrome[start][end] = palindrome[start+1][end-1];
				}
				if (palindrome[start][end]) {
					if (len - 1 == end) {result[start] = 0;}
					else {
						result[start] = result[start] < result[end + 1] + 1 ? result[start] : result[end + 1] + 1;
					}
				}
			}
    	}
    	return result[0];
    }
    
    public static void print(List<List<String>>res) {
    	for (List<String> l : res) {
    		System.out.print("(");
    		for (String s : l) {
    			System.out.print(s + ",");
    		}
    		System.out.println(")");
    	}
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "aabcdbd";
		/*List<List<String>> r = partition(test);
		print(r);*/
		System.out.println(minCut(test));
	}

}
