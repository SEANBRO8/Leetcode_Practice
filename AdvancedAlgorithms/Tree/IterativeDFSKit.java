package Tree;

import java.util.*;
import java.util.function.*;

/**
 * Iterative DFS Templates (NG-ready)
 *
 * Master just these:
 * 1) Graph DFS (enter-only): pop -> visit -> push neighbors (reversed), mark visited AFTER pop.
 * 2) Graph DFS (enter/exit two-phase): simulate recursion pre/post (toposort, subtree aggregation).
 * 3) Trees: preorder / inorder / postorder (all iterative).
 * 4) Grid DFS: 4-neighborhood, bounds check, mark-on-push.
 *
 * All methods are static and self-contained for copy/paste into LeetCode.
 */
public class IterativeDFSKit {

    /* ===================== 0) Shared Data Types ===================== */
    // Binary tree node (LeetCode-compatible)
    public static class TreeNode {
        public int val; public TreeNode left, right;
        public TreeNode(int v){ val = v; }
        public TreeNode(int v, TreeNode l, TreeNode r){ val=v; left=l; right=r; }
    }

    /* ================================================================
     * 1) GRAPH: Basic iterative DFS (enter-only)
     *    - Use after-pop visited marking.
     *    - Push neighbors in REVERSE to match recursive order when adjacency is ascending.
     * ================================================================ */
    public static void dfsGraphBasic(List<List<Integer>> g, int start, BooleanSupplier stopper, IntConsumer visit){
        int n = g.size();
        boolean[] vis = new boolean[n];
        Deque<Integer> st = new ArrayDeque<>();
        st.push(start);
        while(!st.isEmpty()){
            if (stopper != null && stopper.getAsBoolean()) return; // optional early stop
            int u = st.pop();
            if (vis[u]) continue; // process each node once
            vis[u] = true;
            if (visit != null) visit.accept(u); // ENTER (preorder-like)
            List<Integer> nb = g.get(u);
            for(int i = nb.size()-1; i >= 0; i--){ // reverse to preserve order
                int v = nb.get(i);
                if (!vis[v]) st.push(v);
            }
        }
    }

    // Overload without stopper
    public static void dfsGraphBasic(List<List<Integer>> g, int start, IntConsumer visit){
        dfsGraphBasic(g, start, null, visit);
    }

    /* ================================================================
     * 2) GRAPH: Enter/Exit (two-phase) DFS
     *    - Perfect recursion simulation: ENTER (pre), EXIT (post)
     *    - Use EXIT to collect postorder / toposort.
     * ================================================================ */
    private static class Frame { int u; boolean exit; Frame(int u, boolean e){ this.u = u; this.exit = e; } }

    public static void dfsGraphEnterExit(List<List<Integer>> g, int start, IntConsumer onEnter, IntConsumer onExit){
        int n = g.size();
        boolean[] vis = new boolean[n];
        Deque<Frame> st = new ArrayDeque<>();
        st.push(new Frame(start, false));
        while(!st.isEmpty()){
            Frame f = st.pop();
            int u = f.u;
            if (!f.exit){
                if (vis[u]) continue;
                vis[u] = true;
                if (onEnter != null) onEnter.accept(u);
                st.push(new Frame(u, true)); // schedule EXIT
                List<Integer> nb = g.get(u);
                for(int i = nb.size()-1; i >= 0; --i){
                    int v = nb.get(i);
                    if (!vis[v]) st.push(new Frame(v, false));
                }
            }else{
                if (onExit != null) onExit.accept(u);
            }
        }
    }

    /** Topological order via two-phase DFS.
     *  Returns empty list if a cycle exists. Assumes vertices are 0..n-1.
     */
    public static List<Integer> topoOrderByDFS(List<List<Integer>> g){
        int n = g.size();
        int[] color = new int[n]; // 0=white,1=gray,2=black
        List<Integer> post = new ArrayList<>(); // collect on EXIT
        for(int s=0; s<n; s++){
            if (color[s] != 0) continue;
            Deque<int[]> st = new ArrayDeque<>(); // [u, state] state:0=enter,1=exit
            st.push(new int[]{s,0});
            while(!st.isEmpty()){
                int[] fr = st.pop();
                int u = fr[0], state = fr[1];
                if (state == 0){ // ENTER
                    if (color[u] == 2) continue;     // already done
                    if (color[u] == 1) return List.of(); // back-edge -> cycle
                    color[u] = 1; // gray
                    st.push(new int[]{u,1});
                    List<Integer> nb = g.get(u);
                    for(int i = nb.size()-1; i >= 0; --i){
                        int v = nb.get(i);
                        if (color[v] != 2) st.push(new int[]{v,0});
                    }
                }else{ // EXIT
                    color[u] = 2; // black
                    post.add(u);
                }
            }
        }
        Collections.reverse(post); // reverse postorder => topo order
        return post;
    }

