package Graph.GraphNode;
import java.util.ArrayList;
import java.util.List;

public class WeightedDigraph_Matrix {

    private static class Edge {
        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public int[][] matrix;

    public WeightedDigraph_Matrix(int n){
        matrix = new int[n][n];
    }

    public void addEdge(int from, int to, int weight) {
        matrix[from][to] = weight;
    }

    public void removeEdge(int from, int to) {
        matrix[from][to] = 0;
    }

    public boolean hasEdge(int from, int to) {
        return matrix[from][to] != 0;
    }

    public int weight(int from, int to) {
        return matrix[from][to];
    }

    public List<Edge> neighbors(int v){
        List<Edge> ans = new ArrayList<>();

        for(int i = 0; i < matrix[v].length; i++){
            if(matrix[v][i] != 0){
                ans.add(new Edge(i, matrix[v][i]));
            }      
        }
        return ans;
    }

    public static void main(String[] args) {
        WeightedDigraph_Matrix graph = new WeightedDigraph_Matrix(3);
        graph.addEdge(0, 1, 1);
        graph.addEdge(1, 2, 2);
        graph.addEdge(2, 0, 3);
        graph.addEdge(2, 1, 4);

        System.out.println(graph.hasEdge(0, 1)); // true
        System.out.println(graph.hasEdge(1, 0)); // false

        graph.neighbors(2).forEach(edge -> {
            System.out.println(2 + " -> " + edge.to + ", wight: " + edge.weight);
        });
        // 2 -> 0, wight: 3
        // 2 -> 1, wight: 4

        graph.removeEdge(0, 1);
        System.out.println(graph.hasEdge(0, 1)); // false
    }
}
