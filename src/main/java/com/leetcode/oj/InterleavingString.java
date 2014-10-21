/**
 * Source : 
 * Author : Hexiaoqiao
 * Date   : 2014-09-26
 *
 * 0.Problem:
 * Given s1, s2, s3, find whether s3 is formed by the 
 * interleaving of s1 and s2.
 * For example,
 * Given:
 * s1 = "aabcc",
 * s2 = "dbbca",
 * When s3 = "aadbbcbcac", return true.
 * When s3 = "aadbbbaccc", return false.
 * 
 * 1.Refer.:
 * The idea is a straightforward Dynamic Programming, 
 * based on the observation that s3 is an interleaving 
 * string of s1 and s2 iff s3[0] == s1[0] 
 * or s3[0] == s2[0], we can draw a recursion tree for 
 * this, then the algorithm is:
 * 
 * Keep i1, i2, i3 as the current index for s1, s2 and s3, 
 * all starting from 0. Remove 1 char from s3 at a time, 
 * and remove the same char from s2 or s3, if s1[i1] and 
 * s2[i2] are the same as s3[i3], we need to consider 2 
 * possibilities which are
 * 
 * 1. s3[i3+1] is a interleaving string of s1[i1:] and s2[i2+1:] or
 * 2. s3[i3+1] is a interleaving string of s1[i1+1:] and s2[i2:]
 * 
 * The algorithm can be described as:
 * 1. i1, i2, i3 start from 0
 * 2. if remaining s3 is equal to either remaining s1 or s2, 
 * we have a match
 * 3. else, if the first char of s3 not equal to any of the 
 * first char or s1 or s2, this is a no match
 * 4. else, if the first char of s3 equal to both of the first 
 * char of s1 and s2, we have the abovementioned 2 possibilities
 * 5. else, if the first char of s3 equal to the first char of 
 * s1, then we move i3 and i1 to the right by 1
 * 6. else, if the first char of s3 equal to the first char of 
 * s2, we move i3 and i2 to the right by 1
 * 
 * Just like typical DP problem, there will be a handful of overlapping 
 * subproblems, so we keep a dp_table to store the intermediate results.
 *  */

package com.leetcode.oj;

public class InterleavingString {
    public static boolean isInterleave1(String s1, String s2, String s3) {
    	if (s3.length() != s1.length() + s2.length()) return false;
    	if (0 == s1.length() && 0 == s2.length() && 0 == s3.length()) return true;
    	if (null == s1 || 0 == s1.length()) return s2.equals(s3);
    	if (null == s2 || 0 == s2.length()) return s1.equals(s3);
    	if (s1.charAt(0) == s2.charAt(0) && s1.charAt(0) == s3.charAt(0)) {
    		if (isInterleave1(s1, s2.substring(1), s3.substring(1))) {
    			return true;
    		} else if (isInterleave1(s1.substring(1), s2, s3.substring(1))) {
    			return true;
    		}
    		return false;
    	} else if (s1.charAt(0) == s3.charAt(0)) {
    		return isInterleave1(s1.substring(1), s2, s3.substring(1));
    	} else if (s2.charAt(0) == s3.charAt(0)) {
    		return isInterleave1(s1, s2.substring(1), s3.substring(1));
    	}
    	return false;
    }
    
    public static boolean isInterleave(String s1, String s2, String s3) {
    	if (null == s1 && null == s2) return null == s3;
    	if (null == s1) return s2.equals(s3);
    	if (null == s2) return s1.equals(s3);
    	if (0 == s1.length()) return s2.equals(s3);
    	if (0 == s2.length()) return s1.equals(s3);
    	if (null == s3) return false;
    	int alen = s1.length();
    	int blen = s2.length();
    	int clen = s3.length();
    	if (clen != alen + blen) return false;
    	if (0 == alen && 0 == blen && 0 == clen) return true; 
    	boolean[][] table = new boolean[alen + 1][blen + 1];
    	table[alen][blen] = true;
    	for (int i = alen; i >= 0; i--) {
    		for (int j = blen; j >= 0; j--) {
    			if (i == alen && j == blen) continue;
    			if (alen == i) {
    				if (table[i][j + 1] && s2.charAt(j) == s3.charAt(i + j)) {
    					table[i][j] = true; continue;
    				}
    			} else if (blen == j) {
    				if (table[i + 1][j] && s1.charAt(i) == s3.charAt(i + j)) {
    					table[i][j] = true; continue;
    				}
    			} else if (table[i][j + 1] && s2.charAt(j) == s3.charAt(i + j)) {
    				table[i][j] = true;continue;
    			} else if (table[i + 1][j] && s1.charAt(i) == s3.charAt(i + j)) {
    				table[i][j] = true;continue;
    			}
    		}
    	}
    	return table[0][0];
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbbaccc";
		System.out.println(isInterleave(s1, s2, s3));
	}

}
