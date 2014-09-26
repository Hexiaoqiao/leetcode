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
