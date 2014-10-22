/**
 * Source : http://oj.leetcode.com/problems/longest-consecutive-sequence
 * Author : Hexiaoqiao
 * Date   : 2014-09-26
 *
 * 0.Problem:
 * Given an unsorted array of integers, find the length of the 
 * longest consecutive elements sequence.
 * For example,
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. 
 * Return its length: 4.
 * Your algorithm should run in O(n) complexity.
 * 
 * 1.Refer.:HashMap <key,value> 其中key是数组中的值，value
 * 1.0 依次遍历数组，将kv对<n,n>压入HashMap，同时query HashMap中的n-1
 * 和n+1的value分别作为min和max，然后将<min,max>和<max,min>对压入HashMap
 */
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
