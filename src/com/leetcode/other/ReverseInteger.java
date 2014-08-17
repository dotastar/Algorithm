package com.leetcode.other;

/**
 * Reverse digits of an integer.
 *
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 *
 * Have you thought about this?
 *
 * Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!
 *
 * If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.
 *
 * Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?
 *
 * Throw an exception? Good, but what if throwing an exception is not an option? You would then have to re-design the function (ie, add an extra parameter).
 *
 * Created by Xiaomeng on 7/30/2014.
 */
public class ReverseInteger {
    public int reverse(int x) {
        boolean positive = x >= 0;
        x = Math.abs(x);
        int result = 0;
        while(x != 0){
            result = result * 10 + x % 10;
            x = x / 10;
        }
        if(result < 0) return -1;
        return positive ? result : -result;
    }

    public static void main(String[] args){
        ReverseInteger test = new ReverseInteger();
        int x = -1000000092;
        int y = -2000000092;
        System.out.println(x + y);
    }
}
