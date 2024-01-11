package Solution.P;

import java.util.Arrays;

public class PerfectSquares {
}

class Solution279MySolution {
    private static final int[] sq = new int[100];
    {
        for(int i = 1; i <= 100; i++){
            sq[i - 1] = i * i;
        }
    }

    private static final int[] memorization =  new int[10001];
    {
        Arrays.fill(memorization, -1);
        for(int i = 1; i <= 100; i++){
            memorization[i * i] = 1;
        }
    }

    public int numSquares(int n) {
        if(memorization[n] > 0) return memorization[n];

        int result = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            if(sq[i] < n) result = Math.min(result, 1 + numSquares(n - sq[i]));
            else break;
        }

        memorization[n] = result;
        return result;
    }
}

class Solution279DynamicProgramming {
    private static final int[] memorization = new int[10001];
    private static int hasCompute = 0;
    public int numSquares(int n) {
        for(int i = hasCompute + 1; i <= n; i++){
            int result = Integer.MAX_VALUE;
            for(int j = 1; j * j <= i; j++){
                result = Math.min(result, memorization[i - j * j]);
            }
            memorization[i] = result + 1;
        }
        hasCompute = Math.max(hasCompute, n);
        return memorization[n];
    }
}