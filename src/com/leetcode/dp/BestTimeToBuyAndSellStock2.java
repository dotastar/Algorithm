package com.leetcode.dp;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times).
 * However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 *
 * Created by Xiaomeng on 8/17/2014.
 */
public class BestTimeToBuyAndSellStock2 {
    public int maxProfit(int[] prices) {
        int profit = 0, min = 0;
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < prices[min]) min = i;
            if(prices[i] > prices[min]){
                profit += prices[i] - prices[min];
                min = i;
            }
        }
        return profit;
    }

    public static void main(String[] args){
        int[] prices = {2,4,1,7};
        BestTimeToBuyAndSellStock2 test = new BestTimeToBuyAndSellStock2();
        System.out.println(test.maxProfit(prices));
    }
}
