/**
 * Source : https://leetcode.com/problems/house-robber/
 * Author : Hexiaoqiao
 * Date   : 2015-05-03
 *
 * 0.Problem:
 * You are a professional robber planning to rob houses along 
 * a street. Each house has a certain amount of money stashed, 
 * the only constraint stopping you from robbing each of them 
 * is that adjacent houses have security system connected and 
 * it will automatically contact the police if two adjacent 
 * houses were broken into on the same night.
 * Given a list of non-negative integers representing the amount 
 * of money of each house, determine the maximum amount of money 
 * you can rob tonight without alerting the police.
 * 
 * 1.Refer.: DP:
 * if rob nth: rob(n) = max(norob(n - 1) + nums[n], rob(n - 1)); 
 * if not rob nth: norob(n) = rob(n - 1);
 */
package com.leetcode.oj;

public class HouseRobber {
  public static int rob(int[] nums) {
    int length = nums.length;
    if (length <= 0) return 0;
    int[] robs = new int[length];
    int[] norobs = new int[length];
    robs[0] = nums[0];
    norobs[0] = 0;
    for (int i = 1; i < length; i++) {
      norobs[i] = robs[i - 1];
      robs[i] = norobs[i - 1] + nums[i];
      if (robs[i] < robs[i - 1]) robs[i] = robs[i - 1]; 
    }
    return robs[length - 1] > norobs[length - 1] ? robs[length - 1] : norobs[length - 1];
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    int[] nums = {1,4,3,4,5,4,3,2,1};
    System.out.println(rob(nums));
  }
}
