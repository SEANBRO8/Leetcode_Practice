package Hash.LRU;
import java.util.LinkedHashMap;

public class LRU_LHP {
    // linked HashMap 
    LinkedHashMap<Integer, Integer> map;
    int capacity;

    public LRU_LHP(int capacity){
        map = new LinkedHashMap<>();
        this.capacity = capacity;
    }

    public int get(int key){
        if(map.containsKey(key)){
            makeLRU(key);
            return map.get(key);
        }else return -1;
    }

    public void put(int key, int value){
        if(map.containsKey(key)){
            map.put(key, value);     
            makeLRU(key);   
        }else{
            if(map.size() < capacity){
                makeLRU(key);
                map.put(key, value);    
            }else{
                int firstKey = -1;
                for(int keyInMap : map.keySet()){
                        firstKey = keyInMap;
                        break;
                    }
                map.remove(firstKey);
                map.put(key,value);
            }
        }
    }

    public void makeLRU(int key){
        int value = map.get(key);
        map.remove(key);
        map.put(key,value); 
    }
}
