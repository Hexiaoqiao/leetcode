/*
0.Problem:
0.0
Given an array of integers, every element appears twice 
except for one. Find that single one.
Note:
Your algorithm should have a linear runtime complexity. 
Could you implement it without using extra memory?
0.1
Given an array of integers, every element appears three 
times except for one. Find that single one.
Note:
Your algorithm should have a linear runtime complexity. 
Could you implement it without using extra memory?

1.Refer.:
1.0
抑或所有数据

1.1
逐位计算结果，所有数据固定位求和模3
*/
package com.leetcode.oj;

public class SingleNumber {
    public static int singleNumber(int[] A) {
    	int res = 0;
    	for (int i = 0; i < A.length; i++) {
    		res = res ^ A[i];
    	}
        return res;
    }
    
    public static int singleNumber2(int[] A) {
    	int res = 0;
    	int count = 0;
    	for (int i = 0; i < 32; i++) {
    		count = 0;
    		for (int j = 0; j < A.length; j++) {
    			if (1 == ((A[j] >> i) & 1)) count = count + 1;
    		}
    		res = res | ((count % 3) << i);
    	}
    	return res;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {-19,-19,-19, -46};
		//System.out.println(singleNumber(A));
		System.out.println(singleNumber2(A));
	}

}
