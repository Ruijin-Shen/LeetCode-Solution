package Solution.M;

public class MaximalSquare {
}

class Solution221 {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1]; // result, left, up
        int result = 0;
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(matrix[i - 1][j - 1] == '0') continue;
                dp[i][j] = 1 + min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]);
                result = Math.max(result, dp[i][j]);
            }
        }
        // System.out.println(Arrays.deepToString(dp));
        return result * result;
    }

    private static int min(int... arr){
        int result = Integer.MAX_VALUE;
        for(int val : arr){
            if(val < result) result = val;
        }
        return result;
    }
}