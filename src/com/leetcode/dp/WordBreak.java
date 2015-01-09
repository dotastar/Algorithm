package com.leetcode.dp;

import java.util.HashSet;
import java.util.Set;

/**
 *  Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 *  For example, given
 *  s = "leetcode",
 *  dict = ["leet", "code"].
 *
 *  Return true because "leetcode" can be segmented as "leet code".
 *
 *  Created by Xiaomeng on 9/10/2014.
 */
public class WordBreak {
    /*
    * DFS: O(2^n)
    * */
    public boolean wordBreak(String s, Set<String> dict) {
        if(s == null || s.isEmpty()) return false;
        return wordBreak(s, dict, 0);
    }

    public boolean wordBreak(String s, Set<String> dict, int index){
        if(index == s.length()) return true;

        for(String word : dict){
            if(index + word.length() <= s.length()){
                String sub = s.substring(index, index + word.length());
                if(sub.equals(word)){
                    if(wordBreak(s, dict, index + word.length()))
                        return true;
                }
            }
        }
        return false;
    }

    /*
    * DFS: O(2^n)
    * */
    public boolean wordBreak2(String s, Set<String> dict) {
        if(s.length() == 0) return true;
        for(int i = 1; i <= s.length(); i++){
            String sub = s.substring(0, i);
            if(dict.contains(sub) && wordBreak2(s.substring(i), dict)) return true;
        }
        return false;
    }

    /*
    * DP: O(mn)
    * */
    public boolean wordBreak3(String s, Set<String> dict) {
        boolean[] memo = new boolean[s.length() + 1];
        memo[0] = true;
        for(int i = 0; i < s.length(); i++){
            if(memo[i]){
                for(String word : dict){
                    if(word.length() + i <= s.length()){
                        String sub = s.substring(i, i + word.length());
                        if(sub.equals(word)){
                            memo[i + word.length()] = true;
                        }
                    }
                }
            }
        }
        return memo[s.length()];
    }

    /*
    * DP: O(n ^ 2)
    * http://blog.csdn.net/linhuanmars/article/details/22358863 -- good explanation about DP!
    *
    * */
    public boolean wordBreak4(String s, Set<String> dict) {
        int len = s.length();
        boolean[] memo = new boolean[len + 1];
        memo[0] = true;
        for(int i = 1; i <= len; i++){
            for(int j = 0; j < i; j++){
                if(memo[j] && dict.contains(s.substring(j, i))){
                    memo[i] = true;
                    break;
                }
            }
        }
        return memo[len];
    }

    public static void main(String[] args){
        String s = "abcd";
        Set<String> dict = new HashSet<String>();
        dict.add("a");
        dict.add("abc");
        dict.add("b");
        dict.add("cd");
        WordBreak test = new WordBreak();
        System.out.println(test.wordBreak2(s, dict));
    }
}
