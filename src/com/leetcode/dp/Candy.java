package com.leetcode.dp;

/**
 *  There are N children standing in a line. Each child is assigned a rating value.
 *
 *  You are giving candies to these children subjected to the following requirements:
 *
 *  Each child must have at least one candy.
 *  Children with a higher rating get more candies than their neighbors.
 *
 *  What is the minimum candies you must give?
 *
 *  Created by Xiaomeng on 9/22/2014.
 */
public class Candy {
    /**
     * Greedy
     *
     */
    public int candy(int[] ratings) {
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];

        for(int i = 0; i < ratings.length; i++){
            left[i] = 1;
            if(i > 0 && ratings[i] > ratings[i - 1]){
                left[i] = left[i - 1] + 1;
            }
        }

        for(int j = ratings.length - 1; j >= 0; j--){
            right[j] = 1;
            if(j < ratings.length - 1 && ratings[j] > ratings[j + 1]){
                right[j] = right[j + 1] + 1;
            }
        }

        int min = 0;
        for(int i = 0; i < ratings.length; i++){
            min += Math.max(left[i], right[i]);
        }
        return min;
    }

    public static void main(String[] args){
        Candy test = new Candy();
        int[] ratings = {6, 9, 5, 1, 3, 2};
        System.out.println(test.candy(ratings));
    }
}
