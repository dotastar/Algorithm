package com.cc150.StacksAndQueues;

import java.util.Stack;

/**
 * Created by Xiaomeng on 12/12/2014.
 */
public class MinStack2 extends Stack<Integer>{
    private Stack<Integer> s2;

    public MinStack2(){
        s2 = new Stack<Integer>();
    }

    public void push(int value){
        if(value <= min()){
            s2.push(value);
        }
        super.push(value);
    }

    public Integer pop(){
        int value = super.pop();
        if(value == min()){
            s2.pop();
        }
        return value;
    }

    public int min(){
        if(s2.isEmpty()){
            return Integer.MAX_VALUE;
        }else{
            return s2.peek();
        }
    }

    public static void main(String[] args){
        MinStack2 stack = new MinStack2();
        stack.push(3);
        stack.push(4);
        stack.push(2);
        stack.push(5);
        System.out.println(stack.min());
    }
}
