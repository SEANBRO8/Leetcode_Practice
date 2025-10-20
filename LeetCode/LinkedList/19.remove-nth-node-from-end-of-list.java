/*
 * @lc app=leetcode id=19 lang=java
 *
 * [19] Remove Nth Node From End of List
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode nth = findNthNode(dummy, n + 1);

        nth.next = nth.next.next;

        return dummy.next;

    }

    public ListNode findNthNode(ListNode head, int n){
            ListNode p1 = head;
            ListNode p2 = head;

            for(int i = 0; i < n; i++){
                p1 = p1.next;
            }

            while(p1 != null){
                p1 = p1.next;
                p2 = p2.next;
            }

            return p2;


    }
}
// @lc code=end

