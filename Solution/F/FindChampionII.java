package Solution.F;

public class FindChampionII {
}

class Solution2924 {
    public int findChampion(int n, int[][] edges) {
        int m = edges.length;
        int[] indegree = new int[n];
        for(int i = 0; i < m; i++){
            indegree[edges[i][1]]++;
        }

        int result = -1;
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0){
                if(result >= 0) return -1;
                result = i;
            }
        }
        return result;
    }
}