package com.leetcode.oj;

public class DecodeWays {
    public static int numDecodings(String s) {
    	if ((0 == s.length()) || (1 == s.length() && '0' == s.charAt(0))) return 0;
    	if (1 == s.length()) return 1;
    	char a = s.charAt(s.length() - 1);
    	char b = s.charAt(s.length() - 2);
    	int c = (b - '0') * 10 + a - '0';
    	if (2 == s.length()) {
    		if ('0' == a) return 1;
    		else if (c > 10 && c <= 26) {
    			return 2;
    		} else {
    			return 1;
    		}
    	} 
    	if ('0' == a) {
    		if (2 == s.length()) {
    			return 1;
    		} else {
    			return numDecodings(s.substring(0, s.length() - 2));
    		}
    	} else if (c > 26 || c < 10) {
    		return numDecodings(s.substring(0, s.length() - 1));
    	} else {
    		return numDecodings(s.substring(0, s.length() - 1)) + numDecodings(s.substring(0, s.length() - 2));
    	}
    }
    
    public static int numDecodings2(String s) {
    	if ((0 == s.length()) || (1 == s.length() && '0' == s.charAt(0))) return 0;
    	if (1 == s.length()) return 1;
    	int[] num = new int[s.length()];
    	for (int i = 0; i < num.length; i++) {
    		if (0 == i && '0' == s.charAt(0)) return 0;
    		else if (0 == i) num[0] = 1;
        	else if (1 == i) {
        		char a = s.charAt(0);
        		char b = s.charAt(1);
        		int c = (a - '0') * 10 + b - '0';
        		if ('0' == s.charAt(1)) { 
        			if (a > '0' && a < '3') {
        				num[1] = num[0];
	    			} else {
	    				return 0;
	    			}
        		} else if (c > 10 && c <= 26) {
        			num[0] = 1; num[1] = 2;
        		} else if (b == '0' && c > 26) {
        			return 0;
        		} else {
        			num[0] = 1; num[1] = 1;
        		}
        	} else {
        		char a = s.charAt(i - 1);
            	char b = s.charAt(i - 2);
            	int c = (b - '0') * 10 + a - '0';
            	char d = s.charAt(i);
            	int e = (a - '0') * 10 + d - '0';
            	if ('0' == a) {
            		if ('0' == d) return 0;
            		else num[i] = num[i - 2];
            	} else if (0 == c) {
            		return 0;
            	} else if (c > 26 || c < 10) {
            		if ('0' == d) {
            			if (a > '0' && a < '3') {
            				num[i] = num[i - 2];
            			} else {
            				return 0;
            			}
            		} else {
                		num[i] = num[i - 1];
            		}
            	} else if (e > 26) {
            		if ('0' == d) {
            			if (a > '0' && a < '3') {
            				num[i] = num[i - 2];
            			} else {
            				return 0;
            			}
            		} else {
                		num[i] = num[i - 1];
            		}
            	} else {
            		if ('0' == d) {
            			if (a > '0' && a < '3') {
            				num[i] = num[i - 2];
            			} else {
            				return 0;
            			}
            		} else {
            			num[i] = num[i - 1] + num[i - 2];
            		}
            	}
        	}
    	}
    	return num[num.length - 1];
    }
    
    
    public static int numDecodings3(String s) {
    	if (null == s || 0 == s.length()) return 0;
    	int len = s.length();
    	if (1 == len) {
    		if ('0' == s.charAt(0)) return 0;
    		else return 1;
    	}
    	int[] num = new int[len];
    	if ('0' == s.charAt(0)) {
    		return 0;
    	} else {
    		num[0] = 1;
    	}
    	char a = s.charAt(0);
    	char b = s.charAt(1);
    	int c = (a - '0') * 10 + b - '0';
    	if ('0' == s.charAt(1)) {
    		if (c >= 10 && c < 27) {
    			num[1] = 1;
    		} else {
    			return 0;
      		}
    	} else if (c >= 10 && c < 27) {
    		num[1] = 2;
    	} else {
    		num[1] = 1;
    	}
    	
    	for (int i = 2; i < len; i++) {
        	char d = s.charAt(i - 1);
        	char e = s.charAt(i);
        	int f = (d - '0') * 10 + e - '0';
        	if ('0' == e) {
        		if (f >= 10 && f < 27) {
        			num[i] = num[i - 2];
        		} else {
        			return 0;
        		}
        	} else if (f >= 10 && f < 27) {
        		num[i] = num[i - 1] + num[i - 2];
        	} else {
        		num[i] = num[i - 1];
        	}
    	}
    	return num[len - 1];
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "2201";
		System.out.println(numDecodings3(s));
	}
}
