package com.leetcode.string;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * Created by Xiaomeng on 9/2/2014.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        int i = 0;
        for(; i < strs[0].length(); i++){
            char c = strs[0].charAt(i);
            for(int j = 1;j < strs.length; j++){
                if(i >= strs[j].length() || strs[j].charAt(i) != c) return strs[0].substring(0,i);
            }
        }
        return strs[0].substring(0,i);
    }

    public static void main(String[] args){
        LongestCommonPrefix test = new LongestCommonPrefix();
        String[] strs = {""};
        System.out.println(test.longestCommonPrefix(strs));
    }
}
