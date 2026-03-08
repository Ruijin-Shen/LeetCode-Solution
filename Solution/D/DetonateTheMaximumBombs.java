package Solution.D;

import java.util.*;

public class DetonateTheMaximumBombs {
}

class Solution2101_Warshall {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        boolean[][] d = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int[] x = bombs[i], y = bombs[j];
                if (i == j || ((long)x[0] - y[0]) * (x[0] - y[0]) + ((long)x[1] - y[1]) * (x[1] - y[1]) <= (long)x[2] * x[2]) {
                    d[i][j] = true;
                }
            }
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    d[i][j] = d[i][j] || (d[i][k] && d[k][j]);
                }
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (d[i][j]) count++;
            }
            result = Math.max(count, result);
        }
        return result;
    }
}


class Solution2101_BFS{
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;

        // 引爆关系有向图
        HashMap<Integer, List<Integer>> edges = new HashMap<>();
        for(int i = 0; i < n; i++){
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < n; j++){
                if(i != j && isConnected(bombs[i], bombs[j])){
                    list.add(j);
                }
            }
            edges.put(i, list);
        }

        // BFS遍历
        Deque<Integer> queue = new LinkedList<>();
        int result = 0;
        for(int i = 0; i < n; i++){
            boolean[] visit = new boolean[n];
            queue.addLast(i);
            visit[i] = true;
            int count = 1;

            while(!queue.isEmpty()){
                int nextNode = queue.removeFirst();
                List<Integer> edge = edges.get(nextNode);
                for(Integer v : edge){
                    if(!visit[v]){
                        visit[v] = true;
                        queue.addLast(v);
                        count++;
                    }
                }
            }
            result = Math.max(result, count);
        }
        return result;
    }

    private boolean isConnected(int[] u, int[] v){
        long dx = u[0] - v[0];
        long dy = u[1] - v[1];
        return dx * dx + dy * dy <= (long)u[2] * u[2];
    }
}