package com.leetcode.linkedlist;

import com.leetcode.core.ListNode;

/**
 *  Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 *  For example,
 *  Given 1->1->2, return 1->2.
 *  Given 1->1->2->3->3, return 1->2->3.
 *
 *  Created by Xiaomeng on 7/12/2014.
 */
public class RemoveDuplicates {
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;

        ListNode first = head;
        ListNode second = first.next;

        while(second != null){
            if(first.val == second.val){
                second = second.next;
                first.next = second;
            }else{
                first = first.next;
                second = second.next;
            }
        }
        return head;
    }

    public static void main(String[] args){
        ListNode l = new ListNode(1);
        l.next = new ListNode(1);
        l.next.next = new ListNode(2);
        l.next.next.next = new ListNode(3);
        l.next.next.next.next = new ListNode(3);
        l.display();

        ListNode n = deleteDuplicates(l);
        n.display();
    }
}
