/**
 * Source : http://oj.leetcode.com/problems/integer-to-roman
 * 			http://oj.leetcode.com/problems/roman-to-integer
 * Author : Hexiaoqiao
 * Date   : 2014-09-26
 *
 * 0.Problem:
 * 0.0
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 * 0.1
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * 1.Refer.:
 * 1.0 Roman字符和Int对应关系；
 * 1.1 按照Roman numeral的构造规则转换；
 * 
 */
package com.leetcode.oj;

import java.util.HashMap;
import java.util.Map;

public class Integer4Roman {
	public static String[] generate() {
		String[] metric = {"I","V","X","L","C","D","M"};
		Map<Integer, String> i2rmap = new HashMap<Integer, String>();
		int[] a = {1,5,10,50,100,500,1000};
		for (int i = 0; i < metric.length; i++) {
			if (0 == i) {
				i2rmap.put(a[0], metric[i]);				
			} else if (1 == i) {
				i2rmap.put(a[1], metric[i]);				
			} else {
				int ratio = 1;
				for (int j = 0; j < i / 2; j++) {
					 ratio = 10 * ratio;
				}
				int k = a[i % 2] * ratio;
				i2rmap.put(k, metric[i]);
			}
		}
		int index = -1;
		String[] roman = new String[4000];
		for (int i : i2rmap.keySet()) {
			roman[i] = i2rmap.get(i);
		}
		for (int i = 1; i < 4000; i++) {
			String str = i2rmap.get(i);
			if (null != str) {
				index = index + 1;
				continue;
			} else if ((i > a[a.length - 1]) || (i > a[index] && i < a[index + 1] - a[(index / 2) * 2])) {
				String s = i2rmap.get(a[index]);
				String res = s + roman[i - a[index]];
				roman[i] = res;
			} else if (i == a[index + 1] - a[(index / 2) * 2]) {
				String s = i2rmap.get(a[(index / 2) * 2]);
				String res = s + i2rmap.get(a[index + 1]);
				roman[i] = res;
			} else if (i > a[index + 1] - a[(index / 2) * 2] && i < a[index + 1]) {
				String s = roman[a[index + 1] - a[(index / 2) * 2]];
				String res = s + roman[i - (a[index + 1] - a[(index / 2) * 2])];
				roman[i] = res;
			}
		}
		return roman;
	}
	
    public static int romanToInt(String s) {
		Character[] metric = {'I','V','X','L','C','D','M'};
		int[] a = {1,5,10,50,100,500,1000};
		Map<Character, Integer> smap = new HashMap<Character, Integer>();
		for (int i = 0; i < metric.length; i++) {
			smap.put(metric[i], a[i]);
		}
		int res = 0;
		for (int i = 0; i < s.length(); i++) {
			if (i == s.length() - 1) res = res + smap.get(s.charAt(i));
			else {
				int ai = smap.get(s.charAt(i));
				int bi = smap.get(s.charAt(i + 1));
				if (ai < bi) {
					res = res + bi - ai;
					i = i + 1;
				} else {
					res = res + ai;
				}
			}
		}
    	return res;
    }
    
    public static String intToRoman(int num) { 
		String[] metric = {"I","V","X","L","C","D","M"};
		int[] a = {1,5,10,50,100,500,1000};
		int i = 0;
		if (num <= 0 || num >= 4000) return null; 
		for (i = 0; i < a.length; i++) {
			if (num == a[i]) {return metric[i];}
			else if (num < a[i]) {
				i--;
				break;
			}
		}
		if (i == a.length) i--; 
		if (i == a.length - 1 || num < a[i + 1] - a[(i / 2) * 2]) {
			String s = metric[i];
			String t = intToRoman(num - a[i]);
			String res = s + (null == t ? "" : t);
			return res;
		} else {
			String s = metric[(i / 2) * 2] + metric[i + 1];
			String t = intToRoman(num - (a[i + 1] - a[(i / 2) * 2]));
			String res = s + (null == t ? "" : t);
			return res;
		}
    }
    
    public static void print(String[] roman) {
    	for (String str : roman) {
    		System.out.println(str);
    	}
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] roman = generate();
		for (int i = 1; i < 4000; i++) {
			if (roman[i].equals(intToRoman(i))) {
				System.out.println(i + "pass");
			} else {
				System.out.println(i + "fail");
			}
		}
		System.out.println("---------------------");
		for (int i = 1; i < 4000; i++) {
			if (romanToInt(roman[i]) == i){
				System.out.println(i + "pass");
			} else {
				System.out.println(i + "fail");;
			}
		}
	}

}
