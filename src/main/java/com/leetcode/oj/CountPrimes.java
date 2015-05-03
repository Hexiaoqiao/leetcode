/**
 * Source : https://leetcode.com/problems/count-primes/
 * Author : Hexiaoqiao
 * Date   : 2015-05-03
 *
 * 0.Problem:
 * Count the number of prime numbers less than a non-negative number, n
 * 
 * 1.Refer.:
 * 
 */
package com.leetcode.oj;

public class CountPrimes {
  public static int countPrimes(int n) {
    if (n < 3) return 0;
    boolean[] isPrimes = new boolean[n];
    for (int i = 0; i < n; i++) isPrimes[i] = true; 
    isPrimes[0] = false;
    isPrimes[1] = false;
    isPrimes[2] = true;
    int count = 0;
    int k = (int) Math.sqrt(n);
    for (int i = 2; i < n; i++) {
      if (isPrimes[i]) {
        count = count + 1;
        if (i > k) continue;
        for (int j = i * i; j < n; j = j + i) {
          isPrimes[j] = false;
        }
      }
    }
    return count;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    for (int i = 2; i < 100; i++) {
      System.err.println(countPrimes(i));
    }
    System.out.println(countPrimes(499979));
  }

}
