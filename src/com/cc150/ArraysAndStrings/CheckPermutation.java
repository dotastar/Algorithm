package com.cc150.ArraysAndStrings;

import java.util.Arrays;

/**
 * Given two strings, write a method to decide if one is permutation of the other
 *
 */
public class CheckPermutation {
    /**
     * Sort: O(nlogn)
     */
    public static boolean permutation1(String s, String t){
        if(s.length() != t.length()) return false;
        return sort(s).equals(sort(t));
    }

    public static String sort(String s){
        char[] sArr = s.toCharArray();
        Arrays.sort(sArr);
        return new String(sArr);
    }

    /**
     * Assume char set is ASCII
     * Time O(n), Space O(1)
     */
    public static boolean permutation2(String s, String t){
        if(s.length() != t.length()) return false;
        int[] letters = new int[256];
        for(char ch : s.toCharArray()){
            letters[ch]++;
        }

        for(char ch : t.toCharArray()){
            if(--letters[ch] < 0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println("apple" + ", " + "papel" + ": " +   permutation1("apple", "papel"));
        System.out.println("carrot" + ", " + "tarroc" + ": " + permutation1("carrot", "tarroc"));
        System.out.println("hello" + ", " + "llloh" + ": " +   permutation1("hello", "llloh"));
    }
}
