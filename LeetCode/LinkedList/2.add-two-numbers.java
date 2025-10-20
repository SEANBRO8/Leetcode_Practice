package LinkedList;
/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode p1 = l1, p2 = l2;
        ListNode p = dummy;


        int carry = 0;
        while(p1 != null || p2 != null){

            int val1 = (p1 != null) ? p1.val : 0;
            int val2 = (p2 != null) ? p2.val : 0;

            int value = val1 + val2 + carry;

            carry = value / 10;
            value %= 10;

            p.next = new ListNode(value);
            p = p.next;

            if (p1 != null) p1 = p1.next;
            if (p2 != null) p2 = p2.next;
        }


        if(carry != 0) p.next = new ListNode(carry);

        return dummy.next;
    }
}
// @lc code=end

