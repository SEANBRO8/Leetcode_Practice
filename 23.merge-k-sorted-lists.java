/*
 * @lc app=leetcode id=23 lang=java
 *
 * [23] Merge k Sorted Lists
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
    public ListNode mergeKLists(ListNode[] lists) {
        // TC: (M+N)logN  SC: M/N 
        
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(

            (a,b)->(a.val - b.val)

        );

        for(ListNode node : lists){
            if(node == null) continue;
            pq.add(node);
        }

        while(pq.size() > 0){

            ListNode cur = pq.remove();

            if(cur.next != null){
                pq.add(cur.next);
            }
            p.next = cur;
            p = p.next;
        }

        return dummy.next;
    }
}
// @lc code=end

