package DataStructure.LinkedList;
import java.util.*;

class SinglyLinkedList {
    ListNode head;
    ListNode tail;
    int size;
    public SinglyLinkedList() {
        this.head = new ListNode(-1);
        this.tail = new ListNode(-1);
        this.head.next = tail;
        this.tail.prev = head;
        this.size = 0;
    }

    public int get(int index) {
        // 0 based
        if (index < 0 || index >= this.size) return -1;
        ListNode cur = this.head.next;
        while(index > 0){
            cur = cur.next;
            index--;
        }
        return cur.val;
    }

    public void insertHead(int val) {
        ListNode first = this.head.next;
        ListNode newNode = new ListNode(val);
        newNode.prev = head;
        head.next = newNode;
        newNode.next = first;
        first.prev = newNode;
        size++;
    }

    public void insertTail(int val) {
        ListNode last = this.tail.prev;
        ListNode newNode = new ListNode(val);
        newNode.prev = last;
        last.next = newNode;
        newNode.next = tail;
        tail.prev = newNode;
        size++;
    }

    public boolean remove(int index) {
       if (index < 0 || index >= this.size) return false;
        ListNode prev = this.head;
        while(index > 0){
            prev = prev.next;
            index--;
        }
        ListNode next = prev.next.next;
        prev.next = next;
        next.prev = prev;
        size--;
        return true;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> res = new ArrayList<>();
        ListNode curr = this.head.next;
        while (curr != null && curr != tail) {
            res.add(curr.val);
            curr = curr.next;
        }
        return res;
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode prev;
    public ListNode(int val){
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}
