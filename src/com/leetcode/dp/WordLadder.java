package com.leetcode.dp;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 *  Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:
 *
 *  Only one letter can be changed at a time
 *  Each intermediate word must exist in the dictionary
 *
 *  For example,
 *
 *  Given:
 *  start = "hit"
 *  end = "cog"
 *  dict = ["hot","dot","dog","lot","log"]
 *
 *  As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 *  return its length 5.
 *
 *  Note:
 *
 *  Return 0 if there is no such transformation sequence.
 *  All words have the same length.
 *  All words contain only lowercase alphabetic characters.
 *
 *  Created by Xiaomeng on 9/14/2014.
 */
public class WordLadder {
    int min = Integer.MAX_VALUE;
    Queue<String> queue;
    int curr, next;

    /*
    * BFS
    * Reference: http://shanjiaxin.blogspot.com/2014/04/word-ladder-leetcode.html
    * Understand the multiple ways to BFS using queues
    * */
    public int ladderLength3(String start, String end, Set<String> dict) {
        queue = new LinkedList<String>();
        queue.add(start);
        dict.add(end);
        int step = 1;
        while(!queue.isEmpty()){
            int count = queue.size();
            for(int j = 0; j < count; j++){
                String s = queue.poll();
                for(int i = 0; i < s.length(); i++){
                    for(char c = 'a'; c <= 'z'; c++){
                        if(c == s.charAt(i)) continue;
                        String tmp = replace(s, i, c);
                        if(tmp.equals(end)){
                            return step + 1;
                        }

                        if(dict.contains(tmp)){
                            queue.add(tmp);
                            dict.remove(tmp);
                        }
                    }
                }
            }
            step++;
        }
        return 0;
    }

    private String replace(String s, int index, char c) {
        char[] chars = s.toCharArray();
        chars[index] = c;
        return new String(chars);
    }

    /*
    * BFS
    * Better solution: http://shanjiaxin.blogspot.com/2014/04/word-ladder-leetcode.html
    * */
    public int ladderLength2(String start, String end, Set<String> dict) {
        queue = new LinkedList<String>();
        queue.add(start);
        dict.add(end);
        int step = 1;
        while(!queue.isEmpty()){
            int count = queue.size();
            for(int i = 0; i < count; i++){
                String s = queue.poll();
                Set<String> tmpRemove = new HashSet<String>();
                for(String word : dict){
                    if(canTransform(s, word)){
                        if(word.equals(end)){
                            return step + 1;
                        }else{
                            queue.add(word);
                            tmpRemove.add(word);
                        }
                    }
                }
                dict.remove(tmpRemove);
            }
            step++;
        }
        return 0;
    }


    /*
    * DFS: TLE
    * */
    public int ladderLength(String start, String end, Set<String> dict) {
        dict.add(end);
        ladderLength(start, end, dict, 1);
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public void ladderLength(String start, String end, Set<String> dict, int len){
        if(start.equals(end)){
            min = len < min ? len : min;
            return;
        }

        for(String word : dict){
            if(canTransform(start, word)){
                Set<String> tmp = new HashSet<String>(dict);
                tmp.remove(word);
                ladderLength(word, end, tmp, len + 1);
            }
        }
    }

    public boolean canTransform(String a, String b){
        if(a.length() != b.length()) return false;
        int diff = 0;
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) != b.charAt(i)) diff++;
        }
        return diff == 1;
    }

    public static void main(String[] args){
        WordLadder test = new WordLadder();
        String start = "hit";
        String end = "cog";
        Set<String> dict = new HashSet<String>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");
        dict.add("lot");
        dict.add("log");
        System.out.println(test.ladderLength2(start, end, dict));

    }
}
