import java.util.Deque;
import java.util.LinkedList;

public class ShortestPathInBinaryMatrix {
}

class MySolution1091 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1) return -1;

        // BFS
        int n = grid.length;
        Deque<int[]> curQueue = new LinkedList<>();
        Deque<int[]> nextQueue = new LinkedList<>();
        boolean[][] visit = new boolean[n][n];

        curQueue.addLast(new int[]{0, 0});
        visit[0][0] = true;
        int deepth = 0;

        while(!curQueue.isEmpty()){
            int[] curNode = curQueue.removeFirst();
            int x = curNode[0], y = curNode[1];
            if(x == (n - 1) && y == (n - 1)) return deepth + 1;

            if( (x - 1) >= 0 && !visit[x - 1][y] && grid[x - 1][y] == 0){
                visit[x - 1][y] = true;
                nextQueue.addLast(new int[]{x - 1, y}); // 西
            }
            if( (x + 1) < n && !visit[x + 1][y] && grid[x + 1][y] == 0){
                visit[x + 1][y] = true;
                nextQueue.addLast(new int[]{x + 1, y}); // 东
            }
            if( (y - 1) >= 0 && !visit[x][y - 1] && grid[x][y - 1] == 0){
                visit[x][y - 1] = true;
                nextQueue.addLast(new int[]{x, y - 1}); // 北
            }
            if( (y + 1) < n && !visit[x][y + 1] && grid[x][y + 1] == 0){
                visit[x][y + 1] = true;
                nextQueue.addLast(new int[]{x, y + 1}); // 南
            }
            if( (x - 1) >= 0 && (y - 1) >= 0 && !visit[x - 1][y - 1] && grid[x - 1][y - 1] == 0){
                visit[x - 1][y - 1] = true;
                nextQueue.addLast(new int[]{x - 1, y - 1}); // 西北
            }
            if( (x + 1) < n && (y - 1) >= 0 && !visit[x + 1][y - 1] && grid[x + 1][y - 1] == 0){
                visit[x + 1][y - 1] = true;
                nextQueue.addLast(new int[]{x + 1, y - 1}); // 东北
            }
            if( (x - 1) >= 0 && (y + 1) < n && !visit[x - 1][y + 1] && grid[x - 1][y + 1] == 0){
                visit[x][y - 1] = true;
                nextQueue.addLast(new int[]{x - 1, y + 1}); // 西南
            }
            if( (x + 1) < n && (y + 1) < n && !visit[x + 1][y + 1] && grid[x + 1][y + 1] == 0){
                visit[x + 1][y + 1] = true;
                nextQueue.addLast(new int[]{x + 1, y + 1}); // 东南
            }

            if(curQueue.isEmpty()){
                deepth ++;
                curQueue = nextQueue;
                nextQueue = new LinkedList<>();
            }
        }

        return -1;
    }
}
