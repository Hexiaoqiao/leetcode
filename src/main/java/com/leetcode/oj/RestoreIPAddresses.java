/**
 * Source : http://oj.leetcode.com/problems/restore-ip-addresses
 * Author : Hexiaoqiao
 * Date   : 2014-09-26
 *
 * 0.Problem:
 * Given a string containing only digits, restore it by returning all 
 * possible valid IP address combinations.
 * For example:
 * Given "25525511135",
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 * 
 * 1.Refer.:栈
 * 1.0 栈里存储ip的各位长度；
 * 1.1 四叉数深度优先遍历；
 * 1.2 遇到合理结果加入结果集中
 */
package com.leetcode.oj;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
    public static List<String> restoreIpAddresses(String s) {
        List<String> results = new ArrayList<String>();
        List<Integer> stack = new ArrayList<Integer>();
        int len = s.length();
        stack.add(1);
        int split = 1;
        while (0 != stack.size() || (0 == stack.size() && split <= 3)) {
        	stack.add(split);
        	while (3 > stack.size()) {
        		stack.add(1);
        	}
        	int aend = stack.get(0);
        	int bend = aend + stack.get(1);
        	int cend = bend + stack.get(2);
        	if (cend > len - 1 || len - cend > 3) {
        		int num = stack.remove(stack.size() - 1);
            	while (num >= 3 && 0 != stack.size()) {
            		num = stack.remove(stack.size() - 1);
            	}
            	split = num + 1;
            	if (0 == stack.size() && split > 3) {
            		break;
            	}
            	continue;
        	}
        	String ip = s.substring(0, aend) + "."+ s.substring(aend, bend) + "." + s.substring(bend, cend) + "." + s.substring(cend, len);
        	if (isValidIPAddress(ip)) results.add(ip);
        	int num = stack.remove(stack.size() - 1);
        	while (num >= 3 && 0 != stack.size()) {
        		num = stack.remove(stack.size() - 1);
        	}
        	split = num + 1;
        	if (0 == stack.size() && split > 3) {
        		break;
        	}
        }
    	return results;
    }
    
    public static boolean isValidIPAddress(String s) {
    	String[] nums = s.split("\\.");
    	if (4 != nums.length) return false; 
    	for (int i = 0; i < nums.length; i++) {
    		if (nums[i].startsWith("0") && nums[i].length() > 1) return false; 
    		int n = Integer.parseInt(nums[i]);
    		if (n > 255 || n < 0) return false;
    	}
    	return true;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String raw = "0000";
		List<String> ips = restoreIpAddresses(raw);
		for (String ip : ips) {
			System.out.println(ip);
		}
	}

}
