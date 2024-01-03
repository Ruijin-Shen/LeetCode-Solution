package Solution.C;

import java.util.*;

public class CourseScheduleII {
}

class Solution210 {
    private static final int VISITING = -1;
    private static final int VISITED = 1;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>(numCourses);
        for(int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
        for(int[] pair : prerequisites){
            adj.get(pair[1]).add(pair[0]);
        }

        LinkedList<Integer> result = new LinkedList<>();
        int[] visited = new int[numCourses];
        for(int i = 0; i < numCourses; i++){
            if(!DFS(adj, i, visited, result)) return new int[]{};
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean DFS(List<List<Integer>> adj, int start, int[] visited, LinkedList<Integer> result){
        if(visited[start] == VISITED) return true;
        if(visited[start] == VISITING) return false;

        visited[start] = VISITING;
        for(int next : adj.get(start)){
            if(!DFS(adj, next, visited, result)) return false;
        }
        result.addFirst(start);
        visited[start] = VISITED;
        return true;
    }
}