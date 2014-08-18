package com.leetcode.other;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 *
 * Created by Xiaomeng on 8/17/2014.
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int profit = 0, min = Integer.MAX_VALUE;
        for(int price : prices){
            min = price < min ? price : min;
            profit = price - min > profit ? price - min : profit;
        }
        return profit;
    }

    public static void main(String[] args){
        int[] prices = {2, 1};
        BestTimeToBuyAndSellStock test = new BestTimeToBuyAndSellStock();
        System.out.println(test.maxProfit(prices));
    }
}
