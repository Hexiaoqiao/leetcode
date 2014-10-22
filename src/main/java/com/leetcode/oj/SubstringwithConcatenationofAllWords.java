/**
 * Source : http://oj.leetcode.com/problems/substring-with-concatenation-of-all-words
 * Author : Hexiaoqiao
 * Date   : 2014-09-26
 *
 * 0.Problem:
 * You are given a string, S, and a list of words, L, that are all of 
 * the same length. Find all starting indices of substring(s) in S that 
 * is a concatenation of each word in L exactly once and without any 
 * intervening characters.
 * For example, given:
 * S: "barfoothefoobarman"
 * L: ["foo", "bar"]
 * You should return the indices: [0,9].
 * (order does not matter).
 * 
 * 1.Refer.:
 * 1.0 将字符串数组中的字符串与其个数放入HashMap中；
 * 1.1 顺序遍历字符串当当HashMap中所有key值均为0时记录当前值，继续遍历
 */
package com.leetcode.oj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringwithConcatenationofAllWords {
    public static List<Integer> findSubstring(String S, String[] L) {
    	List<Integer> ret = new ArrayList<Integer>();
    	int slen = S.length();
    	int num = L.length;
    	int size = 0;
    	if (0 != num) size = L[0].length();
    	if (slen < num * size) return ret;
    	Map<String, Integer> strmap = new HashMap<String, Integer>();
    	for (int i = 0; i < num; i++) {
    		Integer it = strmap.get(L[i]);
    		if (null == it) strmap.put(L[i], 1);
    		else strmap.put(L[i], it + 1);    		
    	}
    	for (int i = 0; i <= slen - num * size; i++) {
    		Map<String, Integer> strtmap = new HashMap<String, Integer>(strmap);
    		int j = 0;
    		for (j = 0; j < num; j++) {
    			int split = i + j * size;
    			String stmp = S.substring(split, split + size);
    			Integer t = strtmap.get(stmp);
    			if (null == t || 0 == t) break;
    			strtmap.put(stmp, t - 1);
    		}
    		if (j != num) continue;
    		else {
    			boolean isvalid = true;
    			for (String str : strtmap.keySet()) {
    				Integer ti = strtmap.get(str);
    				if (0 != ti) {isvalid = false; break;}
    			}
    			if (isvalid) ret.add(i); 
    		}
    	}
        return ret;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S0 = "abababab";
		String S1 = "aaaabaaba";
		String[] L = {"a","b","a"};
		List<Integer> ret1 = findSubstring(S0, L);
		List<Integer> ret2 = findSubstring(S1, L);
		for (Integer i : ret1) {
			System.out.println(i);
		}
		for (Integer i : ret2) {
			System.out.println(i);
		}
	}
}
