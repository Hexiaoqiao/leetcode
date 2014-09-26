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
