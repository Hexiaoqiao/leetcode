/**
 * Source : https://oj.leetcode.com/problems/compare-version-numbers/
 * Author : Hexiaoqiao
 * Date   : 2014-12-16
 *
 * 0.Problem:
 * Compare two version numbers version1 and version1.
 * If version1 > version2 return 1, if version1 < version2 
 * return -1, otherwise return 0.
 * 
 * You may assume that the version strings are non-empty and 
 * contain only digits and the . character.
 * The . character does not represent a decimal point and is 
 * used to separate number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to 
 * version three", it is the fifth second-level revision of 
 * the second first-level revision.
 * Here is an example of version numbers ordering:
 * 0.1 < 1.1 < 1.2 < 13.37 
 * 
 * 1.Refer.:[ugly]
 * 字符串分割
 */
package com.leetcode.oj;

public class CompareVersionNumbers {
    public static int compareVersion(String version1, String version2) {
        if (null == version2 && null == version1) return 0;
        else if ("".equals(version2) && "".equals(version1)) return 0;
        else if (null == version1 || "".equals(version1)) return -1;
        else if (null == version2 || "".equals(version2)) return 1;
        String[] v1 = {version1}; 
        String[] v2 = {version2}; 
        if (version1.contains(".")) v1 = version1.split("\\.");
        if (version2.contains(".")) v2 = version2.split("\\.");
        int len1 = v1.length;
        int len2 = v2.length;
        int len = len1 > len2 ? len2 : len1;
        int i = 0;
        for (i = 0; i < len; i++) {
            int vs1 = Integer.valueOf(v1[i]).intValue();
            int vs2 = Integer.valueOf(v2[i]).intValue();
            if (vs1 > vs2) return 1;
            else if (vs1 < vs2) return -1;
        }
        if (len1 == len2) return 0; 
        String[] c = len1 > len2 ? v1 : v2;
        int ret = len1 > len2 ? 1 : -1;
        for (; i < c.length; i++) {
            int vs = Integer.valueOf(c[i]).intValue();
            if (0 != vs) return ret;
        }
        return 0;
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String[] version1 = {null,null,"1","1","1","1.0","1","1.1","1.2","1.2.2","0"};
        String[] version2 = {null,"1",null,"1","2","1","1.0","1.1","1.3","1.2","1"};
        int[] res = {0,-1,1,0,-1,0,0,0,-1,1,-1};
        for (int i = 0; i < version1.length; i++) {
            System.out.print(compareVersion(version1[i], version2[i]));
            System.out.print(" ");
        }
        System.out.println();
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]);
            System.out.print(" ");
        }
        System.out.println();
    }

}
