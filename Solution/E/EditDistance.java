package Solution.E;

public class EditDistance {
}

class Solution72 {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 1; i <= m; i++) dp[i][0] = i;
        for(int j = 1; j <= n; j++) dp[0][j] = j;

        // dynamic-programming
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                dp[i][j] = min(
                        (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1) + dp[i - 1][j - 1],  // match or replace
                        1 + dp[i - 1][j],  // insert
                        1 + dp[i][j - 1] // delete
                );
            }
        }
        return dp[m][n];
    }

    private static int min(int... arr){
        int result = Integer.MAX_VALUE;
        for(int val : arr){
            if(val < result) result = val;
        }
        return result;
    }
}