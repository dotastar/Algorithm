package com.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 *  Given a string s, partition s such that every substring of the partition is a palindrome.
 *
 *  Return all possible palindrome partitioning of s.
 *
 *  For example, given s = "aab",
 *  Return
 *
 *  [
 *      ["aa","b"],
 *      ["a","a","b"]
 *  ]
 *
 *  Created by Xiaomeng on 9/9/2014.
 */
public class PalindromePartitioning {
    List<List<String>> result;
    List<String> single;

    public List<List<String>> partition(String s) {
        result = new ArrayList<List<String>>();
        single = new ArrayList<String>();
        partition(s, 0);
        return result;
    }

    public void partition(String s, int index){
        if(index == s.length()){
            result.add(new ArrayList<String>(single));
            return;
        }
        for(int i = index + 1; i <= s.length(); i++){
            String sub = s.substring(index, i);
            if(isPalindrome(sub)){
                single.add(sub);
                partition(s, i);
                single.remove(single.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s){
        if(s.trim().isEmpty()) return true;
        int start = 0, end = s.length() - 1;
        while(start < end){
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args){
        String s = "aab";
        PalindromePartitioning test = new PalindromePartitioning();
        for(List<String> single : test.partition(s)){
            System.out.println(single);
        }
    }
}
