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

    /**
     *
     * Sample:
     *            tad
     *          /     \
     *       ted        tax
     *     /    \     /
     * red        tex
     *     \    /
     *       rex
     *
     * WordLadder1:
     * Since we only need to calculate the shortest length, we don't care the case that both 'ted' and 'rex' will be transformed to the same 'tex'.
     * Hence, for performance purpose, we just remove 'tex' in dictionary when transforming 'ted' to 'tex',
     * in which case, when considering 'rex', we don't even need to perform any operations give 'tex' is already removed from the dict.
     *
     * WordLadder2:
     * Since we need to track down each shortest path, we can't remove the 'tex' when mapping 'ted' as we still need to track down 'rex';
     * So, we remove both 'ted' and 'rex' in one shot in the next loop.
     *
     */
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        dict.add(start);
        dict.add(end);
        for(String word : dict){
            map.put(word, new ArrayList<String>());
        }

        Queue<String> queue = new LinkedList<String>();
        queue.add(start);
        List<String> currLevel = new ArrayList<String>();
        while(!queue.isEmpty()){
            int size = queue.size();
            currLevel.clear();
            for(int i = 0; i < size; i++){
                String s = queue.poll();
                dict.remove(s);
                currLevel.add(s);
            }

            for(String word : currLevel){
                for(int i = 0; i < word.length(); i++){
                    for(char ch = 'a'; ch <= 'z'; ch++){
                        if(word.charAt(i) == ch) continue;
                        String tmp = convert(word, i, ch);
                        if(dict.contains(tmp)){
                            if(!queue.contains(tmp)) queue.add(tmp);
                            map.get(tmp).add(word);
                        }
                    }
                }
            }
            if(queue.contains(end)) break;
        }

        List<List<String>> result = new ArrayList<List<String>>();
        List<String> single = new ArrayList<String>();
        single.add(end);
        buildPath(start, end, map, single, result);
        return result;
    }

    public void buildPath(String start, String end, Map<String, List<String>> map, List<String> single, List<List<String>> result){
        if(end.equals(start)){
            result.add(new ArrayList<String>(single));
            return;
        }

        for(String s : map.get(end)){
            single.add(0, s);
            buildPath(start, s, map, single, result);
            single.remove(0);
        }
    }

    public String convert(String word, int index, char ch){
        char[] arr = word.toCharArray();
        arr[index] = ch;
        return new String(arr);
    }

    public static void main(String[] args){
        WordLadder2 wordLadder = new WordLadder2();
        String start = "red";
        String end = "tax";
        HashSet<String> dict = new HashSet<String>();
        dict.add("ted");
        dict.add("tex");
        dict.add("red");
        dict.add("tax");
        dict.add("tad");
        dict.add("rex");

        for(List<String> single : wordLadder.findLadders(start, end, dict)){
            System.out.println(single);
        }
    }
}
