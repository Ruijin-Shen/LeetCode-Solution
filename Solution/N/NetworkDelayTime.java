package Solution.N;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class NetworkDelayTime {
}

class Solution743Dijkstra {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        for(int[] edge : times){
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }

        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        pq.add(new int[]{k, 0});

        while(!pq.isEmpty()){
            int[] u = pq.remove();
            if(distance[u[0]] != Integer.MAX_VALUE) continue;
            distance[u[0]] = u[1];
            for(int[] v : graph.get(u[0])){
                if(distance[v[0]] == Integer.MAX_VALUE) pq.add(new int[]{v[0], u[1] + v[1]});
            }
        }
        int max = 0;
        for(int i = 1; i <= n; i++){
            if(max < distance[i]) max = distance[i];
        }
        return max == Integer.MAX_VALUE ? -1 : max;
    }
}