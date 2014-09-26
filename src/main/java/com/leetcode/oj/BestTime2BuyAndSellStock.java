package com.leetcode.oj;

import java.util.ArrayList;
import java.util.List;

public class BestTime2BuyAndSellStock {
    public static int maxProfit(int[] prices) {
        int profit = 0;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < prices.length; i++) {
            profit = profit < prices[i] - min ? prices[i] - min : profit;
            min = min > prices[i] ? prices[i] : min; 
        }

        return profit;
    }
    
    public static int maxProfit2(int[] prices) {
        int total = 0;
        for (int i = 1; i < prices.length; i++) {
        	if (prices[i] > prices[i - 1]) total = total + prices[i] - prices[i - 1];
        }
    	return total;
    }
    
    public static int maxProfit3(int[] prices) {
    	List<Integer> p = maxProfitPoint(prices, 0, prices.length);
    	int profit = p.get(2);
    	List<Integer> p1 = maxProfitPoint(prices, 0, p.get(0));
    	List<Integer> p2 = maxProfitPoint(prices, p.get(1) + 1, prices.length);
    	profit = profit + (p1.get(2) > p2.get(2) ? p1.get(2) : p2.get(2));
    	
    	for(int i = p.get(0) + 1; i < p.get(1); i++) {
    		List<Integer> left = maxProfitPoint(prices, p.get(0), i);
    		List<Integer> right = maxProfitPoint(prices, i, p.get(1) + 1);
    		if (left.get(2) + right.get(2) > profit) profit = left.get(2) + right.get(2); 
    	}
        return profit;
    }
	
    public static List<Integer> maxProfitPoint(int[] prices, int a, int b) {
    	List<Integer> res = new ArrayList<Integer>();
    	if (a == b) {res.add(a); res.add(a); res.add(0);return res;}
        int profit = 0;
        int min = a;
        int minp = a, maxp = a;
        for(int i = a; i < b; i++) {
        	if (profit < prices[i] - prices[min]) {profit = prices[i] - prices[min]; maxp = i; minp = min;}
            if (prices[min] > prices[i]) {min = i;} 
        }
        res.add(minp); res.add(maxp); res.add(profit);
        return res;
    }
    
    /**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {2,1,4,5,2,9,7};
		System.out.println(maxProfit(prices));
		System.out.println(maxProfit2(prices));
		System.out.println(maxProfit3(prices));
	}

}
