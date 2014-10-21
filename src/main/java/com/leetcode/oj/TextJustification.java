/**
 * Source : 
 * Author : Hexiaoqiao
 * Date   : 2014-09-26
 *
 * 0.Problem:
 * Given an array of words and a length L, format the text such that each 
 * line has exactly L characters and is fully (left and right) justified.
 * You should pack your words in a greedy approach; that is, pack as many 
 * words as you can in each line. Pad extra spaces ' ' when necessary so 
 * that each line has exactly L characters.
 * Extra spaces between words should be distributed as evenly as possible. 
 * If the number of spaces on a line do not divide evenly between words, 
 * the empty slots on the left will be assigned more spaces than the slots 
 * on the right.
 * For the last line of text, it should be left justified and no extra 
 * space is inserted between words.
 * For example,
 * words: ["This", "is", "an", "example", "of", "text", "justification."]
 * L: 16.
 * Return the formatted lines as:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * Note: Each word is guaranteed not to exceed L in length.
 * 
 * 1.Refer.:
 * 顺序遍历
 */
package com.leetcode.oj;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public static List<String> fullJustify(String[] words, int L) {
        List<String> res = new ArrayList<String>();
        if (null == words || 0 == words.length) return res;
        StringBuffer sb = new StringBuffer();
        int p = 0;
        int q = 0;
        int len = 0;
        while (p < words.length || q != p) {
        	if (p < words.length && len + words[p].length() <= L) {
        		len = len + words[p].length();
        		len = len + 1;
        		p = p + 1;
        	} else {
        		int gap = p - q - 1;
        		int delta = L - len + 1 + gap;
        		if (p != words.length) {
        			for (int i = q; i < p; i++) {
            			sb.append(words[i]);
            			int ns = 0;
            			if (0 != gap) ns = delta / gap + (delta % gap > 0 ? 1 : 0);
            			else if (p != words.length) ns = delta;
            			delta = delta - ns;
            			gap = gap - 1;
            			for (int j = 0; j < ns; j++) {
            				sb.append(' ');
            			}
            		}
        		} else {
        			for (int i = q; i < p; i++) {
        				sb.append(words[i]);
        				if (i != p - 1) sb.append(" ");
        			}
        			for (int i = sb.length(); i < L; i++) {
        				sb.append(" ");
        			}
        		}
        		
        		res.add(sb.toString());
        		sb.setLength(0);
        		q = p;
        		len = 0;
        	}
        }
    	return res;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = {""};
		int L = 2;
		List<String> res = fullJustify(strs, L);
		for (String str : res) {
			System.out.println(str);
		}
	}

}
