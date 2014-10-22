/**
 * Source : http://oj.leetcode.com/problems/sort-colors
 * Author : Hexiaoqiao
 * Date   : 2014-09-26
 *
 * 0.Problem:
 * Given an array with n objects colored red, white or blue, 
 * sort them so that objects of the same color are adjacent, 
 * with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent 
 * the color red, white, and blue respectively.
 * Note:
 * You are not suppose to use the library's sort function for 
 * this problem.
 * 
 * 1.Refer.:
 * 1.0 从两边向中间遍历：
 * 1.1 左边从当前位置向右到第一个非零位置i；
 * 1.2 右边从当前位置向左到第一个非2位置j；
 * 1.3 A[i]=2 && A[j]=0直接交换；继续1.1；
 * 1.4 A[i]=2 && A[j]!=0则A[j]=2，A[i]=1;继续1.1；
 * 1.5 A[i]!=2 && A[j]=0则A[i]=0,A[j]=1;继续1.1；
 */
package com.leetcode.oj;

public class SortColors {
    public static void sortColors(int[] A) {
    	int zindex = 0;
        int tindex = A.length - 1;
        int i = 0;
        while (i < A.length && 0 == A[i]) {
        	zindex = zindex + 1;
        	i = i + 1;
        }
        i = A.length - 1;
        while (i >= 0 && 2 == A[i]) {
        	tindex = tindex - 1;
        	i = i - 1;
        }
        if (tindex <= zindex) return;
        for (i = zindex; i <= tindex;) {
        	if (2 == A[i] && 0 == A[tindex]) {
        		A[zindex] = 0; A[tindex] = 2; 
        		if (i != zindex && i != tindex) A[i] = 1;
        		while (zindex < A.length && 0 == A[zindex]) zindex = zindex + 1;
        		while (tindex >= 0 && 2 == A[tindex]) tindex = tindex - 1;
        	} else if (2 == A[i]) {
        		A[tindex] = 2; 
        		if (i != tindex) A[i] = 1;
        		while (tindex >= 0 && 2 == A[tindex]) tindex = tindex - 1;
        	} else if (0 == A[i]) {
        		A[zindex] = 0; 
        		if (i != zindex) A[i] = 1;
        		while (zindex < A.length && 0 == A[zindex]) zindex = zindex + 1;
        	}
        	if (zindex > i) {
        		i = zindex;
        	} else {
        		i++;
        	}
        }
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {2,2,0};
		sortColors(A);
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
	}

}
