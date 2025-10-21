package Graph.GraphNode;
import java.util.ArrayList;
import java.util.List;

public class Digraph_Graph {
    
    private static class Edge{
        int to;
        int weight;

        public Edge(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }

    private List<Edge>[] graph;
    // weight directed graph
    public Digraph_Graph(int n){
        // n is the vertex of the graph
        graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
    }
    // add edge
    public void addEdge(int from, int to, int weight){
        graph[from].add(new Edge(to, weight));
    }
    // remove
    public void removeEdge(int from, int to){
        if(graph[from] != null){
            for(int i = 0 ; i < graph[from].size(); i++){
                if(graph[from].get(i).to == to){
                    graph[from].remove(i);
                    break;
                }
            }
        }
    }
    // has edge?
    public boolean hasEdge(int from, int to){
        if(graph[from] == null) return false;
        for(Edge edge : graph[from]){
            if(edge.to == to) return true;
        }
        return false;
    }   
    // weight
    public int weight(int from, int to){
        if(graph[from] == null) return 0;
        for(Edge edge : graph[from]){
            if(edge.to ==  to) return edge.weight;
        }
        throw new IllegalArgumentException("No such edge");
    }

    // //  hasEdge、removeEdge、weight could be updated by Map<Integer, Map<Integer, Integer>> 

    // neighbors
    public List<Edge> neighbors(int v){
        return graph[v];
    }
    // size
    public int size(){
        return graph.length;
    }
    // test
    public static void main(String[] args) {
        Digraph_Graph graph = new Digraph_Graph(3);
        graph.addEdge(0, 1, 1);
        graph.addEdge(1, 2, 1);
        graph.addEdge(2, 0, 1);
        graph.addEdge(2, 1, 1);

        System.out.println(graph.hasEdge(0, 1)); // true
        System.out.println(graph.hasEdge(1, 0)); // false

        graph.neighbors(2).forEach(edge -> {
            System.out.println(2 + " -> " + edge.to + ", wight: " + edge.weight);
        });
        // 2 -> 0, wight: 3
        // 2 -> 1, wight: 4

        graph.removeEdge(0, 1);
        System.out.println(graph.hasEdge(0, 1)); // false
        System.out.println(graph.size()); // false
    }
}
