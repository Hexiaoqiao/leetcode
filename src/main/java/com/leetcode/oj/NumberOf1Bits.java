/**
 * Source : https://leetcode.com/problems/number-of-1-bits/
 * Author : Hexiaoqiao
 * Date   : 2015-05-01
 *
 * 0.Problem:
 * Write a function that takes an unsigned integer and returns 
 * the number of ’1' bits it has (also known as the Hamming weight).
 * For example, the 32-bit integer ’11' has binary representation 
 * 00000000000000000000000000001011, so the function should return 3.
 * 
 * 1.Refer.:
 * n = n & (n - 1)
 */
package com.leetcode.oj;

public class NumberOf1Bits {
  // you need to treat n as an unsigned value
  public static int hammingWeight(int n) {
    int res = 0;
    while (0 != n) {
      n = n & (n - 1);
      res = res + 1;
    }
      return res;        
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    System.out.println(hammingWeight(100));
  }

}
