package Solution.F;

import java.util.*;

public class FindEventualSafeStates {
}

class Solution802 {
    private int[] dp;

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        dp = new int[n];

        List<Integer> result = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(isSafe(graph, i)) result.add(i);
        }
        return result;
    }

    private boolean isSafe(int[][] graph, int i){
        if(dp[i] != 0) return (dp[i] == 1 ? true : false);
        dp[i] = -1;

        boolean flag = true;
        for(int next : graph[i]){
            if(dp[next] == -1) flag = false;
            else flag = isSafe(graph, next);

            if(!flag) break;
        }

        dp[i] = (flag ? 1 : -1);
        return flag;
    }
}
