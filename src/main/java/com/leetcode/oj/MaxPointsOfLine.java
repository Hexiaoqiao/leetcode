/*
0.Problem:
Given n points on a 2D plane, find the maximum number of 
points that lie on the same straight line.

1.Refer.:
1.0 按照point映射到横坐标上的升序对point进行排序（若相等纵坐标升序排）；
1.1 顺序遍历point：
	计算当前point与其后point之间的斜率，记录相同斜率point的最大数目；
1.2 返回最大值；
*/
package com.leetcode.oj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MaxPointsOfLine {
	static class Point {
		int x;
		int y;

		Point() {
			x = 0;
			y = 0;
		}

		Point(int a, int b) {
			x = a;
			y = b;
		}
	}
	
    public static int maxPoints(Point[] points) {
    	List<Point> xp = new ArrayList<Point>();
    	for (Point point : points) {
    		xp.add(point);
    	}
    	Collections.sort(xp, new Comparator<Point>() {
			@Override
			public int compare(Point a, Point b) {
				// TODO Auto-generated method stub
				if (a.x == b.x) return a.y - b.y; 
				return a.x - b.x;
			}
		});

    	int max = 0;
    	int xplen = xp.size();
    	for (int i = 0; i < xplen - max; i++) {
    		int repeat = 0;
    		List<Double> ratios = new ArrayList<Double>();
    		for (int j = i + 1; j < xplen; j++) {
    			if (xp.get(j).x == xp.get(i).x && xp.get(j).y == xp.get(i).y) {repeat = repeat + 1;}
    			else if (xp.get(j).x == xp.get(i).x) ratios.add(Double.MAX_VALUE);
    			else ratios.add(new Double(1.0 * (xp.get(j).y - xp.get(i).y) / (xp.get(j).x - xp.get(i).x)));
    		}
    		Collections.sort(ratios, new Comparator<Double>() {
    			@Override
    			public int compare(Double a, Double b) {
    				return Double.compare(a, b);
    			}
			});
    		int xmax = 0;
    		if (ratios.size() < 2) {
    			xmax = ratios.size() + repeat + 1;
    		} else {
    			int lindex = 0;
	    		for (int k = 1; k < ratios.size(); k++) {
	    			int cmp = Double.compare(ratios.get(k), ratios.get(k - 1));
	    			int size = ratios.size();
	    			if (cmp != 0 || k == size - 1) {
	    				int inc = repeat;
	    				if (k == size - 1 && cmp == 0) {
	    					inc = inc + 2;
	    				} else {
	    					inc = inc + 1;
	    				}
	    				if (xmax < k - lindex + inc) xmax = k - lindex + inc;
	    				lindex = k;
	    			}
	    		}
    		}
    		if (xmax > max) max = xmax;
    	}
        return max;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point[] points = { new Point(0, 0), new Point(0, 0), new Point(0, 0),
				new Point(0, 0), new Point(0, 0) };
		System.out.println(maxPoints(points));
	}

}
