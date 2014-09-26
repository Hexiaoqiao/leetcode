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
