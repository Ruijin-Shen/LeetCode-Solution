package Solution.F;

public class FactorialTrailingZeroes {
}

class Solution172 {
    public int trailingZeroes(int n) {
        int fiveCount = 0;
        int base = 5;
        while(n >= base){
            fiveCount += n /base;
            base *= 5;
        }
        return fiveCount;
    }
}