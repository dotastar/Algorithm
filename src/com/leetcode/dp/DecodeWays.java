package com.leetcode.dp;

/**
 *  A message containing letters from A-Z is being encoded to numbers using the following mapping:
 *
 *  'A' -> 1
 *  'B' -> 2
 *  ...
 *  'Z' -> 26
 *
 *  Given an encoded message containing digits, determine the total number of ways to decode it.
 *
 *  For example,
 *  Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 *
 *  The number of ways decoding "12" is 2.
 *
 *  Created by Xiaomeng on 9/9/2014.
 */
public class DecodeWays {
    public int numDecodings(String s) {
        if(s.trim().isEmpty()) return 0;

        int[] memo = new int[s.length()];
        if(isValid(s.substring(0, 1))) memo[0] = 1;
        if(s.length() == 1) return memo[0];
        if(isValid(s.substring(1, 2))) memo[1] += memo[0];
        if(isValid(s.substring(0, 2))) memo[1]++;

        for(int i = 2; i < s.length(); i++){
            if(isValid(s.substring(i, i + 1))){
                memo[i] += memo[i - 1];
            }

            if(isValid(s.substring(i - 1, i + 1))){
                memo[i] += memo[i - 2];
            }
        }
        return memo[s.length() - 1];
    }

    public boolean isValid(String s){
        if(s.trim().isEmpty()) return false;
        if(s.charAt(0) == '0') return false;
        if(s.length() == 2){
            String sub = s.substring(0, 2);
            int num = Integer.parseInt(sub);
            if(num > 26 || num < 1) return false;
        }
        return true;
    }

    /**
     * Recursive solution: not verified
     */
    public int numDecodings2(String s) {
        return numDecodings2(s, 0);
    }

    public int numDecodings2(String s, int index){
        if(index >= s.length()){
            return 1;
        }

        int count = 0;
        int digit = Character.getNumericValue(s.charAt(index));
        if(digit >= 1 && digit <= 26){
            count += numDecodings2(s, index + 1);
        }

        if(index + 1 < s.length()){
            String sub = s.substring(index, index + 2);
            digit = Integer.parseInt(sub);
            if(digit >= 10 && digit <= 26){
                count += numDecodings2(s, index + 2);
            }
        }
        return count;
    }

    public static void main(String[] args){
        DecodeWays test = new DecodeWays();
        System.out.println(test.numDecodings("01"));
    }
}
