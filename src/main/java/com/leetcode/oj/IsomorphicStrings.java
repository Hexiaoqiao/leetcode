/**
 * Source : https://leetcode.com/problems/isomorphic-strings/
 * Author : Hexiaoqiao
 * Date   : 2015-05-03
 *
 * 0.Problem:
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while 
 * preserving the order of characters. No two characters may map to the same 
 * character but a character may map to itself.
 * 
 * For example,
 * Given "egg", "add", return true.
 * Given "foo", "bar", return false.
 * Given "paper", "title", return true.
 * Note:
 * You may assume both s and t have the same length.
 * 
 * 1.Refer.:
 * 
 */
package com.leetcode.oj;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
  public static boolean isIsomorphic(String s, String t) {
    if (null == s && null == t) return true;
    if (null == s || null == t) return false; 
    if (s.length() != t.length()) return false;
    int length = s.length();
    if (0 == length) return true;  
    Map<Character, Character> maptables = new HashMap<Character, Character>();
    Map<Character, Character> norepeate = new HashMap<Character, Character>();
    for (int i = 0; i < length; i++) {
      char sc = s.charAt(i);
      char tc = t.charAt(i);
      Character val = maptables.get(sc);
      if (val == null) {
        if (norepeate.get(tc) == null) { 
          maptables.put(sc, tc);
          norepeate.put(tc, sc);
        } else {
          return false;
        }
      } else if (val.charValue() != tc) {
        return false;
      }
    }
    return true;
  }
  public static void main(String[] args) {
    // TODO Auto-generated method stub
    String[] ss = {"","s","ss","Ss","ts","ts","aa","ab"};
    String[] ts = {"","t","ts","TT","st","","ab","aa"};
    int len = ss.length;
    for (int i = 0; i < len; i++) {
      System.out.println(isIsomorphic(ss[i], ts[i]));
    }
  }

}
