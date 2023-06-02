public class DetonateTheMaximumBombs {
}

class Solution2101 {
    public int maximumDetonation(int[][] bombs) {
        // Calculate the adjacency matrix.
        bombs = new int[][]{{1,1,100000}, {100000,100000,1}};
        int num = bombs.length;
        int[][] adj = new int[num][num];
        int maxCount = 0;

        for(int i = 0; i < num; i++){
            for(int j =0; j < num; j++){
                if(i != j && Detonate(bombs[i], bombs[j])){
                    adj[i][j] = 1;
                }else{
                    adj[i][j] = 0;
                }
            }
        }

        // Calculate the connectivity matrix using Warshall algorithm.
        warshall(adj);

        for(int i = 0; i < num; i++){
            int count = 0;
            adj[i][i] = 1;
            for(int j = 0; j < num; j++){
                count += adj[i][j];
            }
            if(count > maxCount){
                maxCount = count;
            }
        }

        return maxCount;
    }

    private boolean Detonate(int[] i, int[] j){
        return (square(i[0] - j[0]) + square(i[1] - j[1])) <= square(i[2]);
    }

    private long square(int x){
        return (long)x * x;
    }

    private void warshall(int[][] adjacency){
        int n = adjacency.length;
        for(int j = 0; j < n; j++){
            for(int i = 0; i < n; i++){
                if(adjacency[i][j] == 1){
                    for(int k = 0; k < n; k++){
                        adjacency[i][k] = adjacency[i][k] | adjacency[j][k];
                    }
                }
            }
        }
    }
}
