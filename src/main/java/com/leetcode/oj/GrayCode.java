/**
 * Source : http://oj.leetcode.com/problems/gray-code
 * Author : Hexiaoqiao
 * Date   : 2014-09-26
 *
 * 0.Problem:
 * The gray code is a binary numeral system where two successive 
 * values differ in only one bit.
 * Given a non-negative integer n representing the total number 
 * of bits in the code, print the sequence of gray code. A gray 
 * code sequence must begin with 0.
 * For example, given n = 2, return [0,1,3,2]. Its gray code 
 * sequence is:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * Note:
 * For a given n, a gray code sequence is not uniquely defined.
 * For example, [0,2,3,1] is also a valid gray code sequence 
 * according to the above definition.
 * For now, the judge is able to judge based on one instance of 
 * gray code sequence. Sorry about that.
 * 
 * 1.Refer.:DP
 * 0 1 3 2 6 7 5 4
 * | | |_| |_____|
 * 0 1  2     4
 * 1.倒序
 * 2.add(2^n)
 */
package com.leetcode.oj;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    public static List<Integer> grayCode(int n) {
    	List<Integer> res = new ArrayList<Integer>();
    	res.add(0);
    	for (int i = 0; i < n; i++) {
    		int inc = 1 << i;
    		for (int j = res.size() - 1; j >= 0; j--) {
    			res.add(res.get(j) + inc);
    		}
    	}
        return res;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> res = grayCode(3);
		for (Integer i : res) {
			System.out.print(i + " ");
		}
	}

}
