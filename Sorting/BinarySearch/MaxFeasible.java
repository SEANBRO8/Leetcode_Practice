package BinarySearch;


public class MaxFeasible {
    public int maxFeasible(int l, int r){
        while (l < r) {
            int m = l + (r - l + 1) / 2;  
            if (check(m)) l = m;       
            else r = m - 1;           
        }
        return l;
    }
    
    public boolean check(int m){
        return true;
    }
}
