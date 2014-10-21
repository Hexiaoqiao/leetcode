/**
 * Source : 
 * Author : Hexiaoqiao
 * Date   : 2014-09-26
 *
 * 0.Problem:
 * Given a collection of intervals, merge all overlapping intervals.
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 * 
 * 1.Refer.:
 * 1.0 按照intervals的左区间升序排序；
 * 1.1 顺序遍历intervals，比较当前interval的右区别和下一interval的左右区间值
 * 决定是否合并
 */
package com.leetcode.oj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
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

	public static List<Interval> merge(List<Interval> intervals) {
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				return o1.start-o2.start;
			}
			
		});
		for (int i = 0; i < intervals.size() - 1; i++) {
			Interval o1 = intervals.get(i);
			Interval o2 = intervals.get(i + 1);
			if (o1.end < o2.start) continue;
			if (o1.end >= o2.start && o1.end <= o2.end) {
				Interval o = new Interval(o1.start, o2.end);
				intervals.add(i, o);
				intervals.remove(i + 1);
				intervals.remove(i + 1);
				i--;
			} else {
				intervals.remove(i + 1);
				i--;
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
		Interval o1 = new Interval(1,2);
		Interval o2 = new Interval(1,2);
		List<Interval> l = new ArrayList<Interval>();
		l.add(o1);l.add(o2);
		print(merge(l));
	}

}
