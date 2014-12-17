/**
 * Source : https://oj.leetcode.com/problems/fraction-to-recurring-decimal/
 * Author : Hexiaoqiao
 * Date   : 2014-12-17
 *
 * 0.Problem:
 * Given two integers representing the numerator and denominator of 
 * a fraction, return the fraction in string format.
 * If the fractional part is repeating, enclose the repeating part 
 * in parentheses.
 * 
 * For example,
 * Given numerator = 1, denominator = 2, return "0.5".
 * Given numerator = 2, denominator = 1, return "2".
 * Given numerator = 2, denominator = 3, return "0.(6)".
 * 
 * 1.Refer.:
 * 正常计算，保存余数至HashMap记录循环起至位置
 * 
 */
package com.leetcode.oj;

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal {
    public static String fractionToDecimal(int numerator, int denominator) {
        if (0 == denominator) return null;
        int sign = 0;
        if ((0 > numerator && 0 > denominator) || (0 < numerator && 0 < denominator)) {
            sign = 1;
        } else if ((0 > numerator && 0 < denominator) || (0 < numerator && 0 > denominator)) {
            sign = -1;
        }
        long num = numerator < 0 ? -1L * numerator : numerator;
        long den = denominator < 0 ? -1L * denominator : denominator;
        long dev = num / den;
        long rem = num % den;
        Map<Long,Integer> rems = new HashMap<Long, Integer>();
        StringBuffer sb = new StringBuffer();
        int index = 0;
        int start = 0;
        int end = 0;
        while (0 != rem) {
            Integer last = rems.get(rem);
            if (null != last) {
                start = last;
                end = index;
                break;
            }
            rems.put(rem, index);
            rem = rem * 10;
            sb.append(rem / den);
            rem = rem % den;
            index = index + 1;
        }
        StringBuffer ret = new StringBuffer();
        if (sign < 0) {
            ret.append("-");
        }
        ret.append(dev);
        if (0 == start && 0 == end) {
            if (0 < sb.length()) {
                ret.append(".");
                ret.append(sb);
            }
        } else {
            ret.append(".");
            ret.append(sb.substring(0, start));
            ret.append("(");
            ret.append(sb.substring(start));
            ret.append(")");
        }
        return ret.toString();
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] ns = {-1,1,0,2,3,6,7,11,-1,1};
        int[] ds = {-2147483648,0,1,3,3,2,2,3,2,-2};
        for (int i = 0; i < ns.length; i++) {
            System.out.println(fractionToDecimal(ns[i],ds[i]));
        }
    }
}
