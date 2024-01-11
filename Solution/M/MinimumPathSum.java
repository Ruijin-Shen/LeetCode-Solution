package Solution.M;

import java.util.Arrays;

public class MinimumPathSum {
}

class Solution64 {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[1] = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dp[j + 1] = grid[i][j] + Math.min(dp[j], dp[j + 1]);
            }
        }
        return dp[n];
    }
}