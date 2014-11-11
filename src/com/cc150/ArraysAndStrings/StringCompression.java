package com.cc150.ArraysAndStrings;

/**
 * Implement a method to perform basic string compression using the counts of repeated characters.
 * For example, the string aabcccccaaa would become a2b1c5a3.
 * If the "compressed" string would not become smaller than the original string, your method should return the original string.
 *
 */
public class StringCompression {
    public static String compressString(String str){
        StringBuilder compressedStr = new StringBuilder();
        int i = 0;
        while(i < str.length()){
            int count = 1;
            while(i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1)){
                count++;
                i++;
            }
            compressedStr.append(str.charAt(i));
            compressedStr.append(count);
            i++;
        }
        if(compressedStr.length() < str.length())
            return compressedStr.toString();
        else
            return str;
    }

    public static void main(String[] args){
//        String str = "aabcccccaaa";
        String str = "aabbccdefgh";
        System.out.println(compressString(str));
    }
}
