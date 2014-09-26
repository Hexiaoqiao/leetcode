package com.leetcode.oj;

public class Candy {
    public static int candy(int[] ratings) {
    	int len = ratings.length;
        int n = 0;
        int[] c = new int[len];
        c[0] = 1;
        for (int i = 1; i < len; i++) {
        	c[i] = ratings[i] > ratings[i - 1] ? c[i - 1] + 1 : 1;
        }
        for (int i = len - 2; i >= 0; i--) {
        	c[i] = (ratings[i] > ratings[i + 1] && c[i + 1] + 1 > c[i]) ? c[i + 1] + 1 : c[i];
        }
        for (int i = 0; i < len; i++) {
        	n = n + c[i];
        }
    	return n;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ratings = {1,9,2,8,3,7,4,6,5,5,4,3,2,1};
		System.out.println(candy(ratings));
	}

}
