package Graph;
import java.util.*;

public class Prim {

    // Return MST edges, and print them with total cost
    public List<int[]> mst(int[][] edges, int n, int start) {
        Map<Integer, List<int[]>> graph = new HashMap<>();

        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            int from = edge[0], to = edge[1], weight = edge[2];
            graph.get(from).add(new int[]{to, weight});
            graph.get(to).add(new int[]{from, weight});
        }

        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        visited[start] = true;
        int count = 1;

        for (int[] neighbor : graph.get(start)) {
            int to = neighbor[0], weight = neighbor[1];
            minHeap.offer(new int[]{start, to, weight});
        }

        List<int[]> mstEdges = new ArrayList<>();
        int totalCost = 0;

        while (!minHeap.isEmpty() && count < n) {
            int[] cur = minHeap.poll();
            int to = cur[1], cost = cur[2];

            if (visited[to]) continue;

            visited[to] = true;
            count++;
            mstEdges.add(cur);
            totalCost += cost;

            for (int[] next : graph.get(to)) {
                int nextTo = next[0];
                int nextCost = next[1];
                if (!visited[nextTo]) {
                    minHeap.offer(new int[]{to, nextTo, nextCost});
                }
            }
        }

        // ✅ Print MST result
        System.out.println("MST Edges:");
        for (int[] e : mstEdges) {
            System.out.println(e[0] + " - " + e[1] + " (cost: " + e[2] + ")");
        }
        System.out.println("Total cost: " + totalCost);

        return mstEdges;
    }

    // A simple test
    public static void main(String[] args) {
        Prim p = new Prim();
        int[][] edges = {
            {0, 1, 4},
            {0, 2, 3},
            {1, 2, 1},
            {1, 3, 2},
            {2, 3, 4},
            {3, 4, 2},
            {4, 5, 6}
        };
        p.mst(edges, 6, 0);
    }
}
