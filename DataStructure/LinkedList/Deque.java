package DataStructure.LinkedList;

public class Deque {
    ListNode head;
    ListNode tail;
    public Deque() {
        head = new ListNode(-1);
        tail = new ListNode(-1);
        head.next = tail;
        tail.prev = head;
    }

    public boolean isEmpty() {
        if(head.next == tail) return true;
        else return false;
    }

    public void append(int value) {
       ListNode cur = new ListNode(value);
       ListNode prev = tail.prev;
       cur.prev = prev;
       prev.next = cur;
       cur.next = tail;
       tail.prev = cur;
    }

    public void appendleft(int value) {
        if(isEmpty()) append(value);
        else{
            ListNode first = head.next;
            ListNode cur = new ListNode(value);      

            cur.next = first;
            first.prev = cur;
            cur.prev = head;
            head.next = cur;   
        }      
    }

    public int pop() {
        if(isEmpty()) return -1;
        else{
            ListNode last = tail.prev;
            ListNode prev = last.prev;
            prev.next = tail;
            tail.prev = prev;
            return last.val;
        }

    }

    public int popleft() {
        if(isEmpty()) return -1;     
        else{
                ListNode first = head.next;
            ListNode next  = first.next;

            head.next = next;
            next.prev = head;    
            return first.val;
        }

    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode prev;
    
    ListNode(int val) {
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}