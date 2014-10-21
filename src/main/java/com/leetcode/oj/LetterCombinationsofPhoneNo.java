/**
 * Source : 
 * Author : Hexiaoqiao
 * Date   : 2014-09-26
 *
 * 0.Problem:
 * Given a digit string, return all possible letter combinations 
 * that the number could represent.
 * A mapping of digit to letters (just like on the telephone 
 * buttons) is given below.
 * 
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 * Although the above answer is in lexicographical order, your answer 
 * could be in any order you want.
 * 
 * 1.Refer.:
 * 1.0 生成数字和字符对应关系表；
 * 1.1 根据输入数据query到对应的字符串列表；
 * 1.2 树遍历；保存结果
 */
package com.leetcode.oj;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsofPhoneNo {
    public static List<String> letterCombinations(String digits) {
    	if (null == digits) return null;
    	if ("".equals(digits)) {
    		List<String> res = new ArrayList<String>();
    		res.add("");
    		return res;
    	} 
        List<Integer> d = new ArrayList<Integer>();
        for (int i = 0; i < digits.length(); i++) {
        	d.add(digits.charAt(i) - '0');
        }
        List<String> s = new ArrayList<String>();
        String alpha = "abcdefghijklmnopqrstuvwxyz";
        String t = "";
        for (Integer i : d) {
        	if (0 == i) t = " ";
        	else if (1 ==i) t = "$";
        	else if (7 == i) t = alpha.substring((i - 2)* 3, (i - 2) * 3 + 4);
        	else if (9 == i) t = alpha.substring((i - 2) * 3 + 1);
        	else if (7 > i) t = alpha.substring((i - 2) * 3,(i - 1) * 3);
        	else t = alpha.substring((i - 2) * 3 + 1, (i - 2) * 3 + 4);
        	s.add(t);
        }
        List<String> res = new ArrayList<String>();
        List<Integer> index = new ArrayList<Integer>();
        index.add(0);
        while (0 != index.size()) {
        	while (index.size() < d.size()) {
        		index.add(0);
        	}
        	if (index.size() == d.size()) {
        		String str = "";
        		for (int i = 0; i < index.size(); i++) {
        			str = str + s.get(i).charAt(index.get(i));
        		}
        		res.add(str);
        	}
        	int i = 0;
        	while (true) {
        		int size = index.size();
        		if (0 == size) break;
        		i = index.remove(size - 1);
        		if (i < s.get(size - 1).length() - 1) {index.add(i + 1); break;}
        	}
        }
    	return res;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> res = letterCombinations("");
		for (String str : res) {
			System.out.println(str);
		}
	}

}
