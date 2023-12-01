package Solution.C;

import java.util.Arrays;

public class CountAllPossibleRoutes {
}

class Solution1575ReCursiveDynamicProgramming {
    private static Long[][] dp;
    private static final int module = 1000000007;

    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        dp = new Long[locations.length][fuel];
        for(int i = 0; i < locations.length; i++){
            for(int j = 0; j < fuel; j++){
                dp[i][j] = -1L;
            }
        }
        return (int)compute(locations, start, finish, fuel);
    }

    private long compute(int[] locations, int start, int finish, int fuel){
        if(Math.abs(locations[finish] - locations[start]) > fuel) return 0;
        if(dp[start][fuel] != -1) return dp[start][fuel];

        long count = start == finish ? 1 : 0; // direct

        for(int nextLoc = 0; nextLoc < locations.length; nextLoc++){
            if(nextLoc != start){
                count = (count + compute(locations, nextLoc, finish, fuel - Math.abs(locations[nextLoc] - locations[start]))) % module;
            }
        }

        return dp[start][fuel] = count;
    }
}

class Solution1575IterativeDynamicProgramming {
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int n = locations.length;
        int dp[][] = new int[n][fuel + 1];
        Arrays.fill(dp[finish], 1);

        for(int j = 0; j <= fuel; j++){
            for(int i = 0; i < n; i++){
                for(int k = 0; k < n; k++){
                    if(k == i) continue;
                    if(Math.abs(locations[i] - locations[k]) <= j){
                        dp[i][j] = (dp[i][j] + dp[k][j - Math.abs(locations[i] - locations[k])]) % 1000000007;
                    }
                }
            }
        }
        return dp[start][fuel];
    }
}
