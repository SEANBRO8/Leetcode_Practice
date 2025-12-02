package Graph;

public class UnionFind {
    int[] parents;
    int[] ranks;

    public UnionFind(int n){
        parents = new int[n];
        ranks = new int[n];

        for(int i = 0; i < n; i++){
            parents[i] = i;
            ranks[i] = 1;
        }
    }

    public int find(int x){
        if(x != parents[x]){
            parents[x] = find(parents[x]);
        }
        return parents[x];
    }

    public boolean union(int a, int b){
        int pA = find(a), pB = find(b);

        if(pA == pB) return false;

        if(ranks[pA] > ranks[pB]){
            parents[pB] = pA;
            ranks[pA] += ranks[pB];
        }else if(ranks[pA] < ranks[pB]){
            parents[pA] = pB;
            ranks[pB] += ranks[pA];
        }else{
            parents[pB] = pA;
            ranks[pA] += ranks[pB];
        }

        return true;
    }

}
