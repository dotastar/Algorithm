package com.leetcode.other;

/**
 * Implement atoi to convert a string to an integer.
 *
 * Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.
 *
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
 *
 * Requirements for atoi:
 *
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found.
 * Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
 * The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 * If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 *
 * Created by Xiaomeng on 9/9/2014.
 */
public class StringToInteger {
    public int atoi(String str) {
        if(str.trim().isEmpty()) return 0;
        str = str.trim();
        boolean positive = true;
        long result = 0;
        for(int i = 0; i < str.length(); i++){
            if(i == 0 && (str.charAt(i) == '+' || str.charAt(i) == '-')){
                if(str.charAt(i) == '-') positive = false;
                else if(str.charAt(i) == '+') positive = true;
            }else if(str.charAt(i) >= 48 && str.charAt(i) <= 57){
                result = 10 * result + str.charAt(i) - 48;
            }else{
                break;
            }
        }
        result = positive ? result : -result;
        if(result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        else if(result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        else
            return (int)result;
    }

    public static void main(String[] args){
        StringToInteger test = new StringToInteger();
        String str = "-321";
        System.out.println(test.atoi(str));
    }
}
