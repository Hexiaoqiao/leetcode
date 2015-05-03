/**
 * Source : https://leetcode.com/problems/bitwise-and-of-numbers-range/
 * Author : Hexiaoqiao
 * Date   : 2015-05-03
 *
 * 0.Problem:
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the 
 * bitwise AND of all numbers in this range, inclusive.
 * For example, given the range [5, 7], you should return 4.
 * 
 * 1.Refer.: 
 * 
 */
package com.leetcode.oj;

public class BitwiseANDofNumbersRange {
  public static int rangeBitwiseAnd(int m, int n) {
    while (n > m) {
      n = n & (n - 1);
    }
    return n;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    System.out.println(Integer.MAX_VALUE);
  }

}
