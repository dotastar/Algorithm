package com.leetcode.dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *  Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
 *
 *  Return all such possible sentences.
 *
 *  For example, given
 *  s = "catsanddog",
 *  dict = ["cat", "cats", "and", "sand", "dog"].
 *
 *  A solution is ["cats and dog", "cat sand dog"].
 *
 *  Created by Xiaomeng on 9/10/2014.
 */
public class WordBreak2 {
    List<String> result;
    StringBuilder single;

    /*
    *
    * DFS Solution: TLE
    *
    * */
    public List<String> wordBreak(String s, Set<String> dict) {
        result = new ArrayList<String>();
        single = new StringBuilder();
        wordBreak(s, dict, 0);
        return result;
    }

    public void wordBreak(String s, Set<String> dict, int index){
        if(index ==  s.length()){
            result.add(single.toString());
            return;
        }

        for(String word : dict){
            if(index + word.length() <= s.length()){
                String sub = s.substring(index, index + word.length());
                if(sub.equals(word)){
                    single.append(word);
                    if(index + word.length() != index) single.append(" ");
                    wordBreak(s, dict, index + word.length());
                    if(index + word.length() != index) single.deleteCharAt(single.length() - 1);
                    single.delete(index, index + word.length());
                }
            }
        }
    }

    /*
    *
    * DP Solution
    *
    * */
    public List<String> wordBreak2(String s, Set<String> dict) {
        result = new ArrayList<String>();
        single = new StringBuilder();
        List<List<Integer>> memo = new ArrayList<List<Integer>>();
        for(int i = 0; i < s.length() + 1; i++){
            memo.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < s.length(); i++){
            if(i != 0 && memo.get(i).size() == 0) continue;
            for(String word : dict){
                int end = i + word.length();
                if(end <= s.length()){
                    String sub = s.substring(i, end);
                    if(sub.equals(word)){
                        memo.get(end).add(i);
                    }
                }
            }
        }
        wordBreak2(s, s.length(), memo);
        return result;
    }

    public void wordBreak2(String s, int curr, List<List<Integer>> memo){
        if(curr == 0){
            result.add(single.toString());
            return;
        }
        for(int p : memo.get(curr)){
            String sub = s.substring(p, curr);
            if(curr != s.length()) single.insert(0, " ");
            single.insert(0, sub);
            wordBreak2(s, p, memo);
            if(curr != s.length()) single.deleteCharAt(0);
            single.delete(0, curr - p);

        }
    }

    /**
     * DFS: TLE
     *
     */
    public List<String> wordBreak3(String s, Set<String> dict) {
        List<String> result = new ArrayList<String>();
        StringBuilder single = new StringBuilder();
        wordBreak3(s, 0, dict, single, result);
        return result;
    }

    public void wordBreak3(String s, int index, Set<String> dict, StringBuilder single, List<String> result){
        if(index == s.length()){
            result.add(single.toString());
            return;
        }

        for(int i = index + 1; i <= s.length(); i++){
            String sub = s.substring(index, i);
            if(dict.contains(sub)){
                single.append(sub);
                if(i != s.length()) single.append(" ");
                wordBreak3(s, i, dict, single, result);
                if(i != s.length()) single.deleteCharAt(single.length() - 1);
                single.delete(single.length() - sub.length(), single.length());
            }
        }
    }

    public static void main(String[] args){
        WordBreak2 test = new WordBreak2();
        String s = "catsanddog";
        Set<String> dict = new HashSet<String>();
        dict.add("cat");
        dict.add("cats");
        dict.add("and");
        dict.add("sand");
        dict.add("dog");
        System.out.println(test.wordBreak2(s, dict));
    }
}
