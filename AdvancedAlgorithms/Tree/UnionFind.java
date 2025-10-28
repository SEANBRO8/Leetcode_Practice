package Tree;
import java.util.*;

public class UnionFind {
    HashMap<Integer, Integer> parents;
    HashMap<Integer, Integer> ranks;
    /**
     * 
     *  TC: O(1), SC: O(n)
     * 
     */
    public UnionFind(int n){
        parents = new HashMap<>();
        ranks = new HashMap<>();

        for(int i = 1; i <= n; i++){
            // set the parent as it self
            parents.put(i, i);
            ranks.put(i, 0);
        }
    }

    public int find(int x){
        // find the root
        if(x != parents.get(x)){
            parents.put(x, find(parents.get(x))); // compression the path
        }
        return parents.get(x);
    }

    public boolean union(int a, int b){
        int p1 = find(a), p2= find(b);
        if(p1 == p2) return false;

        if(ranks.get(p1) > ranks.get(p2)){
            parents.put(p2, p1);
        }else if(ranks.get(p1) < ranks.get(p2)){
            parents.put(p1, p2);            
        }else{
            // add rank for p2, set p1 as parent
            parents.put(p2, p1);            
            ranks.put(p1, ranks.get(p1) + 1);
        }
        return true;
    }
}
