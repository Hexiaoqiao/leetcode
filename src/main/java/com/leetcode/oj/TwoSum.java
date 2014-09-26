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
