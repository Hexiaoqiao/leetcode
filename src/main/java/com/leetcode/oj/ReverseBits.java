/**
 * Source : https://leetcode.com/problems/reverse-bits/
 * Author : Hexiaoqiao
 * Date   : 2015-05-01
 *
 * 0.Problem:
 * Reverse bits of a given 32 bits unsigned integer.
 * For example, given input 43261596 (represented in binary as 
 * 00000010100101000001111010011100), return 964176192 (represented 
 * in binary as 00111001011110000010100101000000).
 * Follow up:
 * If this function is called many times, how would you optimize it?
 * Related problem: Reverse Integer
 * 
 * 1.Refer.:
 * 计算位数，前后位数对调
 */
package com.leetcode.oj;

public class ReverseBits {
  public static int reverseBits(int n) {
    for (int i = 0; i < 16; i++) {
      int j = 31 - i;
      int a = n & (1 << i);
      int b = n & (1 << j);
      if ((0 == a && 0 == b) || (0 != a && 0 != b)) continue;
      n = n ^ (1 << i);
      n = n ^ (1 << j);
    }
      return n;        
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    System.out.println(reverseBits(43261596));
  }

}
