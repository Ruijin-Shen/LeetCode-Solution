import java.util.Arrays;

public class CoinChange {
}

class Solution322Recursion {
    private int[] dp;

    public int coinChange(int[] coins, int amount) {
        if(amount < 1) return 0;
        dp = new int[amount + 1];
        return solve(coins, amount);
    }

    public int solve(int[] coins, int amount){
        if(amount == 0) return 0;
        if(dp[amount] != 0) return dp[amount];

        int result = Integer.MAX_VALUE;
        for(int coin : coins){
            if(amount >= coin){
                int temp = solve(coins, amount - coin);
                if(temp != -1 && temp < result) result = temp;
            }
        }
        return dp[amount] = result == Integer.MAX_VALUE ? -1 : result + 1;
    }
}

class Solution322Iteration {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}