package com.leetcode.arithmetic;

/**
 * Divide two integers without using multiplication, division and mod operator.
 *
 * Reference: http://tech-wonderland.net/blog/leetcode-divide-two-integers.html
 *
 * Created by Xiaomeng on 9/5/2014.
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if(dividend == 0) return 0;
        if(divisor == 1) return dividend;

        boolean postive = true;
        if((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) postive = false;

        int result = 0;
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);

        while(a >= b){
            long c = b;
            for(int i = 0; a >= c; i++, c <<= 1){
                a -= c;
                result += 1 << i;
            }
        }
        return postive ? result : -result;
    }

    public static void main(String[] args){
        DivideTwoIntegers test = new DivideTwoIntegers();
        System.out.println(test.divide(-2147483648, 2));
    }
}
