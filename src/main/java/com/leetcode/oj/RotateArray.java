/**
 * Source : https://leetcode.com/problems/rotate-array/
 * Author : Hexiaoqiao
 * Date   : 2014-05-01
 *
 * 0.Problem:
 * Rotate an array of n elements to the right by k steps.
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] 
 * is rotated to [5,6,7,1,2,3,4].
 * Note:
 * Try to come up as many solutions as you can, there are at least 
 * 3 different ways to solve this problem.
 * 
 * 1.Refer.:
 * reverse by three times
 */

package com.leetcode.oj;

public class RotateArray {
  public static void reverse(int[] nums, int start, int end) {
    while (start < end) {
      int temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;
      start = start + 1;
      end = end - 1;
    }
  }
  
  public static void rotate(int[] nums, int k) {
    k = k % nums.length;
    reverse(nums, 0, nums.length - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, nums.length - 1);
  }
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int[] nums = {-1};
    rotate(nums, 2);
    System.out.println(nums);
  }

}
