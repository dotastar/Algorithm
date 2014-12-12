package com.cc150.StacksAndQueues;

import java.util.Stack;

/**
 * Created by Xiaomeng on 12/12/2014.
 */
public class MinStack1 extends Stack<MinStack1.NodeWithMin>{

    public void push(int val){
        int newMin = Math.min(val, min());
        super.push(new NodeWithMin(val, newMin));
    }

    public int min(){
        if(isEmpty()){
            return Integer.MAX_VALUE;
        }else{
            return peek().min;
        }
    }

    public static class NodeWithMin{
        public int val;
        public int min;

        public NodeWithMin(int val, int min){
            this.val = val;
            this.min = min;
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
