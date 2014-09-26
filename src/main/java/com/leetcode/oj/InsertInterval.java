package com.leetcode.oj;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {
	public static class Interval {
		int start;
		int end;
		Interval() {
			start = 0;
			end = 0;
		}
		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}
	
    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    	intervals.add(0, newInterval);
    	int index = 0;
    	for (int i = 1; i < intervals.size(); i++) {
    		Interval idx = intervals.get(index);
    		Interval cur = intervals.get(i);
    		if (idx.end < cur.start) continue;
    		if (idx.start > cur.end) {
    			Interval t = intervals.remove(index);
    			intervals.add(i, t);
    			index = i;
    			continue;
    		}
    		if (idx.start > cur.start) {
	    		if (idx.end >= cur.end && idx.start <= cur.end) {
	    			Interval val = new Interval(cur.start, idx.end);
	    			intervals.add(i, val);
	    			intervals.remove(i + 1);
	    			intervals.remove(index);
	    			index = i - 1;
	    			i--;
	    		} else {
	    			intervals.remove(index);
	    			index = i - 1;
	    			i--;
	    		}
    		} else {
    			if (idx.end >= cur.end) {
    				intervals.remove(i);
    				i--;
    			} else {
    				Interval val = new Interval(idx.start, cur.end);
    				intervals.add(i, val);
    				intervals.remove(i + 1);
    				intervals.remove(index);
    				index = i - 1;
    				i--;
    			}
    		}
    	}
        return intervals;
    }
    
	public static void print(List<Interval> intervals) {
		for (int i = 0; i < intervals.size(); i++) {
			System.out.println("[" + intervals.get(i).start + "," + intervals.get(i).end + "]");
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Interval newInterval = new Interval(5,9);
		Interval i1 = new Interval(0,1);
		Interval i2 = new Interval(2,6);
		Interval i3 = new Interval(7,10);
		/*Interval i4 = new Interval(6,7);
		Interval i5 = new Interval(8,10);*/
		Interval i6 = new Interval(11,11);
		Interval i7 = new Interval(12,13);
		List<Interval> l = new ArrayList<Interval>();
		l.add(i1);l.add(i2);l.add(i3);/*l.add(i4);l.add(i5);*/l.add(i6);l.add(i7);
		List<Interval> res = insert(l, newInterval);
		print(res);
	}

}
