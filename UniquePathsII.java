public class UniquePathsII {
}

class Solution63DynamicProgramming {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if(obstacleGrid[m - 1][n - 1] == 1 || obstacleGrid[0][0] == 1) return 0;

        int[] count = new int[n];
        count[0] = 1;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(obstacleGrid[i][j] == 1){
                    count[j] = 0;
                    continue;
                }
                if(j - 1 >= 0) count[j] += count[j - 1];
            }
        }
        return count[n - 1];
    }
}