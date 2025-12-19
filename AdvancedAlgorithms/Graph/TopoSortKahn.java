package Graph;
import java.util.*;

/**
 * Topological Sort - Kahn's Algorithm (BFS with indegree)
 * - Works for DAG.
 * - If graph has cycle, result size < n.
 */
public class TopoSortKahn {

    // edges: list of (u -> v)
    public static int[] topoSort(int n, int[][] edges) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) g.add(new ArrayList<>());

        int[] indeg = new int[n];
        for (int[] e : edges) {
            int u = e[0], v = e[1];
            g.get(u).add(v);
            indeg[v]++;
        }

        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (indeg[i] == 0) q.offer(i);
        }

        int[] order = new int[n];
        int idx = 0;

        while (!q.isEmpty()) {
            int u = q.poll();
            order[idx++] = u;
            for (int v : g.get(u)) {
                if (--indeg[v] == 0) q.offer(v);
            }
        }

        // cycle check
        if (idx != n) return new int[0]; // empty => cycle
        return order;
    }

    // quick test
    public static void main(String[] args) {
        int n = 4;
        int[][] edges = {{0,1},{0,2},{1,3},{2,3}};
        System.out.println(Arrays.toString(topoSort(n, edges)));
    }
}