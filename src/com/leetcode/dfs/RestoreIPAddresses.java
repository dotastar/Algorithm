package com.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 *
 * For example:
 * Given "25525511135",
 *
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 *
 * Created by Xiaomeng on 9/8/2014.
 */
public class RestoreIPAddresses {
    /**
     * IP address standard:
     * each section >= 0 and <= 255
     * each section with only 0 is legal
     * each section with more than 1 digits, the first digit cannot be 0;
     *
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        StringBuilder single = new StringBuilder();
        restoreIpAddresses(s, result, single, 0, 1);
        return result;
    }

    public void restoreIpAddresses(String s, List<String> result, StringBuilder single, int index, int step){
        if(step > 5 || index > s.length()) return;
        if(step == 5 && index == s.length()){
            result.add(single.toString());
            return;
        }

        for(int i = 1; i <= 3 && index + i <= s.length(); i++){
            String sub = s.substring(index, index + i);
            if(i > 1 && sub.charAt(0) == '0') continue;
            int section = Integer.parseInt(sub);
            if(section >= 0 && section <= 255){
                single.append(sub);
                if(step < 4) single.append(".");
                restoreIpAddresses(s, result, single, index + i, step + 1);
                if(step < 4) single.deleteCharAt(single.length() - 1);
                single.delete(single.length() - i, single.length());
            }
        }
    }

    public static void main(String[] args){
        RestoreIPAddresses test= new RestoreIPAddresses();
        String s = "0000";
        System.out.println(test.restoreIpAddresses(s));
    }
}
