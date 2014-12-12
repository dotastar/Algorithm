package com.cc150.StacksAndQueues;

import com.leetcode.core.ListNode;

import java.util.NoSuchElementException;

/**
 *
 */
public class MyStack<T> {
    private Node<T> top;

    public void push(T val){
        Node node = new Node(val);
        node.next = top;
        top = node;
    }

    public T pop(){
        if(top != null){
            T val = top.val;
            top = top.next;
            return val;
        }
        return null;
    }

    public T peek(){
        return top.val;
    }


}
