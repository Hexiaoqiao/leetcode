/**
 * Source : 
 * Author : Hexiaoqiao
 * Date   : 2014-09-26
 *
 * 0.Problem:
 * Given an array of strings, return all groups of strings that are anagrams.
 * 
 * Note: All inputs will be in lower-case.
 * 1.Refer.:
 * 1.0逐个字符串遍历；
 * 1.1将字符串按照字典序重排；
 * 1.2从HashMap中查，若存在即是结果的一个元素，否则存入HashMap；
 */
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
