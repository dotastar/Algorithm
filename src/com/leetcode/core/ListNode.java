package com.leetcode.core;

/**
 * Created by Xiaomeng on 5/22/2014.
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int val){
        this.val = val;
        next = null;
    }

    public void display(){
        ListNode head = this;
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
