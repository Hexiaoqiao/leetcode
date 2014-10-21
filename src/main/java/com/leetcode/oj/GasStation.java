/**
 * Source : 
 * Author : Hexiaoqiao
 * Date   : 2014-09-26
 *
 * 0.Problem:
 * There are N gas stations along a circular route, where the amount 
 * of gas at station i is gas[i].
 * 
 * You have a car with an unlimited gas tank and it costs cost[i] of 
 * gas to travel from station i to its next station (i+1). You begin 
 * the journey with an empty tank at one of the gas stations.
 * 
 * Return the starting gas station's index if you can travel around 
 * the circuit once, otherwise return -1.
 * 
 * Note:
 * The solution is guaranteed to be unique.
 * 
 * 1.Refer.:
 * 循环遍历
 * 
 */
package com.leetcode.oj;

public class GasStation {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        assert gas.length == cost.length;
    	int len = gas.length;
    	for (int i = 0; i < len; i++) {
    		int tank = 0;
    		int start = i;
    		boolean done = true;
    		int step = start;
    		for (int j = 0; j < len; j++) {
    			tank = tank + gas[step] - cost[step];
    			if (tank < 0) {done = false; break;}
    			step = (step + 1) % len;
    		}
    		if (done) {
    			return start;
    		}
    	}
    	return -1;
    }
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] gas = {2,2};
		int[] cost = {1,5};
		System.out.println(canCompleteCircuit(gas, cost));
	}

}
