package Solution.F;

import java.util.Arrays;

public class FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance {
}

class Solution1334 {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] distance = new int[n][n];
        for(int[] row : distance) Arrays.fill(row, Integer.MAX_VALUE);
        for(int[] edge : edges){
            int u = edge[0], v = edge[1], w = edge[2];
            distance[u][v] = distance[v][u] = w;
        }
        for(int i = 0; i < n; i++) distance[i][i] = 0;

        // Floyd-Warshall
        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(distance[i][k] != Integer.MAX_VALUE && distance[k][j] != Integer.MAX_VALUE){
                        distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                    }
                }
            }
        }
        int result = 0, neighbors = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            int count = 0;
            for(int j = 0; j < n; j++){
                if(distance[i][j] <= distanceThreshold) count++;
            }
            if(count <= neighbors){
                neighbors = count;
                result = i;
            }
        }
        return result;
    }
}