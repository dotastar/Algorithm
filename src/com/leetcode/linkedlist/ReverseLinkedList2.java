package com.leetcode.linkedlist;

import com.leetcode.core.ListNode;

/**
 *  Reverse a linked list from position m to n. Do it in-place and in one-pass.
 *
 *  For example:
 *  Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 *
 *  return 1->4->3->2->5->NULL.
 *
 *  Note:
 *  Given m, n satisfy the following condition:
 *  1 ≤ m ≤ n ≤ length of list.
 *
 *  Created by Xiaomeng on 7/14/2014.
 */
public class ReverseLinkedList2 {
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null || m - n == 0) return head;

        ListNode left = new ListNode(-1);
        left.next = head;
        for(int i = 1; i < m; i++) left = left.next;

        ListNode rHead = left.next;
        ListNode prev = rHead;
        ListNode curr = prev.next;
        ListNode next = curr.next;
        int step = n - m;

        while(next != null && step != 1){
            curr.next = prev;
            prev = curr;
            curr = next;
            next = curr.next;
            step--;
        }
        curr.next = prev;
        left.next = curr;
        rHead.next = next;

        return m == 1 ? curr : head;
    }

    public static void main(String[] args){
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(4);
        l.next.next.next.next = new ListNode(5);
        l.display();

        ListNode n = reverseBetween(l, 1, 4);
        n.display();
    }
}
