package com.misc;


import com.leetcode.core.Trie;
import com.leetcode.core.TrieNode;

import java.util.*;

/**
 * Created by Xiaomeng on 10/9/2014.
 */
public class Test{
    public static String getJson(String input){
        String[] lines = input.split("\n");
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        for(int i = 0; i < lines.length; i++){
            String[] tokens = lines[i].split("\\|");
            Map<String, String> map = new HashMap<String, String>();
            map.put("name", tokens[0]);
            map.put("address", tokens[1]);
            map.put("phone", tokens[2]);
            map.put("job", tokens[3]);
            list.add(map);
        }


        for(Map<String, String> map : list){
            Iterator it = map.entrySet().iterator();
            System.out.println("{");
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry)it.next();
                System.out.print(entry.getKey() + ":" + entry.getValue());
                if(it.hasNext()) System.out.print(",");
            }
            System.out.println("}");
        }
        return null;
    }

    public static void main(String[] args){

        String input = "xiamoeng|newport|631|BlackRock\n" +
                       "xiaolu|newport|121|ICBC\n";

        getJson(input);
        String output = "{" +
                "{name:xiaomeng, address:newport,phone:631, job:BlackRock}," +
                "{name:xiaomeng, address:newport,phone:631, job:BlackRock}"  +
                "}";
    }

}
