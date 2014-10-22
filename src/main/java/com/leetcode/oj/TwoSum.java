/**
 * Source : http://oj.leetcode.com/problems/two-sum
 * Author : Hexiaoqiao
 * Date   : 2014-09-26
 *
 * 0.Problem:
 * Given an array of integers, find two numbers such that they add 
 * up to a specific target number.
 * The function twoSum should return indices of the two numbers such 
 * that they add up to the target, where index1 must be less than 
 * index2. Please note that your returned answers (both index1 and 
 * index2) are not zero-based.
 * You may assume that each input would have exactly one solution.
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 * 
 * 1.Refer.:
 * HashMap：所有被选数据放入HashMap里后逐个遍历
 */
package com.leetcode.oj;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSum(int[] numbers, int target) { 
    	int[] rets = new int[2];
    	Map<Integer,Integer> rawhash = new HashMap<Integer, Integer>();
    	if (numbers.length < 2) {
    		return null;
    	}
    	if (numbers.length == 2 && target != numbers[0] + numbers[1]) {
    		return null;
    	}
    	for (int i = 0; i < numbers.length; i++) {
    		if (null != rawhash.get(numbers[i])) {
    			if (target == 2 * numbers[i]) {
    				rets[0] = rawhash.get(numbers[i]) + 1;
    				rets[1] = i + 1;
    				return rets;
    			} else {
    				continue;
    			}
    		}
    		rawhash.put(numbers[i], i);
    	}
    	for (int i = 0; i < numbers.length; i++) {
    		Integer val = rawhash.get(target-numbers[i]);
    		if (null != val) {
    			if (val.intValue() < i) {
	    			rets[0] = val.intValue() + 1;
	    			rets[1] = i + 1;
    			} else if (val.intValue() > i){
    				rets[0] = i + 1;
	    			rets[1] = val.intValue() + 1;
    			} else {
    				continue;
    			}
    			return rets;
    		}
    	}
		return null;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] numbers = {3,2,4};
		int target = 6;
		int[] rets = TwoSum.twoSum(numbers, target);
		for (int i = 0; i < rets.length; i++) {
			System.out.println(rets[i]);
		}
	}

}
