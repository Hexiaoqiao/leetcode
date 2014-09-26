package com.leetcode.oj;

public class CountAndSay {
    public static String countAndSay(int n) {
        if (0 >= n) return "";
    	if (1 == n) return "1";
    	String str = "1"; 
    	for (int i = 0; i < n - 1; i++) {
    		int num = 1;
    		StringBuffer temp = new StringBuffer();
        	for (int j = 0; j < str.length(); j++) {
        		if (0 == j) {
        			if (str.length() > 1) continue;
        		} else if (str.charAt(j) == str.charAt(j - 1)) {
        			num = num + 1;
        		} else {
        			temp.append(num);
        			temp.append(str.charAt(j - 1));
        			num = 1;
        		}
    			if (j == str.length() - 1) {
    				temp.append(num);
        			temp.append(str.charAt(j));
    			}
        	}
        	str = temp.toString();
        }
    	return str;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 16;
		System.out.println(countAndSay(n));
	}

}
