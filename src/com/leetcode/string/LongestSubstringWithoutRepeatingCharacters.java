package com.leetcode.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 *
 * Created by Xiaomeng on 9/6/2014.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    /*
    * Check to see if there is a better solution
    * */
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        for(int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                max = Math.max(max, map.size());
                i = map.get(s.charAt(i));
                map.clear();
            }else{
                map.put(s.charAt(i), i);
            }
        }
        max = Math.max(max, map.size());
        return max;
    }

    public static void main(String[] args){
        LongestSubstringWithoutRepeatingCharacters test = new LongestSubstringWithoutRepeatingCharacters();
        String s = "abcaefg";
        System.out.println(test.lengthOfLongestSubstring(s));
    }
}
