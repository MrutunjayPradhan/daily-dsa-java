import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Day5_417_Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return result;
        }
        
        int m = heights.length;
        int n = heights[0].length;
        
        // Create visited arrays for both oceans
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        
        // Queues for BFS
        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();
        
        // Initialize Pacific Ocean borders (top and left)
        for (int i = 0; i < m; i++) {
            pacificQueue.offer(new int[]{i, 0});
            pacific[i][0] = true;
        }
        for (int j = 0; j < n; j++) {
            pacificQueue.offer(new int[]{0, j});
            pacific[0][j] = true;
        }
        
        // Initialize Atlantic Ocean borders (bottom and right)
        for (int i = 0; i < m; i++) {
            atlanticQueue.offer(new int[]{i, n - 1});
            atlantic[i][n - 1] = true;
        }
        for (int j = 0; j < n; j++) {
            atlanticQueue.offer(new int[]{m - 1, j});
            atlantic[m - 1][j] = true;
        }
        
        // BFS for Pacific
        bfs(heights, pacificQueue, pacific);
        
        // BFS for Atlantic
        bfs(heights, atlanticQueue, atlantic);
        
        // Find cells that can reach both oceans
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        
        return result;
    }
    
    private void bfs(int[][] heights, Queue<int[]> queue, boolean[][] visited) {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int m = heights.length;
        int n = heights[0].length;
        
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];
            
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                
                // Check boundaries and if water can flow from new cell to current cell
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n 
                    && !visited[newRow][newCol] 
                    && heights[newRow][newCol] >= heights[row][col]) {
                    visited[newRow][newCol] = true;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }
    }
}
