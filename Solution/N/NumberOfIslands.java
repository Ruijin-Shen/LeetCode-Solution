package Solution.N;

import java.util.*;

public class NumberOfIslands {
}

class Solution200 {
    private final int[] actionX = new int[]{0, 0, 1, -1};
    private final int[] actionY = new int[]{1, -1, 0, 0};

    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int result = 0;

        Deque<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    result++;
                    visited[i][j] = true;
                    queue.addLast(new int[]{i, j});

                    while(!queue.isEmpty()){
                        int[] coord = queue.removeLast();
                        for(int k = 0; k < 4; k++){
                            int x = coord[0] + actionX[k];
                            int y = coord[1] + actionY[k];
                            if(x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == '1' && !visited[x][y]){
                                visited[x][y] = true;
                                queue.addLast(new int[]{x, y});
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
}