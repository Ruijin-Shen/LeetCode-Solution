public class NumberOfIncreasingPathsInAGrid {
}

class Solution2328 {
    private static final int modulo = 1_000_000_007;
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int[][] dp;

    public int countPaths(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        dp = new int[m][n];

        int answer = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                answer = (answer + dfs(grid, i, j)) % modulo;
            }
        }
        return answer;
    }

    private int dfs(int[][] grid, int i, int j){
        if(dp[i][j] != 0) return dp[i][j];

        int answer = 1;

        for(int[] index : directions){
            int x = index[0] + i, y = index[1] + j;

            if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[i][j] > grid[x][y]){
                answer += dfs(grid, x, y);
                answer %= modulo;
            }
        }
        dp[i][j] = answer;
        return answer;
    }
}