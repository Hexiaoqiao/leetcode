/**
 * Source : http://oj.leetcode.com/problems/valid-palindrome
 * Author : Hexiaoqiao
 * Date   : 2014-09-26
 *
 * 0.Problem:
 * Given a string, determine if it is a palindrome, considering only 
 * alphanumeric characters and ignoring cases.
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * Note:
 * Have you consider that the string might be empty? This is a good 
 * question to ask during an interview.
 * For the purpose of this problem, we define empty string as valid 
 * palindrome.
 * 
 * 1.Refer.:
 * 1.0 去除无用字符：空格/标点/.. & 大小写统一
 * 1.1 从两边向中间逐个比较
 */
package com.leetcode.oj;

public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
    	StringBuffer str = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	if (c >= 'a' && c <= 'z') {
        		str.append(c);
        	} else if (c >= '0' && c <= '9') {
        		str.append(c);
        	} else if (c >= 'A' && c <= 'Z') {
        		str.append((char) (c - 'A' + 'a'));
        	}
        }
        int len = str.length();
        if (2 > len) return true;
        for (int j = len / 2; j >= 0; j--) {
        	if (str.charAt(j) != str.charAt(len - j - 1)) {
        		return false;
        	}
        }
        return true;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPalindrome("0k.;r0.k;"));
	}

}
