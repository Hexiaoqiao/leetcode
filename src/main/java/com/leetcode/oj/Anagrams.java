package com.leetcode.oj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Anagrams {
    public static List<String> anagrams(String[] strs) {
        List<String> res = new ArrayList<String>();
        Map<String, Integer> anamap = new HashMap<String, Integer>();
        for (int i = 0; i < strs.length; i++) {
        	char[] c = strs[i].toCharArray();
        	Arrays.sort(c);
        	String str = String.valueOf(c);
        	Integer v = anamap.get(str);
        	if (null != v) {
        		res.add(strs[i]);
        		if (-1 != v) res.add(strs[v]);
        		anamap.put(str, -1);
        	} else {
        		anamap.put(str, i);
        	}
        }
    	return res;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = {"tea","and","ate","eat","den"};
		List<String> res = anagrams(strs);
		for (String str : res) {
			System.out.println(str);
		}
	}

}
