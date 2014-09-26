package com.leetcode.oj;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public static boolean wordBreak(String s, Set<String> dict) {
    	int len = s.length();
    	boolean[] iswordbreak = new boolean[len + 1];
    	iswordbreak[len] = true;
    	for (int i = len - 1; i >= 0; i--) {
    		for (int j = i; j < len; j++) {
    			String word = s.substring(i, j + 1);
    			if (iswordbreak[j + 1] && dict.contains(word)) {
    				iswordbreak[i] = true;
    				break;
    			}
    		}
    	}
        return iswordbreak[0];
    }
    
    public static List<String> wordBreak2(String s, Set<String> dict) {
    	int len = s.length();
    	List<List<String>> res = new ArrayList<List<String>>();
    	boolean[] iswordbreak = new boolean[len + 1];
    	iswordbreak[len] = true;
    	for (int i = 0; i < s.length() + 1; i++) {
    		res.add(new ArrayList<String>());
    	}
    	for (int i = len - 1; i >= 0; i--) {
    		for (int j = i; j < len; j++) {
    			String word = s.substring(i, j + 1);
    			if (iswordbreak[j + 1] && dict.contains(word)) {
    				iswordbreak[i] = true;
    				if (0 == res.get(j + 1).size()) res.get(i).add(word);
    				else {
    					for (String str : res.get(j + 1)) {
    						res.get(i).add(word + " " + str);
    					}
    				}
    			}
    		}
    	}
        return res.get(0);
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "helloworld";
		String[] dics = {"hello","world","wo","l", "d","r","he","o"};
		Set<String> dict = new HashSet<String>();
		for (String s : dics) {
			dict.add(s);
		}
		System.out.println(wordBreak(str, dict));
		List<String> res = wordBreak2(str, dict);
		for (String s : res) {
			System.out.println(s);
		}
	}

}
