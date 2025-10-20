package Hash.HashTable;

class HashTable_Chaining {
    int size; 
    int capacity;
    Pair1[] table;
    public HashTable_Chaining(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.table = new Pair1[capacity];
    }

    public int hash(int key){
        return key % this.capacity;
    }

    public void insert(int key, int value) {
        int index = hash(key);
        Pair1 newP = new Pair1(key, value);
        Pair1 cur = table[index];
        Pair1 prev = null;
        
        if(table[index] == null){
            table[index] = newP;
            size++;
        }else{
            while(cur != null){
                // duplicate
                if(cur.key == key){
                    cur.val = value;
                    return;
                }
                prev = cur;
                cur = cur.next;
            }
            prev.next = newP;
            size++;
        }
        if(2 * (size) >= capacity) resize();
    }

    public int get(int key) {
        int index = hash(key);
        Pair1 cur = table[index];

        if(cur == null) return -1;        

        while(cur != null){
            if(cur.key == key) return cur.val;
            cur = cur.next;
        }
        return -1;
    }

    public boolean remove(int key) {
        int index = hash(key);
        Pair1 cur = table[index];
        Pair1 prev = null;
        if(cur == null) return false;
        while(cur != null){
            if(cur.key == key){
                if(prev == null) table[index] = cur.next;
                else prev.next = cur.next;
                size--;
                return true;
            }
            prev = cur;
            cur = cur.next;
        }
        return false;
    }

    public int getSize() {
        return this.size;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void resize() {
        int newCapacity = this.capacity * 2;
        Pair1[] newTable = new Pair1[newCapacity];

        for(Pair1 pair : table){
            Pair1 cur = pair;
            while(cur != null){
                int key = cur.key;
                Pair1 newP = new Pair1(cur.key, cur.val);
                int index = key % newCapacity;
                
                if(newTable[index] == null){
                    newTable[index] = newP;
                }else{
                    Pair1 prev = null;
                    prev.next = cur;
                    while(prev.next != null){
                        prev = prev.next;
                    }
                    prev.next = newP;
                }
                cur = cur.next;
            }
        }
        this.capacity = newCapacity;
        this.table = newTable;
    }
}

class Pair1{
        int key;
        int val;
        Pair1 next;

        public Pair1(int key, int val){
            this.key = key;
            this.val = val;
            this.next = null;
        }
}


