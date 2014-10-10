package com.leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  You are given a string, S, and a list of words, L, that are all of the same length.
 *  Find all starting indices of substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.
 *
 *  For example, given:
 *  S: "barfoothefoobarman"
 *  L: ["foo", "bar"]
 *
 *  You should return the indices: [0,9].
 *  (order does not matter).
 *
 *  Created by Xiaomeng on 9/14/2014.
 */
public class SubstringWithConcatenationAllWords {
    /*
    * Better solution exists
    * */
    public List<Integer> findSubstring(String S, String[] L) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(String word : L){
            if(!map.containsKey(word)){
                map.put(word, 0);
            }
            map.put(word, map.get(word) + 1);
        }

        List<Integer> result = new ArrayList<Integer>();
        int wordLen = L[0].length();
        int len = L.length * wordLen;

        for(int i = 0; i <= S.length() - len; i++){
            Map<String, Integer> copy = new HashMap<String, Integer>(map);
            String sub = S.substring(i, i + len);
            while (true){
                String word = sub.substring(0, wordLen);
                if(copy.containsKey(word)){
                    int count = copy.get(word) - 1;
                    if(count < 0) break;
                    copy.put(word, count);
                    sub = sub.substring(wordLen);
                    if(sub.isEmpty()){
                        result.add(i);
                        break;
                    }
                }else{
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args){
        SubstringWithConcatenationAllWords test = new SubstringWithConcatenationAllWords();
        String s = "barfoothefoobarman";
        String[] l = {"foo", "bar"};
        System.out.println(test.findSubstring(s, l));
    }
}
