package com.cc150.ArraysAndStrings;

/**
 * Reverse a String
 */
public class ReverseString {
    /**
     * String is immutable, you can't do it in place!
     */
    public static String reverse(String str){
        StringBuilder result = new StringBuilder();
        for(int i = str.length() - 1; i >= 0; i--){
            result.append(str.charAt(i));
        }
        return result.toString();
    }

    public static void main(String[] args){
        System.out.print(reverse("Xiaomeng"));
    }
}
