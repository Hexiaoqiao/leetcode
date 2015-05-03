/**
 * Source : https://leetcode.com/problems/largest-number/
 * Author : Hexiaoqiao
 * Date   : 2014-05-01
 *
 * 0.Problem:
 * Given a list of non negative integers, arrange them such that 
 * they form the largest number.
 * For example, given [3, 30, 34, 5, 9], the largest formed number 
 * is 9534330.
 * Note: The result may be very large, so you need to return a 
 * string instead of an integer.
 * 
 * 1.Refer.:
 * quick sort
 */
package com.leetcode.oj;

public class LargestNumber {
  public static String largestNumber(int[] nums) {
    StringBuffer sb = new StringBuffer();
    qsort(nums);
    int i = 0;
    for (i = 0; i < nums.length; i++) {
      if (nums[i] != 0) break;
    }
    for (; i < nums.length; i++) {
      sb.append(nums[i]);
    }
    String res = sb.toString();
    return (res == null || res.compareTo("") == 0) ? "0" : res;
  }
  
  public static boolean compare(int a, int b) {
    long resa = a;
    long resb = b;
    int ta = a;
    int tb = b;
    do {resa = resa * 10; tb = tb / 10;} while (tb != 0);
    resa = resa + b;
    do {resb = resb * 10; ta = ta / 10;} while (ta != 0);
    resb = resb + a;
    if (resa >= resb) return true;
    return false;
  }
  
  public static int partition(int[] nums, int start, int end) {
    int pivot = nums[start];
    while (start < end) {
      while (start < end && compare(pivot, nums[end])) end--;
      nums[start] = nums[end];
      while(start < end && compare(nums[start], pivot)) start++;
      nums[end] = nums[start];
    }
    nums[start] = pivot;
    return start;
  }
  
  public static void quicksort(int[] nums, int start, int end) {
    if (start < end) {
      int pivot = partition(nums, start, end);
      quicksort(nums, start, pivot - 1);
      quicksort(nums, pivot + 1, end);
    }
  }
  
  public static void qsort(int[] nums) {
    quicksort(nums, 0, nums.length - 1);
  }

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int[] nums = {0,0};
    qsort(nums);
    System.out.println(largestNumber(nums));
  }

}
