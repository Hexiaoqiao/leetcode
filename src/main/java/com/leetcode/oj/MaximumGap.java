/**
 * Source : https://oj.leetcode.com/problems/maximum-gap/
 * Author : Hexiaoqiao
 * Date   : 2014-12-16
 *
 * 0.Problem:
 * Given an unsorted array, find the maximum difference between 
 * the successive elements in its sorted form.
 * Try to solve it in linear time/space.
 * Return 0 if the array contains less than 2 elements.
 * You may assume all elements in the array are non-negative 
 * integers and fit in the 32-bit signed integer range.
 * 
 * 1.Refer.:
 */
package com.leetcode.oj;

public class MaximumGap {
    //runtime error since OOMError
    public static int maximumGap(int[] num) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        if (null == num) return 0;
        int len = num.length;
        if (len < 2) return 0; 
        for (int i = 0; i < len; i++) {
            if (min > num[i]) min = num[i];
            if (max < num[i]) max = num[i];
        }
        int bucketsize = max - min;
        int[] bucket = new int[bucketsize + 1];
        for (int i = 0; i < bucketsize + 1; i++) {
            bucket[i] = -1;
        }
        for (int i = 0; i < len; i++) {
            bucket[num[i] - min] = 1;
        }
        int last = -1;
        int gap = 0;
        for (int i = 0; i < bucketsize + 1; i++) {
            if (-1 != bucket[i]) {
                if (-1 != last) {
                    int g = i - last;
                    gap = gap < g ? g : gap;
                    last = i;
                } else {
                    last = i;
                }
            }
        }
        return gap;
    }
    
    public static int maximumGap1(int[] num) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        if (null == num) return 0;
        int len = num.length;
        if (len < 2) return 0; 
        for (int i = 0; i < len; i++) {
            if (min > num[i]) min = num[i];
            if (max < num[i]) max = num[i];
        }
        int bsize = (int)Math.ceil((max-min) * 1.0 / (len - 1));
        int[] bmax = new int[len - 1];
        int[] bmin = new int[len - 1];
        for (int i = 0; i < len - 1; i++) {
            bmax[i] = Integer.MIN_VALUE;
            bmin[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < len; i++) {
            if (num[i] == min || num[i] == max) continue;
            int idx = (num[i] - min) / bsize;
            bmax[idx] = bmax[idx] < num[i] ? num[i] : bmax[idx];
            bmin[idx] = bmin[idx] > num[i] ? num[i] : bmin[idx];
        }
        int maxgap = Integer.MIN_VALUE;
        int last = min;
        for (int i = 0; i < len - 1; i++) {
            if (Integer.MIN_VALUE == bmax[i] && Integer.MAX_VALUE == bmin[i]) continue;
            maxgap = maxgap < bmin[i] - last ? bmin[i] - last : maxgap;
            last = bmax[i];
        }
        maxgap = maxgap < max - last ? max - last : maxgap;
        return maxgap;
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] nums = {
                {10,2,3,7,25,50,10,100,999999},
                {},
                {1},
                {1,2},
                {1,3,99999},
                {1,5,10}};
        for (int i = 0; i < nums.length; i++) {
            System.out.println(maximumGap1(nums[i]));
        }
    }

}
