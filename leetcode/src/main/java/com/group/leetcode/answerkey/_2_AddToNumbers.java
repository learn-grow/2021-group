package com.group.leetcode.answerkey;

/**
 * @author: lisy
 * @version: _2_AddToNumbers , v0.1 2021年01月26日 16:06
 * @remark：_2_AddToNumbers
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * 2 个逆序的链表，要求从低位开始相加，得出结果也逆序输出，返回值是逆序结果链表的头结点。
 */
public class _2_AddToNumbers {

    private ListNode addTwoNumbers(ListNode l1 , ListNode l2) {
        if (l1 == null || l2 == null) {
            return null;
        }
        ListNode head = new ListNode();
        ListNode current = head;
        int carrry = 0;
        while (l1 != null || l2 != null) {
            int x , y ;
            x = l1 == null ? 0 : l1.val;
            y = l2 == null ? 0 : l2.val;

        }
        return null;
    }
}


class ListNode{
    int val;
    ListNode next;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}