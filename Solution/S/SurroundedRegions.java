package Solution.S;

import java.util.*;
public class SurroundedRegions {
}

class Solution130 {
    private static final int[][] MOVE = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public void solve(char[][] board) {
        int m = board.length, n = board[0].length;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'O' && (i == 0 || i == m - 1 || j == 0 || j == n - 1)){
                    Deque<int[]> queue = new LinkedList<>();
                    queue.addLast(new int[]{i, j});
                    board[i][j] = 'o';
                    while(!queue.isEmpty()){
                        int[] coord = queue.removeFirst();
                        for(int[] move : MOVE){
                            int x = coord[0] + move[0], y = coord[1] + move[1];
                            if(x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 'O'){
                                board[x][y] = 'o';
                                queue.addLast(new int[]{x, y});
                            }
                        }
                    }
                }
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'o') board[i][j] = 'O';
                else board[i][j] = 'X';
            }
        }
    }
}
