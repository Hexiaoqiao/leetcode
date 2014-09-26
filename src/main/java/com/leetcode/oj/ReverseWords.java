package com.leetcode.oj;

import java.util.ArrayList;
import java.util.List;

public class ReverseWords {
	public static String reverseWords(String s) {
		List<String> words = new ArrayList<String>();
		int len = s.length();
		StringBuffer res = new StringBuffer();
		String word = null;
		int begin = 0, end = 0;
		for (int i = 0; i < len; i++) {
			if (' ' == s.charAt(i)) {
				if (end != begin) {
					word = s.substring(begin, end);
					words.add(word);
					begin = end = end + 1;
				} else {
					begin = end = i + 1;
				}
			} else {
				end = i + 1;
			}
		}
		if (begin != end) {
			words.add(s.substring(begin, end));
		}
		for (int i = words.size() - 1; i >= 0; i--) {
			res.append(words.get(i));
			if (i != 0) res.append(" ");
		}
		return res.toString();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = " Idafd@# dfa adf  ";
		System.out.println(reverseWords(s));
	}

}
