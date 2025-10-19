package DataStructure.Hash;

public class LRU_DLH {
    
    /**
     * 
     * 
     * 
     *          H
     *          K  1<->2<->3 
     *          V  1<->2<->3
     *           H      T 
     *          
     * 
     * 
     *          LRU-Remove->Add to head
     *          KV for ListNode in case Map can't get the first key to be deleted 
     * 
     * 
     * 
    /**
     * 
     */
    private HashMap<Integer, ListNode> map;
    int capacity;
    ListNode head;
    ListNode tail;

    public LRU_DLH(int capacity){
        this.map = new HashMap<>();
        this.capacity = capacity;
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

     public int get(int key) {
        if(this.map.containsKey(key)){
            // make LRU
            ListNode cur = this.map.get(key);
            remove(cur);
            addTohead(cur);
            return cur.val;
        }else return -1;
    }
    
    public void put(int key, int value) {
        // update value
        if(this.map.containsKey(key)){   
            // make LRU
            ListNode cur = this.map.get(key);
            remove(cur);
            cur.val = value;
            addTohead(cur);
        }else{
            if(this.map.size() < capacity){
                ListNode newCur = new ListNode(key, value);                
                addToTail(newCur);
                // make LRU
                remove(newCur);
                addTohead(newCur); 
                this.map.put(key, newCur);               
            }else{
                ListNode last = tail.prev;
                remove(last);
                this.map.remove(last.key);
                
                ListNode newCur = new ListNode(key, value);          
                addToTail(newCur);        
                remove(newCur);
                addTohead(newCur);    
                this.map.put(key, newCur);     
            }
        }
    }

    public void addTohead(ListNode cur){
        ListNode first = head.next;
        first.prev = cur;
        cur.next = first;
        head.next = cur;
        cur.prev = head;
    }

    public void addToTail(ListNode cur){
        ListNode last = tail.prev;
        last.next = cur;
        cur.prev = last;
        tail.prev = cur;
        cur.next = tail;
    }

    public void remove(ListNode cur){
        if(cur == null || cur == head || cur == tail) return;
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
    }
}

class ListNode{
    int key;
    int val;
    ListNode prev; 
    ListNode next;

    public ListNode(int key, int val){
        this.key = key;
        this.val = val;
        prev = null;
        next = null;
    }

}
