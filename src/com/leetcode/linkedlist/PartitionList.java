package com.leetcode.linkedlist;

import com.leetcode.core.ListNode;

/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 *
 * You should preserve the original relative order of the nodes in each of the two partitions.
 *
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 *
 * Created by Xiaomeng on 7/14/2014.
 */
public class PartitionList {
    public static ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) return head;

        ListNode first = new ListNode(-1);
        ListNode second = new ListNode(-1);
        ListNode firstHead = first, secondHead = second;

        while(head != null){
            if(head.val < x){
                first.next = new ListNode(head.val);
                first = first.next;
            }else{
                second.next = new ListNode(head.val);
                second = second.next;
            }
            head = head.next;
        }
        first.next = secondHead.next;
        return firstHead.next;
    }

    public static void main(String[] args){
        ListNode l = new ListNode(1);
        l.next = new ListNode(4);
        l.next.next = new ListNode(3);
        l.next.next.next = new ListNode(2);
        l.next.next.next.next = new ListNode(5);
        l.next.next.next.next.next = new ListNode(2);
        l.display();

        ListNode n = partition(l, 3);
        n.display();
    }
}
