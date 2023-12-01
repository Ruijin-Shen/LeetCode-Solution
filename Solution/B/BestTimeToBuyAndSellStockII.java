package Solution.B;

public class BestTimeToBuyAndSellStockII {
}

class Solution122 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        boolean hold = false;
        int result = 0;

        for(int i = 0; i < n - 1; i++){
            if(prices[i + 1] > prices[i] && !hold){
                hold = true;
                result -= prices[i];
            }else if(prices[i + 1] <= prices[i] && hold){
                hold = false;
                result += prices[i];
            }
        }
        if(hold) result += prices[n - 1];

        return result;
    }
}