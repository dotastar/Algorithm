package com.leetcode.arithmetic;

/**
 * Divide two integers without using multiplication, division and mod operator.
 *
 * Reference: http://www.lifeincode.net/programming/leetcode-divide-two-integers-java/
 *
 * Created by Xiaomeng on 9/5/2014.
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if(dividend == 0) return 0;
        if(divisor == 1) return dividend;

        long p = Math.abs((long)dividend);
        long q = Math.abs((long)divisor);

        int quotient = 0;
        while(p >= q){
            int count = 0;
            while(p >= (q << count)){
                count++;
            }
            quotient += 1 << (count - 1);
            p -= q << (count - 1);
        }

        if((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)){
            return -quotient;
        }else{
            return quotient;
        }
    }

    public static void main(String[] args){
        DivideTwoIntegers test = new DivideTwoIntegers();
        System.out.println(test.divide(-2147483648, 2));
    }
}
