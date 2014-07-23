package com.leetcode.math;

/**
 * Implement int sqrt(int x).
 *
 * Compute and return the square root of x.
 *
 * Created by Xiaomeng on 7/22/2014.
 */
public class Sqrt {
    public int sqrt(int x) {
        if(x == 0 || x == 1) return x;
        long high = x, low = 0;
        while(high - low > 1){
            long mid = low + (high - low)/2;
            if(mid * mid > x){
                high = mid;
            }else{
                low = mid;
            }
        }
        return (int)low;
    }
}
