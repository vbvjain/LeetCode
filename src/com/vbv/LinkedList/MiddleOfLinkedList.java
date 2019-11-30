package com.vbv.LinkedList;
/**
 * Date 30 Nov 2019
 * @author vaibhavjain
 *
 * https://leetcode.com/problems/middle-of-the-linked-list/
 */

public class MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode c = head;
        while(c!=null && c.next!=null){
            c = c.next.next;
            head = head.next;
        }
        return head;
    }

      public class ListNode {
          int val;
          ListNode next;
          ListNode(int x) { val = x; }
     }
}
