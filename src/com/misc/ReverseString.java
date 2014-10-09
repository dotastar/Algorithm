package com.misc;

/**
 * Created by Xiaomeng on 10/9/2014.
 */
public class ReverseString {
    public static String reverse(String s){
        char[] charArr = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        while(start < end){
            char tmp = charArr[start];
            charArr[start] = charArr[end];
            charArr[end] = tmp;
            start++;
            end--;
        }
        return new String(charArr);
    }

    public static void main(String[] args){
        System.out.println(reverse("a"));
    }
}
