package Solution.M;

public class MaximumNumberThatSumOfThePricesIsLessThanOrEqualToK {
}

class Solution3007 {
    public long findMaximumNumber(long k, long x) {
        long left = 1L, right = 2000000000000000L;
        while(left < right){
            long mid = left + right + 1 >> 1L;
            if(count(mid, x) > k) right = mid - 1;
            else left = mid;
        }
        return left;
    }

    public long count(long num, long x){
        long result = 0L;
        long base = 1L << (x - 1L);
        while(num >= base){
            result += base * (num / (base * 2)) + Math.max(0, num % (base * 2) + 1 - base);
            base = base << x;
        }
        return result;
    }
}