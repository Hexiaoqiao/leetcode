package com.leetcode.oj;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {
    public static String getPermutation(int n, int k) {
        int[] factorial = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
        	if (1 < i) factorial[i] = factorial[i - 1] * i;
        	else factorial[i] = 1;
        }
        List<Integer> alpha = new ArrayList<Integer>();
        for (int i = 1; i < n + 1; i++) {
        	alpha.add(i);
        }
        if (k < 0 || k > factorial[n]) return ""; 
        int num = n;
        int kk = k;
        StringBuffer sb = new StringBuffer();
        while (0 < num) {
        	if (1 == alpha.size()) {sb.append(alpha.remove(0));break;} 
        	int next = factorial[num - 1];
        	int a = kk / next;
        	int b = kk % next;
        	int app = 0;
        	if (0 == b) {
        		app = alpha.remove(a - 1);
        		kk = kk - (a - 1) * next;
        	} else {
        		app = alpha.remove(a);
        		kk = kk - a * next;
        	}
        	num = num - 1;
        	sb.append(app);
        }
    	return sb.toString();
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getPermutation(4, 24));
	}

}
