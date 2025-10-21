package Graph.GraphMatrix;
import java.util.*;

public class GraphMatrixBFS {
    private int[][] directions = new int[][]{
        {0, 1},   
        {1, 0},   
        {0, -1},  
        {-1, 0}   
    };

    public int bfs(int[][] grid, int i, int j){
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) return -1;
        int m = grid.length, n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n) return -1;
        if (grid[i][j] == 1) return -1; 


        Deque<int[]> deque = new ArrayDeque<>();
        boolean[][] visited = new boolean[m][n];
        visited[i][j] = true;
        deque.offer(new int[]{i, j});
        int ans = 1;

        while(!deque.isEmpty()){
            int size = deque.size();
            for(int p = 0; p < size; p++){
                int[] cur = deque.poll();
                // check boarder & critiria
                int x = cur[0], y = cur[1];
                if(x == m - 1 && y == n - 1) return ans;

                for(int k = 0; k < 4; k++){
                    int newX = cur[0] + directions[k][0];
                    int newY = cur[1] + directions[k][1];
                    if(newX < 0 || newX >= m || newY < 0 || newY >= n || visited[newX][newY] == true || grid[newX][newY] == 1) continue;
                    deque.offer(new int[]{newX, newY});
                    grid[newX][newY] = 0;
                    visited[newX][newY] = true;
                }
            }
            ans++;
        } 
        return -1;
    }
}
