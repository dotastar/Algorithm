package com.leetcode.dp;

import java.util.*;

/**
 *  Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:
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
 *  Return
 *
 *  [
 *      ["hit","hot","dot","dog","cog"],
 *      ["hit","hot","lot","log","cog"]
 *  ]
 *
 *  Note:
 *  All words have the same length.
 *  All words contain only lowercase alphabetic characters.
 *
 *  Created by Xiaomeng on 9/15/2014.
 */
public class WordLadder2 {
    Queue<String> queue;
    List<List<String>> result;
    Map<String, List<String>> map;
    List<String> single;

    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        result = new ArrayList<List<String>>();
        single = new ArrayList<String>();
        if(start.equals(end)){
            single.add(start);
            single.add(end);
            result.add(single);
            return result;
        }

        map = new HashMap<String, List<String>>();
        for(String word : dict){
            map.put(word, new ArrayList<String>());
        }
        map.put(start, new ArrayList<String>());
        map.put(end, new ArrayList<String>());

        queue = new LinkedList<String>();
        queue.offer(start);
        List<String> currentLevel = new ArrayList<String>();
        while(!queue.isEmpty()){
            int size = queue.size();
            currentLevel.clear();
            for(int i = 0; i < size; i++){
                String top = queue.poll();
                if(dict.contains(top)) dict.remove(top);
                currentLevel.add(top);
            }

            for(String s : currentLevel){
                for(int j = 0; j < s.length(); j++){
                    for(char c = 'a'; c <= 'z'; c++){
                        if(s.charAt(j) == c) continue;
                        String tmp = replace(s, j, c);
                        if(tmp.equals(end)){
                            map.get(end).add(s);
                            queue.offer(tmp);
                        }else if(dict.contains(tmp)){
                            if(!queue.contains(tmp)) queue.offer(tmp);
                            map.get(tmp).add(s);
                        }
                    }
                }
            }
            if(queue.contains(end))
                break;
        }
        single.add(end);
        buildPath(start, end);
        return result;
    }

    private void buildPath(String start, String end){
        if(end.equals(start)){
            List<String> tmp = new ArrayList<String>(single);
            Collections.reverse(tmp);
            result.add(tmp);
            return;
        }

        for(String s : map.get(end)){
            single.add(s);
            buildPath(start, s);
            single.remove(single.size() - 1);
        }
    }

    private String replace(String s, int index, char c){
        char[] arr = s.toCharArray();
        arr[index] = c;
        return new String(arr);
    }

    public static void main(String[] args){
        WordLadder2 wordLadder = new WordLadder2();
        String start = "hot";
        String end = "dot";
        HashSet<String> dict = new HashSet<String>();
        dict.add("hot");
        dict.add("dot");
        dict.add("dog");

        for(List<String> single : wordLadder.findLadders(start, end, dict)){
            System.out.println(single);
        }
    }
}
