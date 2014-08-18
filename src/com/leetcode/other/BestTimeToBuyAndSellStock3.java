package com.leetcode.other;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 *
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 *
 * Created by Xiaomeng on 8/17/2014.
 */
public class BestTimeToBuyAndSellStock3 {
    /**
     * DP: O(n) time
     * Reference: http://zhongyinzhang.wordpress.com/2014/02/11/best-time-to-buy-and-sell-stock-iii/
     *
     * @param prices
     * @return profit
     */
    public int maxProfit(int[] prices) {
        if(prices.length == 0 || prices.length == 1) return 0;

        int[] left = new int[prices.length];
        int[] right = new int[prices.length];

        left[0] = 0;
        int min = prices[0];
        for(int i = 1; i < prices.length; i++){
            left[i] = Math.max(left[i - 1], prices[i] - min);
            min = prices[i] < min ? prices[i] : min;
        }

        right[prices.length - 1] = 0;
        int max = prices[prices.length - 1];
        for(int i = prices.length - 2; i >= 0; i--){
            right[i] = Math.max(right[i + 1], max - prices[i]);
            max = prices[i] > max ? prices[i] : max;
        }

        int maxProfit = 0;
        for(int i = 0; i < prices.length; i++){
            maxProfit = Math.max(maxProfit, left[i] + right[i]);
        }
        return maxProfit;
    }

    public static void main(String[] args){
        int[] prices = {1, 2};
        BestTimeToBuyAndSellStock3 test = new BestTimeToBuyAndSellStock3();
        System.out.println(test.maxProfit(prices));
    }
}
