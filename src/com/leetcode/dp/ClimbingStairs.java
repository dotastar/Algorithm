package com.leetcode.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Created by Xiaomeng on 8/3/2014.
 */
public class ClimbingStairs{
    Map<Integer, Integer> memo = new HashMap<Integer, Integer>();
    public int climbStairs(int n) {
        if(n == 1 || n == 2) return n;
        if(memo.containsKey(n)) return memo.get(n);
        memo.put(n, climbStairs(n - 2) + climbStairs(n - 1));
        return memo.get(n);
    }

    public static void main(String[] args){
        ClimbingStairs test = new ClimbingStairs();
        System.out.println(test.climbStairs(4));
    }
}
