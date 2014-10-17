/*
0.Problem:
Given an input string, reverse the string word by word.
For example,
Given s = "the sky is blue",
return "blue is sky the".

Clarification:
What constitutes a word?
A sequence of non-space characters constitutes a word.
Could the input string contain leading or trailing spaces?
Yes. However, your reversed string should not contain leading 
or trailing spaces.
How about multiple spaces between two words?
Reduce them to a single space in the reversed string.

1.Refer.:
1.0 分词
1.1 倒序组合
*/
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
					end = end + 1;
					begin = end;
				} else {
					end = i + 1;
					begin = end;
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
