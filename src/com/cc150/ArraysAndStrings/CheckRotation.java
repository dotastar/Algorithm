package com.cc150.ArraysAndStrings;

/**
 * Assume you have a method isSubstring which checks if one word is a substring of another.
 * Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to isSubstring.
 * (i.e., “waterbottle” is a rotation of “erbottlewat”)
 *
 */
public class CheckRotation {
    public static boolean isRotation(String s1, String s2){
        if(s1.length() != s2.length()) return false;
        String concat = s2 + s2;
        return isSubString(s1, concat);
    }

    private static boolean isSubString(String s1, String s2){
        //Provided interface
        return true;
    }
}
