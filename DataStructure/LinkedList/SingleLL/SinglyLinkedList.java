package LinkedList.SingleLL;
import java.util.*;

public class SinglyLinkedList {
    int size;
    ListNode head;
    ListNode tail;
    public SinglyLinkedList(){
        this.size = 0;
        this.head = new ListNode(-1);
        head = tail;
    }

    public int get(int index) {
        int i = 0;
        ListNode cur = head.next;
        while(cur != null){
            if(i == index) return cur.val;
            i++;
            cur= cur.next;
        }
        return -1;
    }    

    public void insertHead(int val) {
        ListNode cur = head.next;
        ListNode newH = new ListNode(val);
        newH.next = cur;
        head.next = newH;
        if(cur == null) tail = newH;
    }

    public boolean remove(int index) {
        int i = 0;
        ListNode prev = head;
        while(i < index && prev != null){
            i++;
            prev = prev.next;
        }

        if(prev != null && prev.next != null){
            if(prev.next == tail) tail = prev;
            prev.next = prev.next.next;
            return true;
        }
        return false;
    }

    public void insertTail(int val) {
        tail.next = new ListNode(val);
        tail = tail.next;
    }


    public ArrayList<Integer> getValues() {
        ArrayList<Integer> ans = new ArrayList<>();
        ListNode cur = head.next;

        while(cur != null){
            ans.add(cur.val);
            cur = cur.next;
        }

        return ans;
    }
}

class ListNode {
    ListNode next;
    int val;

    public ListNode(int val){
        this.val = val;
        this.next = null;
    }
}
