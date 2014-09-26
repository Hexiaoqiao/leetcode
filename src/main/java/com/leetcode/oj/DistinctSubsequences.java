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
    			}
        		else if (S.charAt(i) == T.charAt(j)) {
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
