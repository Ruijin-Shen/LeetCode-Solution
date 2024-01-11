package Solution.M;

import java.awt.*;
import java.util.*;

public class MinCostToConnectAllPoints {
}

class Solution1584Kruskal {
    static class DisjointSet{
        private final int[] parent;

        public DisjointSet(int size){
            parent = new int[size];
            for(int i = 0; i < size; i++) parent[i] = i;
        }

        public int find(int index){
            if(parent[index] != index) parent[index] = find(parent[index]);
            return parent[index];
        }

        public boolean union(int x, int y){
            int rootX = find(x), rootY = find(y);
            if(rootX == rootY) return false;
            parent[rootX] = rootY;
            return true;
        }
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        ArrayList<int[]> edges = new ArrayList<>();
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                int weight = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                edges.add(new int[]{weight, i, j});
            }
        }

        edges.sort(Comparator.comparing(x->x[0]));
        DisjointSet set = new DisjointSet(n);
        int cost = 0, num = 0;
        for(int i = 0; i < edges.size() && num < n - 1; i++){
            int[] edge = edges.get(i);
            if(set.union(edge[1], edge[2])){
                cost += edge[0];
                num++;
            }
        }
        return cost;
    }
}

class Solution1584Prim {
    record Pair(int vertex, int weight){}
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparing(Pair::weight));
        pq.add(new Pair(0, 0));  // the first point
        boolean[] inMST = new boolean[n];
        int cost = 0, num = 0;
        while(num < n){
            Pair pair = pq.remove();
            if(inMST[pair.vertex]) continue;
            inMST[pair.vertex] = true;
            cost += pair.weight;
            num++;
            for(int nextVertex = 0; nextVertex < n; nextVertex++){
                if(!inMST[nextVertex]){
                    int weight = Math.abs(points[pair.vertex][0] - points[nextVertex][0]) + Math.abs(points[pair.vertex][1] - points[nextVertex][1]);
                    pq.add(new Pair(nextVertex, weight));
                }
            }
        }
        return cost;
    }
}