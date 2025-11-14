package Graph;
import java.util.*;

public class Kruskal {
    public static List<int[]> mst(int[][] edges, int n){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2] - b[1]);

        for(int[] edge : edges){
            int from = edge[0], to = edge[1], weight = edge[2];
            pq.offer(new int[]{from, to, weight});
        }
    
        UnionFind uf = new UnionFind(n);
        List<int[]> mst = new ArrayList<>();

        while(mst.size() < n - 1){
            int[] curEdge = pq.poll();
            int from = curEdge[0], to = curEdge[1], weight = curEdge[2];
            if(!uf.union(from, to)) continue;
            mst.add(new int[]{from, to});
        }
        return mst;
    }
}

class UnionFind{

    int[] parents;
    int[] ranks;

    public UnionFind(int n ){
        parents = new int[n];
        ranks = new int[n];
        for(int i = 1; i <= n; i++) parents[i] = i;

    }

    public int find(int a){
        if(parents[a] != a){
            parents[a] = find(parents[a]);
        }
        return parents[a];
    }

    public boolean union(int a, int b){

        int pA = find(a), pB = find(b);

        if(pA == pB) return false;

        if(ranks[pA] > ranks[pB]){
            parents[b] = pA;
        }else if(ranks[pA] < ranks[pB]){
            parents[a] = pB;
        }else{
            parents[b] = pA;  
            ranks[pA]++;       
        }
        return true;
    }


}
