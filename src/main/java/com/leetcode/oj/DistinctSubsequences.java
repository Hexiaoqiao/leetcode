/**
 * Source : http://oj.leetcode.com/problems/distinct-subsequences
 * Author : Hexiaoqiao
 * Date   : 2014-09-26
 *
 * 0.Problem:
 * Given a string S and a string T, count the number of 
 * distinct subsequences of T in S.
 * 
 * A subsequence of a string is a new string which is formed 
 * from the original string by deleting some (can be none) of 
 * the characters without disturbing the relative positions of 
 * the remaining characters. (ie, "ACE" is a subsequence of 
 * "ABCDE" while "AEC" is not).
 * 
 * Here is an example:
 * S = "rabbbit", T = "rabbit"
 * Return 3.
 * 
 * 1.Refer.:DP
 * 定义num[i][j]为S[0..i]与T[0..j]之间满足DistinctSubseqquences的个数，
 * 则：
 * 			/ num[i - 1][j] (S[i] != T[j])
 * num[i][j] = |
 * 			\ num[i - 1][j - 1] + num[i - 1][j] (S[i] == T[j])
 */
package com.leetcode.oj;

public class DistinctSubsequences {
    public static int numDistinct(String S, String T) {
    	int slen = S.length();
    	int tlen = T.length();
    	if (slen < tlen) return 0;
        int[][] num = new int[slen][tlen];
        for (int i = 0; i < slen; i++) {
        	for (int j = 0; j < tlen; j++) {
        		if (i < j) num[i][j] = 0; 
        		else if (j == 0) {
        			if (i == 0) {if (S.charAt(0) == T.charAt(0)) num[i][j] = 1;else num[i][j] = 0;}
        			else if (S.charAt(i) == T.charAt(j)) num[i][j] = num[i - 1][j] + 1;
        			else num[i][j] = num[i - 1][j];
    			} else if (S.charAt(i) == T.charAt(j)) {
       				num[i][j] = num[i][j] + num[i - 1][j - 1];
       				num[i][j] = num[i][j] + num[i - 1][j];
        		} else {
        			num[i][j] = num[i][j] + num[i - 1][j];
        		}
        	}
        }
    	return num[slen - 1][tlen - 1];
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S = "", T = "a";
		System.out.println(numDistinct(S, T));
	}

}
