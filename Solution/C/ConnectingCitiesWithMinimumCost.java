package Solution.C;

import Template.DisjointSet;

import java.util.Arrays;

public class ConnectingCitiesWithMinimumCost {
}

class Solution1135Kruskal {
    public int minimumCost(int n, int[][] connections) {
        int cost = 0;
        Arrays.sort(connections, (e1, e2) -> e1[2] - e2[2]);
        DisjointSet set = new DisjointSet(n);
        for (int[] edge : connections) {
            int u = edge[0] - 1, v = edge[1] - 1, w = edge[2];
            if (set.find(u) != set.find(v)) {
                cost += w;
                set.union(u, v);
            }
        }
        return set.countComponent() == 1 ? cost : -1;
    }
}