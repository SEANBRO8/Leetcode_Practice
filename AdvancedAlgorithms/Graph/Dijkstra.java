package Graph;
import java.util.*;

public class Dijkstra {
    
    public Map<Integer, Integer> shortestPath(int[][] edges, int n, int start){
        Map<Integer, List<int[]>> graph = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            graph.put(i, new ArrayList<>());
        }
        
        for(int[]edge : edges){
            int from = edge[0], to = edge[1], weight = edge[2];
            graph.get(from).add(new int[]{to, weight});
        }
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->a[1] - b[1]);

        minHeap.offer(new int[]{start, 0});

        while(!minHeap.isEmpty()){
            int[] cur = minHeap.poll();

            int to = cur[0], cost = cur[1];

            if(map.containsKey(to)) continue;
            map.put(to, cost);

            List<int[]> nextS = graph.get(to);

             for (int[] next : nextS) {
                int nextNode = next[0];
                int nextCost = next[1];
                
                if (!map.containsKey(nextNode)) {
                    minHeap.offer(new int[]{nextNode, cost + nextCost});
                }
            }
        }

        return map;
    }


}
 