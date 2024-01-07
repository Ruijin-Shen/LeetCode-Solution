package Solution.N;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class NumberofProvinces {
}

class Solution547 {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        for(int j = 0; j < n; j++){
            for(int i = 0; i < n; i++){
                if(isConnected[i][j] == 1){
                    for(int k = 0; k < n; k++){
                        isConnected[i][k] = isConnected[i][k] | isConnected[j][k];
                    }
                }
            }
        }

        List<Integer> provinces = new LinkedList<>();
        for(int i = 0; i < n; i++){
            int flag = 1;
            for(int province : provinces){
                if(isConnected[province][i] == 1) {
                    flag = 0;
                    break;
                }
            }
            if(flag == 1){
                provinces.add(i);
            }
        }

        return provinces.size();
    }
}

class Solution547_BFS {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int result = 0;
        boolean[] visit =  new boolean[n];

        for(int i = 0; i < n; i++){
            if(visit[i]) continue;
            // BFS
            Deque<Integer> queue = new LinkedList<>();
            queue.addLast(i);
            visit[i] = true;
            while(!queue.isEmpty()){
                int nextNode = queue.removeFirst();
                for(int j = 0; j < n; j++){
                    if(isConnected[nextNode][j] == 1 && !visit[j]){
                        visit[j] = true;
                        queue.addLast(j);
                    }
                }
            }
            result++;
        }
        return result;
    }
}

class Solution547_DisjointSet {
    public int findCircleNum(int[][] isConnected) {
        int cities = isConnected.length;
        int[] parent = new int[cities];
        for (int i = 0; i < cities; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < cities; i++) {
            for (int j = i + 1; j < cities; j++) {
                if (isConnected[i][j] == 1) {
                    union(parent, i, j);
                }
            }
        }
        int provinces = 0;
        for (int i = 0; i < cities; i++) {
            if (parent[i] == i) {
                provinces++;
            }
        }
        return provinces;
    }

    public void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    public int find(int[] parent, int index) {
        if (parent[index] != index) {
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }
}