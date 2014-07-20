package com.leetcode.linkedlist;

import com.leetcode.core.ListNode;

/**
 *  Given a linked list, swap every two adjacent nodes and return its head.
 *
 *  For example,
 *  Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 *  Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 *
 *  Created by Xiaomeng on 7/19/2014.
 */
public class SwapNodesInPairs {
    public static ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode first = head, second = head.next, next = second.next;
        second.next = first;
        first.next = swapPairs(next);
        return second;
    }

    public static void main(String[] args){
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(4);
        l.next.next.next.next = new ListNode(5);
        l.next.next.next.next.next = new ListNode(6);
        l.display();

        swapPairs(l).display();
    }
}
