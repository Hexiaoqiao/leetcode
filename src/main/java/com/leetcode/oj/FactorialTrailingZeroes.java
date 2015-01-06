/**
 * Source : https://oj.leetcode.com/problems/factorial-trailing-zeroes/
 * Author : Hexiaoqiao
 * Date   : 2015-01-06
 *
 * 0.Problem:
 * Given an integer n, return the number of trailing zeroes in n!.
 * 
 * 1.Refer.:
 * 
 */
package com.leetcode.oj;

public class FactorialTrailingZeroes {
    public static int trailingZeroes(int n) {
        int res = 0;
        int temp = n;
        while (0 != temp) {
            temp = temp / 5;
            res = res + temp;
        }
        return res;
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        for (int i = 1; i < 1000; i++) {
            System.out.println(trailingZeroes(i));
        }
    }

}
