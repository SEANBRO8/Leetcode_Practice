package BinarySearch;

public class MinFeasible {
    public int minFeasible(int l, int r){
        while (l < r) {
            int m = l + (r - l) / 2;  
            if (check(m)) r = m;       
            else l = m + 1;           
        }
        return l;
    }
    public boolean check(int m){
        return true;
    }
}
