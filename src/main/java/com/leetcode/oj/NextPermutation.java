/**
 * Source : 
 * Author : Hexiaoqiao
 * Date   : 2014-09-26
 *
 * 0.Problem:
 * Implement next permutation, which rearranges numbers into the 
 * lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as 
 * the lowest possible order (ie, sorted in ascending order).
 * The replacement must be in-place, do not allocate extra memory.
 * Here are some examples. Inputs are in the left-hand column and 
 * its corresponding outputs are in the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 * 
 * 1.Refer.:
 * 1.0 尾部开始，从右向左遍历，到第一个满足num[i] < num[i+1]，记录i；
 * 1.1 重新从尾部开始，找到第一个满足num[j]>num[i]，记录j;
 * 1.2 交换i,j;
 * 1.3 将位置i之后的数据倒排；
 * e.g.:
 *   			5 2 1 2 5 4 3
 * 1.0 + 1.1:        i     j
 * 1.2			5 2 1 3 5 4 2
 * 1.3			5 2 1 2 3 4 5
 */
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
