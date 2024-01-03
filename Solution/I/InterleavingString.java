package Solution.I;

public class InterleavingString {
}

class Solution97DynamicProgramming {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        if(m + n != s3.length()) return false;
        if(s3.length() == 0) return true;

        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;

        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                if(i - 1 >= 0 && s3.charAt(i + j - 1) == s1.charAt(i - 1)){
                    dp[i][j] |= dp[i - 1][j];
                }
                if(j - 1 >= 0 && s3.charAt(i + j - 1) == s2.charAt(j - 1)){
                    dp[i][j] |= dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}