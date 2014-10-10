package com.leetcode.other;

import java.util.Stack;

/**
 * Given an absolute path for a file (Unix-style), simplify it.
 *
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 *
 *
 * Corner Cases:
 *
 * Did you consider the case where path = "/../"?
 * In this case, you should return "/".
 * Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
 * In this case, you should ignore redundant slashes and return "/home/foo".
 *
 * Created by Xiaomeng on 9/6/2014.
 */
public class SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<String>();
        for(String command : path.split("/")){
            if(command.equals(".") || command.equals("")){
                continue;
            }else if(command.equals("..")){
                if(!stack.isEmpty()) stack.pop();
            }else{
                stack.push("/" + command);
            }
        }

        if(stack.isEmpty()){
            return "/";
        }

        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()){
            result.insert(0, stack.pop());
        }
        return result.toString();
    }

    public static void main(String[] args){
        SimplifyPath test = new SimplifyPath();
        String path = "/home//foo/";
        System.out.println(test.simplifyPath(path));
    }
}
