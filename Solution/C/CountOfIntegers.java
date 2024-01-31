package Solution.C;

import java.util.Arrays;

public class CountOfIntegers {
}

class Solution2719DigitDP{
    private static final int MOD = 1_000_000_007;

    public int count(String num1, String num2, int minSum, int maxSum){
        int ans = solve(num2, minSum, maxSum) - solve(num1, minSum, maxSum);

        int count = 0;
        for(char ch : num1.toCharArray()) {
            count += ch - '0';
        }
        if(count >= minSum && count <= maxSum) ans++;
        return (ans + MOD) % MOD;
    }

    private int solve(String s, int minSum, int maxSum){
        int n = s.length();
        int[][] dp = new int[n][Math.min(9 * n, maxSum) + 1];
        for(int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        return dfs(0, 0, true, s.toCharArray(), minSum, maxSum, dp);
    }

    private int dfs(int index, int sum, boolean limit, char[] s, int minSum, int maxSum, int[][] dp){
        if(sum > maxSum) return 0;
        if(index == s.length) return sum >= minSum ? 1 : 0;
        if(!limit && dp[index][sum] != -1) return dp[index][sum];

        int digitMax = limit ? s[index] - '0' : 9;
        int result = 0;
        for(int digit = 0; digit <= digitMax; digit++){
            result += dfs(index + 1, sum + digit, limit && digit == digitMax, s, minSum, maxSum, dp);
            result %= MOD;
        }
        if(!limit) dp[index][sum] = result;
        return result;
    }
}

class Solution2719DigitDPOptimized{
    private static final int MOD = 1_000_000_007;

    public int count(String num1, String num2, int minSum, int maxSum){
        int n = num2.length();
        num1 = "0".repeat(n - num1.length()) + num1;

        int[][] dp = new int[n][Math.min(9 * n, maxSum) + 1];
        for(int[] row : dp) Arrays.fill(row, -1);

        return solve(0, 0, minSum, maxSum, true, true, num1.toCharArray(), num2.toCharArray(), dp);
    }

    private int solve(int index, int sum, int minSum, int maxSum, boolean limitL, boolean limitH, char[] num1, char[] num2, int[][] dp){
        if(sum > maxSum) return 0;
        if(index == num1.length) return sum >= minSum ? 1 : 0;
        if(!limitL && !limitH && dp[index][sum] != -1) return dp[index][sum];

        int result = 0;
        int digitMin = limitL ? num1[index] - '0' : 0;
        int digitMax = limitH ? num2[index] - '0' : 9;
        for(int digit = digitMin; digit <= digitMax; digit++){
            result += solve(index + 1, sum + digit, minSum, maxSum, limitL && digit == digitMin, limitH && digit == digitMax, num1, num2, dp);
            result %= MOD;
        }
        if(!limitL && !limitH) dp[index][sum] = result;
        return result;
    }
}
