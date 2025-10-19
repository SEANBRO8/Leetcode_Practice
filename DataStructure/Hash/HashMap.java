package DataStructure.Hash;

public class HashMap {
    
    Pair[] map;
    int capacity;
    int size;

    public HashMap(){
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

        while(this.map[index] != null){
            if(map[hash].key == key) return map[hash].val;
            // open addressing look for the next address
        }

        String value = map[hash].val;
        return value;
    }
    // put

    // remove
}

class Pair{
    String key;
    String val;

    public Pair(String key, String value){
        this.key = key;
        this.val = value;
    }

}
