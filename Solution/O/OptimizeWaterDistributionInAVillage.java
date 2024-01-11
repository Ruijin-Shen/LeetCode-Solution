package Solution.O;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class OptimizeWaterDistributionInAVillage {
}

class Solution1168 {
    record Pair(int vertex, int weight){}
    public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
        List<List<Pair>> adj = new ArrayList<>(n + 1);
        for(int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        for(int i = 1; i <= n; i++) adj.get(0).add(new Pair(i, wells[i - 1]));
        for(int[] pipe : pipes){
            adj.get(pipe[0]).add(new Pair(pipe[1], pipe[2]));
        }

        int cost = 0, num = 0;
        boolean[] inMST = new boolean[n + 1];
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparing(Pair::weight));
        pq.add(new Pair(0, 0));
        while(num < n + 1 && !pq.isEmpty()){
            Pair pair = pq.remove();
            if(inMST[pair.vertex]) continue;
            inMST[pair.vertex] = true;
            cost += pair.weight;
            num++;

            for(Pair nextVertex : adj.get(pair.vertex)){
                if(!inMST[nextVertex.vertex]){
                    pq.add(nextVertex);
                }
            }
        }
        return cost;
    }
}