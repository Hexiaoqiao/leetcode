package com.leetcode.oj;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] num) {
    	int res = 0;
        Map<Integer, Integer> nMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < num.length; i++) {
        	int n = num[i];
        	int min = n;
        	int max = n;
        	if (nMap.containsKey(n)) continue;
        	if (nMap.containsKey(n - 1)) {
        		min = nMap.get(n - 1);
        	}
        	if (nMap.containsKey(n + 1)) {
        		max = nMap.get(n + 1);
        	}
        	res = max - min + 1 > res ? max - min + 1 : res;
        	nMap.put(n, n);
        	nMap.put(min, max);
        	nMap.put(max, min);
        }
    	return res;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {-2,-3,-3,7,-3,0,5,0,-8,-4,-1,2};
		System.out.println(longestConsecutive(num));
	}

}
