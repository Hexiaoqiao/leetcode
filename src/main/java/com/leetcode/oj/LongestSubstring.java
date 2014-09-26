package com.leetcode.oj;

public class LongestSubstring {
	public static int max(int a, int b) {
		return a > b ? a : b;
	}
/*	public static int lengthOfLongest(String s, int len) {
		char[] bitset = new char[32];
		int length = 0;
		if (1 == len) return 1; 
		for (int i = len - 1; i >= 0; i--) {
			char c = s.charAt(i);
    		int a = c >> 3;
    		int b = c & 0x7;
    		int bit = 1 << b;
    		if ((bitset[a] & bit) != 0) {
    			length = len - i - 1;
    			break;
    		} else {
    			bitset[a] = (char) (bitset[a] | bit);
    		}
		}
		return max(lengthOfLongest(s, len-1), length);
	}
    public static int lengthOfLongestSubstring(String s) {
    	if (null == s ) return 0;
    	if (s.length() < 2) return s.length();
    	return lengthOfLongest(s, s.length());
    }*/
	
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
