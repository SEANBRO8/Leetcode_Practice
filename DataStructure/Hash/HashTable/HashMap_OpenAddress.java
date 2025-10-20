package Hash.HashTable;

public class HashMap_OpenAddress {
    
    Pair[] map;
    int capacity;
    int size;

    public HashMap_OpenAddress(){
        map = new Pair[2];
        this.size = 0;
        this.capacity = 2;
    }

    public int hash(String key){
        int index = 0;
        for(int i = 0 ; i < key.length(); i++){
            index += (int)key.charAt(i);
        }
        return index % this.capacity;
    }

    // get-value
    public String get(String key){
        int hash = hash(key);

        while(this.map[hash] != null){
            if(map[hash].key == key) return map[hash].val;
            // open addressing look for the next address
            hash++;
            hash %= this.capacity;
        }

        return null;
    }
    // put
    public void put(String key, String value){
        // always comput Hash first
        int hash = hash(key);
        // occupied
        while(true){
            // vacant
            if(this.map[hash] == null){
                Pair newPair = new Pair(key, value);
                this.map[hash] = newPair;
                this.size++;
                if(this.size >= this.capacity / 2) this.rehash();
                return;
            // occupied with same key
            }else if(this.map[hash].key.equals(key)){
                this.map[hash].val = value;
            }
            // open addressing look for the next address
            hash++;
            hash %= this.capacity;
        }
    }
    // remove
    public void remove(String key){

        if(this.get(key) == null) return;

        int hash = this.hash(key);
        while(true){
            // find index -> remove key -> set index null
            if(this.map[hash].key.equals(key)){
                this.map[hash] = null;
                this.size--;
                return;
            }
            hash++;
            hash %= this.capacity;         
        }

    }

    // rehash-> double the capacity
    public void rehash(){
        this.capacity *= 2;
        Pair[] oldPair = this.map;
        Pair[] newPair = new Pair[this.capacity];
        this.map = newPair;
        this.size = 0;

        for(Pair p : oldPair){
            if(p != null){
                this.put(p.key, p.val);
            }
        }
    }
}

class Pair{
        String key;
        String val;

        public Pair(String key, String value){
            this.key = key;
            this.val = value;
        }
}


