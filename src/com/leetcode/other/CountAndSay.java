package com.leetcode.other;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 *
 * 1, 11, 21, 1211, 111221, ...
 *
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 *
 * Given an integer n, generate the nth sequence.
 *
 * Note: The sequence of integers will be represented as a string.
 *
 * Created by Xiaomeng on 9/1/2014.
 */
public class CountAndSay {
    public String countAndSay(int n) {
        String s = "1";
        if(n == 1) return s;
        for(int i = 1; i < n; i++){
            s = getNext(s);
        }
        return s;
    }

    public String getNext(String num){
        StringBuilder result = new StringBuilder();
        int i = 0;
        while(i < num.length()){
            int count = 1;
            while(i + 1 < num.length()){
                if(num.charAt(i) != num.charAt(i + 1)) break;
                count++;
                i++;
            }
            result.append(count);
            result.append(num.charAt(i));
            i++;
        }
        return result.toString();
    }

    public static void main(String[] args){
        CountAndSay test = new CountAndSay();
        System.out.println(test.getNext("21"));
        System.out.println(test.countAndSay(5));
    }
}
