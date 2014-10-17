/*
0.Problem:
Given two words word1 and word2, find the minimum number of 
steps required to convert word1 to word2. (each operation is 
counted as 1 step.)

You have the following 3 operations permitted on a word:
a) Insert a character
b) Delete a character
c) Replace a character

1.Refer.:DP
定义len[i][j]为word1[0..i]与word2[0..j]之间满足minDistance的值
则
		   	/ i (j = 0)
			| j (i = 0)
len[i][j] = |
			| len[i - 1][j - 1] (word1[i] = word2[j])
			\ min(len[i - 1][j], len[i - 1][j - 1], len[i][j - 1]) + 1; (word1[i] != word2[j])

*/
package com.leetcode.oj;

public class EditDistance {
    public static int minDistance(String word1, String word2) {
        if (null == word1 && null == word2) return 0;
        if (null == word1 || 0 == word1.length()) return word2.length();
        if (null == word2 || 0 == word2.length()) return word1.length();
    	int m = word1.length();
        int n = word2.length();
        int[][] len = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {len[i][0] = i;}
        for (int j = 0; j <= n; j++) {len[0][j] = j;}
        for (int i = 1; i <= m; i++) {
        	for (int j = 1; j <= n; j++) {
        		if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
        			len[i][j] = len[i - 1][j - 1];
        		} else {
        			int a = len[i - 1][j];
        			int b = len[i - 1][j - 1];
        			int c = len[i][j - 1];
        			int res = a;
        			if (res > b) res = b;
        			if (res > c) res = c;
        			len[i][j] = res + 1;
        		}
        	}
        }
    	return len[m][n];
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(minDistance("distance","springbok"));
	}

}
