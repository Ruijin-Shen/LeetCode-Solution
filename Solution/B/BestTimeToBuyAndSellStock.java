package Solution.B;

public class BestTimeToBuyAndSellStock {
}

class Solution121 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int max = prices[n - 1];
        int result = 0;

        for(int i = n - 2; i >= 0; i--){
            result = Math.max(result, max - prices[i]);
            max = Math.max(max, prices[i]);
        }
        return result;
    }
}