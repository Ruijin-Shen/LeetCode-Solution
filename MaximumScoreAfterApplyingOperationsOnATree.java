import java.util.*;

public class MaximumScoreAfterApplyingOperationsOnATree {
}

class Solution2925 {
    private boolean[] visited;
    private HashMap<Integer, List<Integer>> map;
    public long maximumScoreAfterOperations(int[][] edges, int[] values) {
        int n = values.length;
        long total = 0;
        for(int i = 0; i < n; i++){
            total += values[i];
        }

        map = new HashMap<>();
        for(int i = 0; i < n - 1; i++){  // Tree has n-1 edges
            int u = edges[i][0], v = edges[i][1];
            if(!map.containsKey(u)) map.put(u, new LinkedList<>());
            if(!map.containsKey(v)) map.put(v, new LinkedList<>());
            map.get(u).add(v);
            map.get(v).add(u);
        }

        visited = new boolean[n];
        visited[0] = true;
        long sum = DFS(0, values);
        return total - sum;
    }

    private long DFS(int node, int[] values){
        long value = values[node];
        long subtreeSum = 0;
        for(int nextNode : map.get(node)){
            if(!visited[nextNode]){
                visited[nextNode] = true;
                subtreeSum += DFS(nextNode, values);
            }
        }
        if(subtreeSum == 0) return value;
        value = Math.min(value, subtreeSum);
        return value;
    }

}