/**
 * Source : 
 * Author : Hexiaoqiao
 * Date   : 2014-09-26
 *
 * 0.Problem:
 * 0.0:
 * Say you have an array for which the ith element is the price of a given 
 * stock on day i.
 * 
 * If you were only permitted to complete at most one transaction (ie, buy 
 * one and sell one share of the stock), design an algorithm to find the 
 * maximum profit.
 * 
 * 0.1
 * Say you have an array for which the ith element is the price of a given 
 * stock on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete as many 
 * transactions as you like (ie, buy one and sell one share of the stock 
 * multiple times). However, you may not engage in multiple transactions at 
 * the same time (ie, you must sell the stock before you buy again).
 * 
 * 0.2
 * Say you have an array for which the ith element is the price of a given 
 * stock on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete at most 
 * two transactions.
 * 
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must 
 * sell the stock before you buy again).
 * 
 * 1.Refer.:
 * 1.0:逐个遍历，记录截止当前记录最小值，当前记录与最小记录之间的差值与当前最大结果比较；
 * 1.1:逐个遍历，只要当前记录大于前一记录立即进行一次卖出-买入操作；
 * 1.2:先从整个记录中找到交易一次最大利润时的边界[min,max],同样的方式探索[0,min],[max,length]
 * 及[min,k],[k,max]取其最大值。(注：效率不是最优)
 */
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
