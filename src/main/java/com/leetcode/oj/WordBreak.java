/**
 * Source : 
 * Author : Hexiaoqiao
 * Date   : 2014-09-26
 *
 * 0.Problem:
 * 0.0
 * Given a string s and a dictionary of words dict, determine if 
 * s can be segmented into a space-separated sequence of one or 
 * more dictionary words.
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 * Return true because "leetcode" can be segmented as "leet code".
 * 
 * 0.1
 * Given a string s and a dictionary of words dict, add spaces in 
 * s to construct a sentence where each word is a valid dictionary 
 * word.
 * Return all such possible sentences.
 * For example, given
 * s = "catsanddog",
 * dict = ["cat", "cats", "and", "sand", "dog"].
 * A solution is ["cats and dog", "cat sand dog"].
 * 
 * 1.Refer.:
 * 1.0 DP
 * res[i] = res[j + 1] && dict.contains(s.substring(i,j))
 * 
 * 1.1 DP
 * 同1.0同时每次都保存结果集合
 */
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
