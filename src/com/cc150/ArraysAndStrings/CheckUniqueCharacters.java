package com.cc150.ArraysAndStrings;

import java.util.HashSet;
import java.util.Set;

/**
 * Implement an algorithm to determine if a string has all unique characters.
 *
 * What if you cannot use additional data structures.
 *
 */
public class CheckUniqueCharacters {
    /**
     * Time O(n), Space O(n)
     */
    public static boolean hasUniqueCharacters1(String str){
        Set<Character> set = new HashSet<Character>();
        for(Character ch : str.toCharArray()){
            if(set.contains(ch)){
                return false;
            }else{
                set.add(ch);
            }
        }
        return true;
    }

    /**
     * Assume char set is ASCII
     * Time O(n), Space O(1)
     */
    public static boolean hasUniqueCharacters2(String str){
        boolean[] char_set = new boolean[256];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (char_set[val]) return false;
            char_set[val] = true;
        }
        return true;
    }

    /**
     * Assume string only has lower-case characters from A to Z
     * Time O(n), Space O(1)
     */
    public static boolean hasUniqueCharacters3(String str) {
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) return false;
            checker |= (1 << val);
        }
        return true;
    }
}
