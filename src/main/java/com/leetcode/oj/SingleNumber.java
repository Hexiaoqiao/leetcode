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