    /** Bipartite check via iterative DFS coloring. */
    public static boolean isBipartite(List<List<Integer>> g){
        int n = g.size();
        int[] color = new int[n]; // 0=uncolored,1/-1 two colors
        Deque<Integer> st = new ArrayDeque<>();
        for(int s=0; s<n; s++){
            if (color[s] != 0) continue;
            color[s] = 1; st.push(s);
            while(!st.isEmpty()){
                int u = st.pop();
                for(int v : g.get(u)){
                    if (color[v] == 0){ color[v] = -color[u]; st.push(v); }
                    else if (color[v] == color[u]) return false;
                }
            }
        }
        return true;
    }

    /** Optional: Reconstruct path s->t using iterative DFS parent pointers (if reachable). */
    public static List<Integer> pathDFS(List<List<Integer>> g, int s, int t){
        int n = g.size();
        int[] parent = new int[n]; Arrays.fill(parent, -1);
        boolean[] vis = new boolean[n];
        Deque<Integer> st = new ArrayDeque<>(); st.push(s);
        while(!st.isEmpty()){
            int u = st.pop();
            if (vis[u]) continue;
            vis[u] = true;
            if (u == t) break;
            List<Integer> nb = g.get(u);
            for(int i = nb.size()-1; i >= 0; --i){
                int v = nb.get(i);
                if (!vis[v]){ parent[v] = u; st.push(v);} 
            }
        }
        if (!vis[t]) return List.of();
        List<Integer> path = new ArrayList<>();
        for(int cur=t; cur!=-1; cur=parent[cur]) path.add(cur);
        Collections.reverse(path);
        return path;
    }

    /* ================================================================
     * 3) TREES: Iterative traversals
     * ================================================================ */

    /** Preorder: root -> left -> right (push right first so left pops first) */
    public static List<Integer> preorder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Deque<TreeNode> st = new ArrayDeque<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode cur = st.pop();
            res.add(cur.val);
            if (cur.right != null) st.push(cur.right);
            if (cur.left  != null) st.push(cur.left);
        }
        return res;
    }

    /** Inorder: left -> root -> right (pointer descent + stack) */
    public static List<Integer> inorder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> st = new ArrayDeque<>();
        TreeNode cur = root;
        while(cur != null || !st.isEmpty()){
            while(cur != null){ st.push(cur); cur = cur.left; }
            cur = st.pop();
            res.add(cur.val);
            cur = cur.right;
        }
        return res;
    }

    /** Postorder: left -> right -> root (single stack + last pointer) */
    public static List<Integer> postorder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> st = new ArrayDeque<>();
        TreeNode cur = root, last = null;
        while(cur != null || !st.isEmpty()){
            while(cur != null){ st.push(cur); cur = cur.left; }
            TreeNode peek = st.peek();
            if (peek.right != null && last != peek.right){
                cur = peek.right; // go right first
            }else{
                res.add(peek.val); // both children done
                last = st.pop();
            }
        }
        return res;
    }

    /* ================================================================
     * 4) GRID: Iterative DFS (4-neighborhood)
     * ================================================================ */
    private static final int[][] DIR4 = {{1,0},{-1,0},{0,1},{0,-1}};

    /** Flood fill (returns mutated image). Mark-on-push avoids duplicates. */
    public static int[][] floodFill(int[][] img, int sr, int sc, int newColor){
        int m = img.length, n = img[0].length;
        int old = img[sr][sc];
        if (old == newColor) return img;
        Deque<int[]> st = new ArrayDeque<>();
        st.push(new int[]{sr, sc});
        img[sr][sc] = newColor; // mark on push
        while(!st.isEmpty()){
            int[] p = st.pop();
            for(int[] d : DIR4){
                int r = p[0] + d[0], c = p[1] + d[1];
                if (r>=0 && r<m && c>=0 && c<n && img[r][c]==old){
                    img[r][c] = newColor;
                    st.push(new int[]{r,c});
                }
            }
        }
        return img;
    }

    /** Number of Islands (char grid with '1'/'0'), iterative DFS. */
    public static int numIslands(char[][] g){
        int m = g.length, n = g[0].length, count = 0;
        Deque<int[]> st = new ArrayDeque<>();
        for(int i=0;i<m;i++) for(int j=0;j<n;j++) if (g[i][j]=='1'){
            count++;
            g[i][j]='0'; st.push(new int[]{i,j});
            while(!st.isEmpty()){
                int[] p = st.pop();
                for(int[] d: DIR4){
                    int r=p[0]+d[0], c=p[1]+d[1];
                    if (r>=0&&r<m&&c>=0&&c<n&&g[r][c]=='1'){
                        g[r][c]='0'; st.push(new int[]{r,c});
                    }
                }
            }
        }
        return count;
    }

    /* ===================== Convenience Builders ===================== */
    /** Build adjacency list (0..n-1) from edge list (u,v) directed or undirected. */
    public static List<List<Integer>> buildGraph(int n, int[][] edges, boolean undirected){
        List<List<Integer>> g = new ArrayList<>();
        for(int i=0;i<n;i++) g.add(new ArrayList<>());
        for(int[] e : edges){
            int u=e[0], v=e[1];
            g.get(u).add(v);
            if (undirected) g.get(v).add(u);
        }
        // Optional: sort neighbors so reversed push matches ascending recursive order
        for(int i=0;i<n;i++) Collections.sort(g.get(i));
        return g;
    }
}

