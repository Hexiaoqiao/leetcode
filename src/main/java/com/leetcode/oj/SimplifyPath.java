/**
 * Source : http://oj.leetcode.com/problems/simplify-path
 * Author : Hexiaoqiao
 * Date   : 2014-09-26
 *
 * 0.Problem:
 * Given an absolute path for a file (Unix-style), simplify it.
 * 
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * click to show corner cases.
 * 
 * Corner Cases:
 * Did you consider the case where path = "/../"?
 * In this case, you should return "/".
 * Another corner case is the path might contain multiple 
 * slashes '/' together, such as "/home//foo/".
 * In this case, you should ignore redundant slashes and 
 * return "/home/foo".
 * 
 * 1.Refer.:
 * 1.0 按照/分割path；
 * 1.1 将.和空白用特殊字符代替；
 * 1.2 其他按照规则处理..（过程中跳过特殊字符），然后将..用特殊字符代替；
 * 1.3 收集结果
 */
package com.leetcode.oj;

public class SimplifyPath {
    public static String simplifyPath(String path) {
    	String[] dirs = path.split("/");
    	int end = -1;
    	for (int i = 0; i < dirs.length; i++) {
    		if ("&".equals(dirs[i])) continue;
    		if ("..".equals(dirs[i])) {
    			dirs[i] = "&";
    			while(-1 < end) {
    				dirs[end] = "&"; 
    				end--; 
    				if (end < 0 || !("&".equals(dirs[end]))) break;
    			}
    		} else if (".".equals(dirs[i]) || dirs[i].isEmpty()) {
    			dirs[i] = "&";
    		} else {
    			end++;
    			while ("&".equals(dirs[end])) {
    				end++;
    			}
    		}
    	}
    	StringBuffer sb = new StringBuffer();
    	if (-1 == end) sb.append("/");
    	else {
    		for (int i = 0; i <= end; i++) {
    			if ("&".equals(dirs[i])) continue;
	    		sb.append("/");
	    		sb.append(dirs[i]);
    		}
    	}
    	if (0 == sb.length()) sb.append("/");
        return sb.toString();
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "//";
		System.out.println(simplifyPath(path));
	}

}
