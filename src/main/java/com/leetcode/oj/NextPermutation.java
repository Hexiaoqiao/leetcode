package com.leetcode.oj;

public class NextPermutation {
    public static void nextPermutation(int[] num) {
    	int index = -1;
    	int swap = -1;
    	for (int i = num.length - 1; i > 0; i--) {
        	if (num[i - 1] < num[i]) { index = i - 1; break;}
        }
    	if (-1 != index) {
    		for (int i = num.length - 1; i >= 0; i--) {
    			if (num[i] > num[index]) {swap = i; break;} 
    		}
    		int temp = num[swap];
    		num[swap] = num[index];
    		num[index] = temp;
    	}
    	for (int i = index + 1; i <= (index + 1 + num.length - 1) / 2; i++) {
    		int temp = num[i];
    		num[i] = num[num.length - (i - index)];
    		num[num.length - (i - index)] = temp;
    	}
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] num = {1,4,3,2};
		nextPermutation(num);
		for (int i : num) {
			System.out.print(i + " ");
		}
	}

}
