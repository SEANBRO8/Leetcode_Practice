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
    public ListNode deleteDuplicates(ListNode head) {
       
        if(head == null) return null;

        ListNode fast = head;
        ListNode slow = head;

        while(fast != null){

            if(fast.val != slow.val){
                slow.next = fast;
                slow = slow.next;
                
            }
            fast = fast.next;
        }
        slow.next = null;
        return head;

    }
}