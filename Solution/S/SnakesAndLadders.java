package Solution.S;

import java.util.*;

public class SnakesAndLadders {
}

class Solution909 {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int nsq = n * n;
        HashMap<Integer, Integer> ladder = new HashMap<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] != -1){
                    int index = ((i + n) % 2 == 0) ? nsq - (i * n + j) : nsq - ((i + 1) * n - 1 - j);
                    ladder.put(index, board[i][j]);
                }
            }
        }

        boolean[] visited = new boolean[nsq + 1];
        visited[1] = true;
        Deque<Integer> queue = new LinkedList<>();
        queue.addLast(1);
        int depth = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int curr = queue.removeFirst();
                for(int next = curr + 1; next <= Math.min(curr + 6, nsq); next++){
                    int index = ladder.getOrDefault(next, next);
                    if(!visited[index]){
                        visited[index] = true;
                        queue.addLast(index);
                        if(index == nsq) return depth + 1;
                    }
                }
            }
            depth++;
        }
        return -1;
    }
}
