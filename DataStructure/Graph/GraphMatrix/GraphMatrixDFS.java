package Graph.GraphMatrix;

public class GraphMatrixDFS {
    private int[][] directions = new int[][]{
            {0, 1},   
            {1, 0},   
            {0, -1},  
            {-1, 0}   
    };

    public void dfs(int[][] grid, int i, int j, boolean[][] visited){
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return;
        int m = grid.length, n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] == true) return;
        
         visited[i][j] = true;

        for(int p = 0; p < 4; p++){
            dfs(grid, p + directions[p][0], p + directions[p][1], visited);
        }
    }
}
