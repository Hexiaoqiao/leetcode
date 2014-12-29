/**
 * Source : https://oj.leetcode.com/problems/excel-sheet-column-title/
 * Author : Hexiaoqiao
 * Date   : 2014-12-24
 *
 * 0.Problem:
 * 0.1
 * Given a positive integer, return its corresponding column title as 
 * appear in an Excel sheet.
 * For example:
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB 
 * 0.2
 * Related to question Excel Sheet Column Title
 * Given a column title as appear in an Excel sheet, return its 
 * corresponding column number.
 * For example:
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28 
 * 
 * 1.Refer.:
 */
package com.leetcode.oj;

public class ExcelSheetColumnTitle {
    public static String convertToTitle(int n) {
        if (0 >= n) return null;
        StringBuffer sb = new StringBuffer();
        int t = n;
        while (t > 0) {
            int reminder = t % 26;
            if (0 == reminder) reminder = 26;
            sb.insert(0, (char)('A' + reminder - 1));
            if (26 == reminder) t = t / 26 - 1;
            else t = t / 26;
        }
        return sb.toString();
    }
    
    public static int titleToNumber(String s) {
        int i = 0;
        while (s.charAt(i) == ' ') i++;
        long res = 0;
        int len = s.length();
        if (i == len) return -1;
        while (i < len) {
            char c = s.charAt(i);
            if (c < 'A' || c > 'Z') return -1;
            res = res * 26 + c - 'A' + 1;
            i++;
        }
        if (res > Integer.MAX_VALUE) {
            return -1;
        }
        return (int)res;
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        for (int i = 2555555; i < 255555555; i++) {
            String s = convertToTitle(i);
            System.out.print(i + " ");
            System.out.print(s + " ");
            System.out.println(titleToNumber(s));
        }
    }
}