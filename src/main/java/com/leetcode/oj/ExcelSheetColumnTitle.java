/**
 * Source : https://oj.leetcode.com/problems/excel-sheet-column-title/
 * Author : Hexiaoqiao
 * Date   : 2014-12-24
 *
 * 0.Problem:
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
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        for (int i = 26; i < 25600; i++) {
            System.out.println(convertToTitle(i));
        }
    }
}