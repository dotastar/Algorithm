package com.cc150.ArraysAndStrings;

/**
 * Write a method to replace all spaces in a string with ‘%20’. You may assume that the string has sufficient space at the end of the string to hold the additional characters.
 * and that you are given the "true" length of the string. (Note: if implement in Java, please use a character array so that you can perform this operation in place).
 *
 * Example:
 * Input:  "Mr John Smith    "
 * Output: "Mr%20John%20Smith"
 */
public class ReplaceSpace {
    public static void replaceFun(char[] str, int length){
        int spaceCount = 0;
        for(int i = 0; i < length; i++){
            if(str[i] == ' ') spaceCount++;
        }

        int newLength = length + 2 * spaceCount;
        int end = newLength - 1;
        for(int i = length - 1; i >= 0; i--){
            if(str[i] == ' '){
                str[end--] = '0';
                str[end--] = '2';
                str[end--] = '%';
            }else{
                str[end--] = str[i];
            }
        }
    }

    public static void main(String[] args){
        String s = "Mr John Smith    ";
        char[] str = s.toCharArray();
        replaceFun(str, 13);
        System.out.println(new String(str));
    }
}
