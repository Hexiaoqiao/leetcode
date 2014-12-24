/**
 * Source : https://oj.leetcode.com/problems/majority-element/
 * Author : Hexiaoqiao
 * Date   : 2014-12-24
 *
 * 0.Problem:
 * Given an array of size n, find the majority element. The 
 * majority element is the element that appears more than 
 * ⌊ n/2 ⌋ times. You may assume that the array is non-empty 
 * and the majority element always exist in the array.
 * 
 * 1.Refer.: 
 * 两个不同元素先行删除，最后剩下的即是结果
 */
package com.leetcode.oj;

public class MajorityElement {
    public static int majorityElement(int[] num) {
        if (null == num || 0 == num.length) return -1;
        int elem = 0;
        int nums = 0;
        int len = num.length;
        for (int i = 0; i < len; i++) {
            if (0 == nums) {
                elem = num[i];
                nums = 1;
            } else {
                if (elem == num[i]) {
                    nums = nums + 1;
                } else {
                    nums = nums - 1;
                }
            }
        }
        return elem;
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] tests = { 
                { 1, 1, 1, 2, 2 }, 
                { 1 }, 
                { 1, 2, 1 },
                { 1, 1, 2, 2, 2 }, 
                { 1, 1 }, 
                { 1, 2, 3, 2, 1 } 
        };
        int[] res = {1,1,1,2,1,1};
        for (int i = 0; i < tests.length; i++) {
            System.out.print(majorityElement(tests[i]));
            System.out.println(" " + res[i]);
        }
    }

}
