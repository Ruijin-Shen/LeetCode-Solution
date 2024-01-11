package Solution.P;

import java.util.Arrays;

public class PutMarblesInBags {
}

class Solution2551 {
    public long putMarbles(int[] weights, int k) {
        int n = weights.length - 1;
        int[] sum = new int[n];
        for(int i = 1; i <= n; i++){
            sum[i - 1] = weights[i] + weights[i - 1];
        }
        Arrays.sort(sum);

        long result = 0;
        for(int i = 0; i < k - 1; i++){
            result -= sum[i];
            result += sum[n - i - 1];
        }
        return result;
    }
}
