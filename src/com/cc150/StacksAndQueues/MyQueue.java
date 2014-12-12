package com.cc150.StacksAndQueues;

/**
 * Created by Xiaomeng on 12/12/2014.
 */
public class MyQueue<T> {
    private Node<T> first;
    private Node<T> last;

    public void enqueue(T val){
        Node<T> node = new Node<T>(val);
        if(last == null){
            first = node;
            last = node;
        }else{
            last.next = node;
            last = node;
        }
    }

    public T dequeue(){
        if(first == null){
            return null;
        }else{
            T val = first.val;
            first = first.next;
            return val;
        }
    }
}
