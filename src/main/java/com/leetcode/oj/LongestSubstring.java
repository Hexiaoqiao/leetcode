/*
0.Problem:
Given a string, find the length of the longest substring without 
repeating characters. For example, the longest substring without 
repeating letters for "abcabcbb" is "abc", which the length is 3. 
For "bbbbb" the longest substring is "b", with the length of 1.

1.Refer.: DP
first[i] = next[i]; first[i+1] > next[i]
		 = first[i+1]; first[i+1] <= next[i]
其中next[i]表示s.charat(i)字符下一个位置，通过hashmap记录；
计算first[i]-i，其中i去[1..n]取最大值
*/
package com.leetcode.oj;

public class LongestSubstring {
	public static int max(int a, int b) {
		return a > b ? a : b;
	}
	
	public static int lengthOfLongestSubstring(String s) {
		int max = 0;
		int len = s.length();
		int[] hash = new int[256];
		int[] first = new int[len+1];
		int[] next = new int[len];
		first[len] = len;
		for (int i = len - 1; i >= 0; i--) {
			int index = hash[s.charAt(i)];
			next[i] = index == 0 ? len : index;
			hash[s.charAt(i)] = i;
			if (first[i + 1] > next[i]) {
				first[i] = next[i];
			} else {
				first[i] = first[i + 1];
			}
		}
		for (int i = 0; i < len; i++) {
			if (first[i] - i > max) max = first[i] - i;
		}
		return max;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "aaa";
		System.out.println(lengthOfLongestSubstring(s));
	}

}
