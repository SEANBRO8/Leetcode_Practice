package Graph.GraphNode.BFS_DFS;

public class Graph_DFS {

    public void dfs(Vertex root){

        if(root == null) return;

    }


    private class Vertex{
        int id;
        Vertex[] neighbors;

        public Vertex(int id){
            this.id = id;
            this.neighbors = null;
        }
    }
}


